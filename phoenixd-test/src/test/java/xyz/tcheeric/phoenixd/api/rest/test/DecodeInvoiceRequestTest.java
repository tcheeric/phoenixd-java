package xyz.tcheeric.phoenixd.api.rest.test;

import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import xyz.tcheeric.phoenixd.api.model.rest.CreateInvoiceParam;
import xyz.tcheeric.phoenixd.api.model.rest.DecodeInvoiceParam;
import xyz.tcheeric.phoenixd.api.model.rest.DecodeInvoiceResponse;
import xyz.tcheeric.phoenixd.api.rest.CreateBolt11InvoiceRequest;
import xyz.tcheeric.phoenixd.api.rest.DecodeInvoiceRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log
public class DecodeInvoiceRequestTest {

    @Test
    public void testConstructor() {
        // Arrange
        DecodeInvoiceParam decodeInvoiceParam = new DecodeInvoiceParam();
        decodeInvoiceParam.setInvoice("lntb10n1pngtqfhpp5qezkef9tussdxurernxpmur9fzm2g0gqjuffaypvd2r7ma8urh4scqpjsp5u3dgmgrry4advuse35al6d2j2ns9uewequpuwcf8eun0pk7m5lms9q7sqqqqqqqqqqqqqqqqqqqsqqqqqysgqdq4xysyymr0vd4kzcmrd9hx7mqz9grzjqwfn3p9278ttzzpe0e00uhyxhned3j5d9acqak5emwfpflp8z2cnfl6h8msfh3505gqqqqlgqqqqqeqqjq3krntmn2r4d8j0ncgztxkssymfpwy3lv48jt5zgq5te8c5h56r6r03a2nz09nye89pmyhncm64ppwcufntar2zs5m4jw2cfm8u9m3usqxju37k");
        DecodeInvoiceRequest decodeInvoiceRequest = new DecodeInvoiceRequest(decodeInvoiceParam);

        // Act
        DecodeInvoiceResponse response = decodeInvoiceRequest.getResponse();

        // Assert
        assertEquals("/decodeinvoice", decodeInvoiceRequest.getPath());
        assertEquals(decodeInvoiceParam.toString(), decodeInvoiceRequest.getOperation().getRequestData());
        assertEquals(1000, response.getAmount());
        assertEquals("1 Blockaccino", response.getDescription());
    }

}
