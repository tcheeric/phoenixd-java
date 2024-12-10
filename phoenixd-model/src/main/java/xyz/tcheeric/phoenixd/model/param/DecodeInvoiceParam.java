package xyz.tcheeric.phoenixd.model.param;

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
