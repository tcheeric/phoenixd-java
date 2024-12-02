package xyz.tcheeric.phoenixd.api.request.impl;

import cashu.gateway.model.Request;
import cashu.gateway.model.Response;
import lombok.Getter;
import lombok.NonNull;
import xyz.tcheeric.phoenixd.api.operation.impl.PostOperation;
import xyz.tcheeric.phoenixd.api.request.AbstractRequest;

@Getter
public class PostRequest<T extends Request.Param, U extends Response> extends AbstractRequest<T, U> {

    public PostRequest(@NonNull String path, @NonNull Param param) {
        super(path, param, new PostOperation(path, param.toString()));
    }

    public PostRequest(@NonNull String path, @NonNull String body) {
        super(path, null, new PostOperation(path, body));
    }

    public PostRequest(@NonNull String path, @NonNull Param param, @NonNull String body) {
        super(path, param, new PostOperation(path, param, body));
    }

    public void addHeader(@NonNull String key, @NonNull String value) {
        this.getOperation().addHeader(key, value);
    }
    
}
