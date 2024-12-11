package xyz.tcheeric.phoenixd.request.impl.rest.test;

import org.junit.jupiter.api.Test;
import xyz.tcheeric.phoenixd.model.param.PayBolt11InvoiceParam;
import xyz.tcheeric.phoenixd.operation.impl.PostOperation;
import xyz.tcheeric.phoenixd.request.impl.rest.PayBolt11InvoiceRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PayBolt11InvoiceRequestTest {

    @Test
    public void testConstructor() {
        // Arrange
        PayBolt11InvoiceParam payBolt11InvoiceParam = new PayBolt11InvoiceParam();
        payBolt11InvoiceParam.setInvoice("lnbc1u1pw0kx7pp5");
        payBolt11InvoiceParam.setAmountSat(10);
        PayBolt11InvoiceRequest payBolt11InvoiceRequest = new PayBolt11InvoiceRequest(payBolt11InvoiceParam);

        // Assert
        assertEquals("/payinvoice", payBolt11InvoiceRequest.getPath());
        assertEquals(payBolt11InvoiceParam, payBolt11InvoiceRequest.getParam());
        assertEquals(PostOperation.class, payBolt11InvoiceRequest.getOperation().getClass());
        assertEquals(payBolt11InvoiceParam.toString(), payBolt11InvoiceRequest.getOperation().getRequestData());
    }
}
