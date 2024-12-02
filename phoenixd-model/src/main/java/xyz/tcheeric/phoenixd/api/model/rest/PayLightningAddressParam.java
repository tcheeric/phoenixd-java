package xyz.tcheeric.phoenixd.api.model.rest;

import cashu.gateway.model.Request;
import lombok.Data;

@Data
public class PayLightningAddressParam implements Request.Param {
    private Integer amountSat = 0;
    private String address;
    private String message;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("amountSat=").append(amountSat)
                .append("&address=").append(address);
        if (message != null && !message.isEmpty()) {
            sb.append("&message=").append(message);
        }
        return sb.toString();
    }
}