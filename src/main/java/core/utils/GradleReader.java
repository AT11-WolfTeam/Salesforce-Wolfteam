/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package core.utils;

import core.salesforce.SalesforceUser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Manages gradle values properties.
 *
 * @author Enrique Carrizales.
 * @version 1.0 14 March 2020.
 */
public class GradleReader {
    private static GradleReader reader;
    private static SalesforceUser user;

    /**
     * Private constructor of GradleReader.
     */
    private GradleReader() {
        initialize();
    }

    /**
     * Reads a browser property
     *
     * @return browser property vale
     */
    public static String readBrowser() {
        Properties prop = new Properties();
        InputStream input;

        try {
            input = new FileInputStream("gradle.properties");
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop.getProperty("browser");
    }

    /**
     * Initializes salesforce user values.
     */
    private void initialize() {
        try {
//            InputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "gradle.properties");
            InputStream inputStream = new FileInputStream("gradle.properties");
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
    public static GradleReader getInstance() {
        if (reader == null) {
            user = new SalesforceUser();
            reader = new GradleReader();
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
