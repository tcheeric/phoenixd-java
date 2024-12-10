package xyz.tcheeric.phoenixd.model.response;

import cashu.gateway.model.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetLightningAddressResponse implements Response {
    private String lightningAddress;
}