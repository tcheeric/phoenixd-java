package xyz.tcheeric.phoenixd.api.model.rest;

import cashu.gateway.model.Response;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateInvoiceResponse implements Response {

    private Integer amountSat;
    private String paymentHash;
    private String serialized;
}
