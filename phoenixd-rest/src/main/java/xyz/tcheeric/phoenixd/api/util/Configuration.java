package xyz.tcheeric.phoenixd.api.util;

import lombok.extern.java.Log;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;

@Log
public class Configuration {

    private static final Properties properties = new Properties();

    static {
        String configFilePath = System.getProperty("phoenixd.properties");
        try (InputStream input = (configFilePath != null) ? new FileInputStream(configFilePath) : Configuration.class.getClassLoader().getResourceAsStream("phoenixd.properties")) {
            if (input == null) {
                throw new IOException("Unable to find phoenixd.conf");
            }
            properties.load(input);
        } catch (IOException ex) {
            log.log(Level.SEVERE, "An error occurred", ex);
        }
    }

    public static String getUsername() {
        return properties.getProperty("phoenixd.username");
    }

    public static String getPassword() {
        return properties.getProperty("phoenixd.password");
    }

    public static String getBaseUrl() {
        return properties.getProperty("phoenixd.base_url");
    }

    public static int getTimeout() {
        return Integer.parseInt(properties.getProperty("phoenixd.timeout"));
    }

    public static String getWebhookSecret() {
        return properties.getProperty("phoenixd.webhook_secret");
    }

    public static String getTestPayLnAddress() {
        return properties.getProperty("test.pay_lnaddress");
    }

    public static String getTestPayLnInvoice() {
        return properties.getProperty("test.pay_lninvoice");
    }

    public static Integer getTestPayAmountSat() {
        return Integer.parseInt(properties.getProperty("test.pay_amountSat"));
    }
}
