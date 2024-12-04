package xyz.tcheeric.phoenixd.api.request;

import cashu.gateway.model.Request;
import cashu.gateway.model.Response;
import cashu.gateway.model.VoidResponse;
import cashu.gateway.rest.Operation;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;

@Data
@RequiredArgsConstructor
public abstract class AbstractRequest<T extends Request.Param, U extends Response> implements Request<T, U> {
    private final String path;
    private final Param param;
    private final Operation operation;

    @SneakyThrows
    @Override
    public U getResponse() {
        Class<U> responseType = getResponseType();
        if (VoidResponse.class.isAssignableFrom(responseType)) {
            return (U) new VoidResponse();
        }
        String body = this.getOperation().execute().getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(body, responseType);
    }

    private Class<U> getResponseType() {
        ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<U>) superClass.getActualTypeArguments()[1];
    }
}