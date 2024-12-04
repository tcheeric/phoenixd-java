package xyz.tcheeric.phoenixd.api.operation.impl;

import cashu.gateway.model.Request;
import cashu.gateway.rest.Operation;
import lombok.NonNull;
import lombok.SneakyThrows;
import xyz.tcheeric.phoenixd.api.operation.AbstractOperation;
import xyz.tcheeric.phoenixd.api.util.Constants;

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

    @Override
    public Operation removeHeader(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Operation addHeader(String key, String value) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
