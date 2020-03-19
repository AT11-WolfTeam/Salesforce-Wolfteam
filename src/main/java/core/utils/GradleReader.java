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

    private static GradleReader instance;
    private static Properties properties;
    private static final String INPUT_PATH = "gradle.properties";
    private FileInputStream fileInputStream;
    private static final String BROWSER = "browser";
    private static final String IMPLICIT_WAIT = "implicitWait";
    private static final String EXPLICIT_WAIT = "explicitWait";
    private static final String USER_EXPERIENCE = "userExperience";

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
     * Returns an explicit user experience.
     * @return String value.
     */
    public String getUserExperience() {
        return properties.getProperty(USER_EXPERIENCE);
    }
}
