package xyz.tcheeric.phoenixd.api.request.impl;

import cashu.gateway.model.Request;
import cashu.gateway.model.Response;
import lombok.NonNull;
import xyz.tcheeric.phoenixd.api.operation.impl.DeleteOperation;
import xyz.tcheeric.phoenixd.api.request.AbstractRequest;

public class DeleteRequest<T extends Request.Param, U extends Response> extends AbstractRequest<T, U> {

    public DeleteRequest(String path) {
        super(path, null, new DeleteOperation(path));
    }

    public DeleteRequest(String path, Param param) {
        super(path, param, new DeleteOperation(path, param));
    }
    
    public void removeHeader(@NonNull String key) {
        this.getOperation().removeHeader(key);
    }
}
