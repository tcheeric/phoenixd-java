package xyz.tcheeric.phoenixd.request.impl.rest;

import xyz.tcheeric.phoenixd.model.param.PayLightningAddressParam;
import xyz.tcheeric.phoenixd.model.response.PayLightningAddressInvoiceResponse;

public class PayLightningAddressRequest extends BasePayRequest<PayLightningAddressParam, PayLightningAddressInvoiceResponse> {

    public PayLightningAddressRequest(PayLightningAddressParam param) {
        super("/paylnaddress", param);
    }
}
