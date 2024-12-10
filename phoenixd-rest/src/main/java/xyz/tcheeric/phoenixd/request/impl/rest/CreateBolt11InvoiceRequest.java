package xyz.tcheeric.phoenixd.request.impl.rest;

import xyz.tcheeric.phoenixd.request.impl.PostRequest;
import xyz.tcheeric.phoenixd.model.param.CreateInvoiceParam;
import xyz.tcheeric.phoenixd.model.response.CreateInvoiceResponse;

public class CreateBolt11InvoiceRequest extends PostRequest<CreateInvoiceParam, CreateInvoiceResponse> {

    public CreateBolt11InvoiceRequest(CreateInvoiceParam param) {
        super("/createinvoice", param);
    }
}
