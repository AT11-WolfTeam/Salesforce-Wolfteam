package salesforce.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;

/**
 * Allows to read salesforce properties values.
 *
 * @author Juan Martinez.
 * @version 1.0 16 March 2020.
 */
public final class PropertiesReader {
    private static PropertiesReader reader;
    private static SalesforceUser user;

    /**
     * Private constructor of GradleReader.
     */
    private PropertiesReader() {
        initialize();
    }

    /**
     * Initializes salesforce user values.
     */
    private void initialize() {
        try {
//            InputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "gradle.properties");
            InputStream inputStream = new FileInputStream("salesforce.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            user.setUsername(properties.getProperty("username"));
            user.setPassword(properties.getProperty("password"));
            user.setGrantType(properties.getProperty("grant_type"));
            user.setClientId(properties.getProperty("client_id"));
            user.setClientSecret(properties.getProperty("client_secret"));
            user.setToken(properties.getProperty("token"));
            user.setAuthUrl(properties.getProperty("auth_url"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Gets instance of GradleReader.
     * @return GradleReader instance.
     */
    public static PropertiesReader getInstance() {
        if (reader == null) {
            user = new SalesforceUser();
            reader = new PropertiesReader();
        }
        return reader;
    }

    /**
     * Gets user instance object.
     * @return user instance object.
     */
    public SalesforceUser getUser() {
        return user;
    }
}