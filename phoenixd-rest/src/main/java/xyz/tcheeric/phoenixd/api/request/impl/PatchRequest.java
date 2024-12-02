package xyz.tcheeric.phoenixd.api.request.impl;

import cashu.gateway.model.Request;
import cashu.gateway.model.Response;
import lombok.Getter;
import lombok.NonNull;
import xyz.tcheeric.phoenixd.api.operation.impl.PatchOperation;
import xyz.tcheeric.phoenixd.api.request.AbstractRequest;

@Getter
public class PatchRequest<T extends Request.Param, U extends Response> extends AbstractRequest<T, U> {

    public PatchRequest(@NonNull String path) {
        super(path, null, new PatchOperation(path));
    }

    public PatchRequest(@NonNull String path, @NonNull Param param) {
        super(path, param, new PatchOperation(path, param));
    }
}
