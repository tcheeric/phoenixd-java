package xyz.tcheeric.phoenixd.api.rest.test;

import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import xyz.tcheeric.phoenixd.api.model.rest.CreateInvoiceParam;
import xyz.tcheeric.phoenixd.api.model.rest.CreateInvoiceResponse;
import xyz.tcheeric.phoenixd.api.rest.CreateBolt11InvoiceRequest;

import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Log
public class CreateBolt11InvoiceRequestTest {

    @Test
    public void testConstructor() {
        // Arrange and Act
        CreateBolt11InvoiceRequest createBolt11InvoiceRequest = new CreateBolt11InvoiceRequest(new CreateInvoiceParam());

        // Assert
        assertEquals("/createinvoice", createBolt11InvoiceRequest.getPath());
    }

    @Test
    public void testAddHeader() {
        // Arrange
        CreateBolt11InvoiceRequest createBolt11InvoiceRequest = new CreateBolt11InvoiceRequest(new CreateInvoiceParam());

        // Act
        createBolt11InvoiceRequest.addHeader("key", "value");

        // Assert
        assertEquals("value", createBolt11InvoiceRequest.getOperation().getHeader("key"));
    }

    @SneakyThrows
    @Test
    public void testGetResponse() {
        // Arrange
        CreateInvoiceParam param = new CreateInvoiceParam();
        param.setAmountSat(10);
        param.setExpirySeconds(3600);
        param.setDescription("test description: testGetResponse");

        CreateBolt11InvoiceRequest createBolt11InvoiceRequest = new CreateBolt11InvoiceRequest(param);

        // Act
        CreateInvoiceResponse response = createBolt11InvoiceRequest.getResponse();

        // Assert
        assertEquals(10, response.getAmountSat());
        assertNotNull(response.getSerialized());
        assertNotNull(response.getPaymentHash());
        log.log(Level.ALL, "Invoice: {0}", response.getSerialized());
    }
}
