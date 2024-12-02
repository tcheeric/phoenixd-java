package xyz.tcheeric.phoenixd.api.rest;

import cashu.gateway.model.Request;
import cashu.gateway.model.Response;
import xyz.tcheeric.phoenixd.api.request.impl.PostRequest;

public class BasePayRequest<T extends Request.Param, U extends Response> extends PostRequest<T, U> {

    public BasePayRequest(String path, T param) {
        super(path, param);
    }
}
