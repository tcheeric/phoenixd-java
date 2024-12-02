package xyz.tcheeric.phoenixd.api.request.impl;

import cashu.gateway.model.Request;
import cashu.gateway.model.Response;
import lombok.Getter;
import lombok.NonNull;
import xyz.tcheeric.phoenixd.api.operation.impl.GetOperation;
import xyz.tcheeric.phoenixd.api.request.AbstractRequest;

@Getter
public class GetRequest<T extends Request.Param, U extends Response> extends AbstractRequest<T, U> {

    public GetRequest(@NonNull String path) {
        super(path, null, new GetOperation(path));
    }

    public GetRequest(@NonNull String path, @NonNull Param param) {
        super(path, param, new GetOperation(path, param));
    }

}
