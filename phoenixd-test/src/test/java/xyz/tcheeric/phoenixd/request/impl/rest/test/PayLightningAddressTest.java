package xyz.tcheeric.phoenixd.request.impl.rest.test;

import org.junit.jupiter.api.Test;
import xyz.tcheeric.common.config.Configuration;
import xyz.tcheeric.phoenixd.model.response.PayLightningAddressInvoiceResponse;
import xyz.tcheeric.phoenixd.model.param.PayLightningAddressParam;
import xyz.tcheeric.phoenixd.operation.impl.PostOperation;
import xyz.tcheeric.phoenixd.request.impl.rest.PayLightningAddressRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PayLightningAddressTest {

    @Test
    public void testConstructor() {
        // Arrange
        Configuration configuration = new Configuration("test");
        PayLightningAddressParam payLightningAddressParam = new PayLightningAddressParam();
        payLightningAddressParam.setAddress(configuration.get("pay_lnaddress"));
        payLightningAddressParam.setMessage("test message: testConstructor" + System.currentTimeMillis());
        payLightningAddressParam.setAmountSat(Integer.valueOf(configuration.get("pay_amountSat")));
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
