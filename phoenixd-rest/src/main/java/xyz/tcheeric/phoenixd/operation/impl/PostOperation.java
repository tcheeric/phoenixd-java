package xyz.tcheeric.phoenixd.operation.impl;

import cashu.gateway.model.Request;
import cashu.gateway.rest.Operation;
import lombok.NonNull;
import lombok.SneakyThrows;
import xyz.tcheeric.phoenixd.operation.AbstractOperation;
import xyz.tcheeric.phoenixd.util.Constants;

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
}
