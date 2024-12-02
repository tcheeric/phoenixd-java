package xyz.tcheeric.phoenixd.api.model.rest;

import cashu.gateway.model.Response;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PayInvoiceResponse implements Response {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer recipientAmountSat;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer routingFeeSat;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String paymentId;

    private String paymentHash;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String paymentPreimage;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String reason;
}
