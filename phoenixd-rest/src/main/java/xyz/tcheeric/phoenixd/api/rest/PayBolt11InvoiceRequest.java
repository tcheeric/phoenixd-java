package xyz.tcheeric.phoenixd.api.rest;

import xyz.tcheeric.phoenixd.api.model.rest.PayBolt11InvoiceParam;
import xyz.tcheeric.phoenixd.api.model.rest.PayBolt11InvoiceInvoiceResponse;

public class PayBolt11InvoiceRequest extends BasePayRequest<PayBolt11InvoiceParam, PayBolt11InvoiceInvoiceResponse> {

    public PayBolt11InvoiceRequest(PayBolt11InvoiceParam param) {
        super("/payinvoice", param);
    }
}
