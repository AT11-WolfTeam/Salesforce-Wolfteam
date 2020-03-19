/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

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
    private static SalesforceUrl salesforceUrl;

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
            InputStream inputStream = new FileInputStream("salesforce.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            user.setUsername(properties.getProperty(TokenConstant.USER_NAME));
            user.setPassword(properties.getProperty(TokenConstant.PASSWORD));
            user.setGrantType(properties.getProperty(TokenConstant.GRANT_TYPE));
            user.setClientId(properties.getProperty(TokenConstant.CLIENT_ID));
            user.setClientSecret(properties.getProperty(TokenConstant.CLIENT_SECRET));
            user.setToken(properties.getProperty(TokenConstant.TOKEN));
            user.setAuthUrl(properties.getProperty(TokenConstant.AUTH_URL));

            salesforceUrl.setLoginUrl(properties.getProperty(UrlConstant.LOGIN_URL));
            salesforceUrl.setSalesLightningUrl(properties.getProperty(UrlConstant.SALES_LIGHTNING_URL));
            salesforceUrl.setOpportunitiesLightningUrl(properties.getProperty(UrlConstant
                    .OPPORTUNITIES_LIGHTNING_URL));
            salesforceUrl.setSalesClassicUrl(properties.getProperty(UrlConstant.SALES_CLASSIC_URL));
            salesforceUrl.setOpportunitiesClassicUrl(properties.getProperty(UrlConstant.OPPORTUNITIES_CLASSIC_URL));
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
            salesforceUrl = new SalesforceUrl();
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

    /**
     * Gets salesforeurl instance object.
     * @return user instance object.
     */
    public SalesforceUrl getSalesforceUrl() {
        return salesforceUrl;
    }
}
