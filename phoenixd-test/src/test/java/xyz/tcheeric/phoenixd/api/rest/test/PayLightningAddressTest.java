package xyz.tcheeric.phoenixd.api.rest.test;

import org.junit.jupiter.api.Test;
import xyz.tcheeric.phoenixd.api.model.rest.PayLightningAddressParam;
import xyz.tcheeric.phoenixd.api.operation.impl.PostOperation;
import xyz.tcheeric.phoenixd.api.rest.PayLightningAddressRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PayLightningAddressTest {

    @Test
    public void testConstructor() {
        // Arrange and Act
        PayLightningAddressParam payLightningAddressParam = new PayLightningAddressParam();
        payLightningAddressParam.setAddress("398ja@coinos.io");
        payLightningAddressParam.setMessage("test message: testConstructor");
        payLightningAddressParam.setAmountSat(10);
        PayLightningAddressRequest payLightningAddressRequest = new PayLightningAddressRequest(payLightningAddressParam);

        // Assert
        assertEquals("/paylnaddress", payLightningAddressRequest.getPath());
        assertEquals(PostOperation.class, payLightningAddressRequest.getOperation().getClass());
        assertEquals(payLightningAddressParam.toString(), payLightningAddressRequest.getOperation().getBody());
    }

}
