package xyz.tcheeric.phoenixd.request.impl.rest;

import xyz.tcheeric.phoenixd.model.param.PayBolt11InvoiceParam;
import xyz.tcheeric.phoenixd.model.response.PayBolt11InvoiceInvoiceResponse;

public class PayBolt11InvoiceRequest extends BasePayRequest<PayBolt11InvoiceParam, PayBolt11InvoiceInvoiceResponse> {

    public PayBolt11InvoiceRequest(PayBolt11InvoiceParam param) {
        super("/payinvoice", param);
    }
}
