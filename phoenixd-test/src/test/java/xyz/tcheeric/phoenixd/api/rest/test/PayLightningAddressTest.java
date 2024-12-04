package xyz.tcheeric.phoenixd.api.rest.test;

import org.junit.jupiter.api.Test;
import xyz.tcheeric.phoenixd.api.model.rest.PayLightningAddressInvoiceResponse;
import xyz.tcheeric.phoenixd.api.model.rest.PayLightningAddressParam;
import xyz.tcheeric.phoenixd.api.operation.impl.PostOperation;
import xyz.tcheeric.phoenixd.api.rest.PayLightningAddressRequest;
import xyz.tcheeric.phoenixd.api.util.Configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PayLightningAddressTest {

    @Test
    public void testConstructor() {
        // Arrange
        PayLightningAddressParam payLightningAddressParam = new PayLightningAddressParam();
        payLightningAddressParam.setAddress(Configuration.getTestPayLnAddress());
        payLightningAddressParam.setMessage("test message: testConstructor" + System.currentTimeMillis());
        payLightningAddressParam.setAmountSat(Configuration.getTestPayAmountSat());
        PayLightningAddressRequest payLightningAddressRequest = new PayLightningAddressRequest(payLightningAddressParam);

        // Act
        PayLightningAddressInvoiceResponse response = payLightningAddressRequest.getResponse();

        // Assert
        assertEquals("/paylnaddress", payLightningAddressRequest.getPath());
        assertEquals(PostOperation.class, payLightningAddressRequest.getOperation().getClass());
        assertEquals(payLightningAddressParam.toString(), payLightningAddressRequest.getOperation().getRequestData());
        assertEquals(10, response.getRecipientAmountSat());
    }

}
