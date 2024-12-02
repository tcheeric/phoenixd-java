package xyz.tcheeric.phoenixd.api.operation.impl;

import cashu.gateway.model.Request;
import cashu.gateway.rest.Constants;
import cashu.gateway.rest.Operation;
import lombok.NonNull;
import lombok.SneakyThrows;
import xyz.tcheeric.phoenixd.api.operation.AbstractOperation;

import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;

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

    // TODO
    @Override
    public Operation removeHeader(String key) {
        HttpHeaders headers = httpRequest.headers();
        // Complete the implementation

        return null;
    }

    @Override
    public Operation addHeader(String key, String value) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
