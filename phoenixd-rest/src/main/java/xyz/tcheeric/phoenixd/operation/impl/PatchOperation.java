package xyz.tcheeric.phoenixd.operation.impl;

import cashu.gateway.model.Request;
import cashu.gateway.rest.Operation;
import lombok.NonNull;
import lombok.SneakyThrows;
import xyz.tcheeric.phoenixd.operation.AbstractOperation;
import xyz.tcheeric.phoenixd.util.Constants;

public class PatchOperation extends AbstractOperation {

    @SneakyThrows
    public PatchOperation(@NonNull String path) {
        super(Constants.HTTP_PATCH_METHOD, path, null);
    }

    @SneakyThrows
    public PatchOperation(@NonNull String path, @NonNull Request.Param param) {
        super(Constants.HTTP_PATCH_METHOD, path, param, null);
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
