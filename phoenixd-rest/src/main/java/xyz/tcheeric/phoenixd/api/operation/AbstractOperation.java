package xyz.tcheeric.phoenixd.api.operation;

import cashu.gateway.model.Request;
import cashu.gateway.rest.Operation;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.SneakyThrows;
import xyz.tcheeric.phoenixd.api.util.Configuration;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Base64;
import java.util.concurrent.CompletableFuture;

@NoArgsConstructor
@Data
public abstract class AbstractOperation implements Operation {

    protected HttpRequest httpRequest;
    private String body;

    public AbstractOperation(@NonNull HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
    }

    @SneakyThrows
    public AbstractOperation(@NonNull String method, @NonNull String path, String data) {
        String username = Configuration.getUsername();
        String password = Configuration.getPassword();
        String baseUrl = Configuration.getBaseUrl();
        long timeout = Configuration.getTimeout();
        String auth = username + ":" + password;
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));

        this.body = data;

        HttpRequest.BodyPublisher bodyPublisher = data == null ? HttpRequest.BodyPublishers.noBody() : HttpRequest.BodyPublishers.ofString(data);

        this.httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + path))
                .header("Authorization", "Basic " + encodedAuth)
                //.header("Accept", Constants.APP_JSON_CONTENT_TYPE)
                .timeout(Duration.ofMillis(timeout))
                .method(method, bodyPublisher)
                .build();
    }

    @SneakyThrows
    public AbstractOperation(@NonNull String method, @NonNull String path, @NonNull Request.Param param, String data) {
        String username = Configuration.getUsername();
        String password = Configuration.getPassword();
        String auth = username + ":" + password;
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));
        long timeout = Configuration.getTimeout();

        this.body = data;

        HttpRequest.BodyPublisher bodyPublisher = data == null ? HttpRequest.BodyPublishers.noBody() : HttpRequest.BodyPublishers.ofString(data);

        var separator = param.getKind() == Request.Param.Kind.PATH ? "/" : "?";
        this.httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(Configuration.getBaseUrl() + replacePathVariables(path, param) + separator + param))
                .header("Authorization", "Basic " + encodedAuth)
                //.header("Accept", Constants.APP_JSON_CONTENT_TYPE)
                .timeout(Duration.ofMillis(timeout))
                .method(method, bodyPublisher)
                .build();
    }

    @SneakyThrows
    @Override
    public Operation execute() {
        CompletableFuture<HttpResponse<String>> response = HttpClient.newBuilder()
                .build()
                .sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
        this.body = response.get().body();
        var statusCode = response.get().statusCode();
        if (statusCode < 200 || statusCode >= 300) {
            throw new IOException("Failed to create invoice: " + statusCode + " " + body);
        }
        return this;
    }
    public String getHeader(@NonNull String key) {
        return httpRequest.headers().firstValue(key).orElse(null);
    }
}
