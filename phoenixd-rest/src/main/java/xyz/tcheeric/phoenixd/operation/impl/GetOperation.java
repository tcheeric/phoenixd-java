package xyz.tcheeric.phoenixd.operation.impl;

import cashu.gateway.model.Request;
import cashu.gateway.rest.Operation;
import lombok.NonNull;
import lombok.SneakyThrows;
import xyz.tcheeric.phoenixd.operation.AbstractOperation;
import xyz.tcheeric.phoenixd.util.Constants;

import java.net.http.HttpRequest;

public class GetOperation extends AbstractOperation {

    public GetOperation(HttpRequest httpRequest) {
        super(httpRequest);
    }

    @SneakyThrows
    public GetOperation(@NonNull String path) {
        super(Constants.HTTP_GET_METHOD, path, null);
    }

    @SneakyThrows
    public GetOperation(@NonNull String path, @NonNull Request.Param requestParam) {
        super(Constants.HTTP_GET_METHOD, path, requestParam, null);
    }
}
