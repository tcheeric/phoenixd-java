package xyz.tcheeric.phoenixd.api.model.rest;

import cashu.gateway.model.Request;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DecodeInvoiceParam implements Request.Param {

    private String invoice;

    @Override
    public String toString() {
        return "invoice=" + invoice;
    }
}
