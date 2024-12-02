package xyz.tcheeric.phoenixd.api.rest;

import xyz.tcheeric.phoenixd.api.request.impl.PostRequest;
import xyz.tcheeric.phoenixd.api.model.rest.CreateInvoiceParam;
import xyz.tcheeric.phoenixd.api.model.rest.CreateInvoiceResponse;

public class CreateBolt11InvoiceRequest extends PostRequest<CreateInvoiceParam, CreateInvoiceResponse> {

    public CreateBolt11InvoiceRequest(CreateInvoiceParam param) {
        super("/createinvoice", param);
    }
}
