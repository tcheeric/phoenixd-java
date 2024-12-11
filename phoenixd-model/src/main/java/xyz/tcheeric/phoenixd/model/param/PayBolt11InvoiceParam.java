package xyz.tcheeric.phoenixd.model.param;

import lombok.Data;
import xyz.tcheeric.common.rest.Request;

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