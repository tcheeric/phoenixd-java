package xyz.tcheeric.phoenixd.api.operation.impl;

import cashu.gateway.model.Request;
import cashu.gateway.rest.Constants;
import cashu.gateway.rest.Operation;
import lombok.NonNull;
import lombok.SneakyThrows;
import xyz.tcheeric.phoenixd.api.operation.AbstractOperation;

import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PostOperation extends AbstractOperation {

    public PostOperation(HttpRequest httpRequest) {
        super(httpRequest);
    }

    public PostOperation(@NonNull String path, @NonNull String data) {
        super(Constants.HTTP_POST_METHOD, path, data);
        this.addHeader("Content-Type", "application/x-www-form-urlencoded");
    }

    @SneakyThrows
    public PostOperation(@NonNull String path, @NonNull Request.Param param, @NonNull String data) {
        super(Constants.HTTP_POST_METHOD, path, param, data);
        this.addHeader("Content-Type", "application/x-www-form-urlencoded");
    }

    @Override
    public Operation addHeader(@NonNull String key, @NonNull String value) {
        HttpHeaders headers = httpRequest.headers();
        Map<String, List<String>> headersMap = headers.map();
        Map<String, List<String>> newHeadersMap = headersMap.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));
        newHeadersMap.put(key, List.of(value));

        HttpRequest newHttpRequest = HttpRequest.newBuilder()
                .uri(httpRequest.uri())
                .timeout(httpRequest.timeout().orElse(null))
                .headers(newHeadersMap.entrySet().stream()
                        .flatMap(e -> e.getValue().stream().map(v -> Map.entry(e.getKey(), v)))
                        .flatMap(e -> Stream.of(e.getKey(), e.getValue()))
                        .toArray(String[]::new))
                .POST(httpRequest.bodyPublisher().orElse(HttpRequest.BodyPublishers.noBody()))
                .build();

        this.setHttpRequest(newHttpRequest);

        return new PostOperation(newHttpRequest);
    }

    @Override
    public Operation removeHeader(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
