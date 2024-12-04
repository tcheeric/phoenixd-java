package xyz.tcheeric.phoenixd.api.operation.impl;

import cashu.gateway.model.Request;
import cashu.gateway.rest.Operation;
import lombok.NonNull;
import lombok.SneakyThrows;
import xyz.tcheeric.phoenixd.api.operation.AbstractOperation;
import xyz.tcheeric.phoenixd.api.util.Constants;

import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.Builder;

public class DeleteOperation extends AbstractOperation {

    public DeleteOperation(HttpRequest httpRequest) {
        super(httpRequest);
    }

    @SneakyThrows
    public DeleteOperation(@NonNull String path) {
        super(Constants.HTTP_DELETE_METHOD, path, null);
    }

    @SneakyThrows
    public DeleteOperation(@NonNull String path, @NonNull Request.Param requestParam) {
        super(Constants.HTTP_DELETE_METHOD, path, requestParam, null);
    }

    @Override
    public Operation removeHeader(@NonNull String key) {
        HttpHeaders headers = httpRequest.headers();
        Builder requestBuilder = HttpRequest.newBuilder(httpRequest.uri())
                .method(httpRequest.method(), httpRequest.bodyPublisher().orElse(HttpRequest.BodyPublishers.noBody()));

        headers.map().forEach((headerKey, headerValues) -> {
            if (!headerKey.equalsIgnoreCase(key)) {
                headerValues.forEach(value -> requestBuilder.header(headerKey, value));
            }
        });

        this.httpRequest = requestBuilder.build();
        return this;
    }

    @Override
    public Operation addHeader(String key, String value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}