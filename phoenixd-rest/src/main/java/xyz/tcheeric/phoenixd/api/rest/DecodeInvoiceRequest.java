package xyz.tcheeric.phoenixd.api.rest;

import xyz.tcheeric.phoenixd.api.model.rest.DecodeInvoiceParam;
import xyz.tcheeric.phoenixd.api.model.rest.DecodeInvoiceResponse;
import xyz.tcheeric.phoenixd.api.request.impl.PostRequest;

public class DecodeInvoiceRequest extends PostRequest<DecodeInvoiceParam, DecodeInvoiceResponse> {

    public DecodeInvoiceRequest(DecodeInvoiceParam param) {
        super("/decodeinvoice", param);
    }
}
