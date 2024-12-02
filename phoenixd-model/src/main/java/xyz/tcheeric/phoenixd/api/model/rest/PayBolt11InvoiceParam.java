package xyz.tcheeric.phoenixd.api.model.rest;

import cashu.gateway.model.Request;
import lombok.Data;

@Data
public class PayBolt11InvoiceParam implements Request.Param {

    private Integer amountSat = 0;
    private String invoice = "";

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("amountSat=").append(amountSat)
                .append("&invoice=").append(invoice);
        return sb.toString();
    }
}