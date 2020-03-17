/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package core.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Manages gradle values properties.
 *
 * @author Enrique Carrizales.
 * @version 1.0 14 March 2020.
 */
public final class GradleReader {

    // Instance class.
    private static GradleReader instance;

    // Instance properties.
    private static Properties properties;

    // Gradle properties path.
    private static final String INPUT_PATH = "gradle.properties";

    // Instance FileInputStream
    private FileInputStream fileInputStream;

    // String browser value.
    private static final String BROWSER = "browser";

    // String implicitWait value.
    private static final String IMPLICIT_WAIT = "implicitWait";

    // String explicitWait value.
    private static final String EXPLICIT_WAIT = "explicitWait";

    // String Login page value.
    private static final String LOGIN_PAGE = "Login.Page";

    // String Sales page value.
    private static final String SALES_PAGE = "Sales.Page";

    // String Opportunities value.
    private static final String OPPORTUNITIES_PAGE = "Opportunities.Page";

    /**
     * Calls to initialize class method.
     */
    private GradleReader() {
        initialize();
    }

    /**
     * Returns an instance of GradleReader.
     *
     * @return GradleReader instance.
     */
    public static GradleReader getInstance() {
        if (instance == null) {
            instance = new GradleReader();
        }
        return instance;
    }

    /**
     * Manages instances to initialize.
     */
    private void initialize() {
        properties = new Properties();
        try {
            fileInputStream = new FileInputStream(INPUT_PATH);
            properties.load(fileInputStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Returns a browser property.
     *
     * @return String value.
     */
    public String getDriver() {
        return properties.getProperty(BROWSER);
    }

    /**
     * Returns an implicit wait property.
     *
     * @return String value.
     */
    public Long getImplicitWait() {
        return Long.parseLong(properties.getProperty(IMPLICIT_WAIT));
    }

    /**
     * Returns an explicit wait property.
     *
     * @return String value.
     */
    public Long getExplicitWait() {
        return Long.parseLong(properties.getProperty(EXPLICIT_WAIT));
    }

    /**
     * Returns the link of login Page.
     *
     * @return String value
     */
    public String getLoginPage() {
        return properties.getProperty(LOGIN_PAGE);
    }

    /**
     * Returns the link of sales Page.
     *
     * @return String value
     */
    public String getSalesPage() {
        return properties.getProperty(SALES_PAGE);
    }

    /**
     * Returns the link of Opportunities Page.
     *
     * @return String value
     */
    public String getOpportunitiesPage() {
        return properties.getProperty(OPPORTUNITIES_PAGE);
    }
}
