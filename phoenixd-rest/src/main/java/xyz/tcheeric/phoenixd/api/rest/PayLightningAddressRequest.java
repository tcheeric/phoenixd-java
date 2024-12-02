package xyz.tcheeric.phoenixd.api.rest;

import xyz.tcheeric.phoenixd.api.model.rest.PayLightningAddressParam;
import xyz.tcheeric.phoenixd.api.model.rest.PayLightningAddressInvoiceResponse;

public class PayLightningAddressRequest extends BasePayRequest<PayLightningAddressParam, PayLightningAddressInvoiceResponse> {

    public PayLightningAddressRequest(PayLightningAddressParam param) {
        super("/paylnaddress", param);
    }
}
