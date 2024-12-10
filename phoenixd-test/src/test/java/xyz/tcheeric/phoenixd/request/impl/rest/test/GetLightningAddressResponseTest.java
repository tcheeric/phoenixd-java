package xyz.tcheeric.phoenixd.request.impl.rest.test;

import org.junit.jupiter.api.Test;
import xyz.tcheeric.phoenixd.model.response.GetLightningAddressResponse;
import xyz.tcheeric.phoenixd.request.impl.rest.GetLightningAddressRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GetLightningAddressResponseTest {

    @Test
    public void testConstructor() {
        // Arrange
        GetLightningAddressRequest getLightningAddressRequest = new GetLightningAddressRequest();

        // Act
        GetLightningAddressResponse response = getLightningAddressRequest.getResponse();

        // Assert
        assertEquals("/getlnaddress", getLightningAddressRequest.getPath());
        assertNull(getLightningAddressRequest.getOperation().getRequestData());
        assertNotNull(response.getLightningAddress());
    }

}
