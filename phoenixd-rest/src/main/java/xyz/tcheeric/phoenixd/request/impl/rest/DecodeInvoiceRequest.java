package xyz.tcheeric.phoenixd.request.impl.rest;

import xyz.tcheeric.phoenixd.model.param.DecodeInvoiceParam;
import xyz.tcheeric.phoenixd.model.response.DecodeInvoiceResponse;
import xyz.tcheeric.phoenixd.request.impl.PostRequest;

public class DecodeInvoiceRequest extends PostRequest<DecodeInvoiceParam, DecodeInvoiceResponse> {

    public DecodeInvoiceRequest(DecodeInvoiceParam param) {
        super("/decodeinvoice", param);
    }
}
