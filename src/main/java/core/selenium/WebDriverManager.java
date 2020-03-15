/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package core.selenium;

import core.utils.GradleReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Manages an instance WebDriver.
 *
 * @author Enrique Carrizales.
 * @version 1.0 14 March 2020.
 */
public class WebDriverManager {

    // Selenium driver.
    private WebDriver webDriver;

    // Selenium waiter.
    private WebDriverWait webDriverWait;

    // Instance class.
    private static WebDriverManager instance;

    /**
     * Calls a class method.
     */
    private WebDriverManager() {
        initialize();
    }

    /**
     * Returns/create a WebDriver instance.
     *
     * @return an instance.
     */
    public static WebDriverManager getInstance() {
        if (instance == null || instance.webDriver == null) {
            instance = new WebDriverManager();
        }
        return instance;
    }

    /**
     * Manages selenium properties.
     */
    private void initialize() {
        String browser = GradleReader.readBrowser();
        this.webDriver = WebDriverFactory.getWebDriver(browser);
        this.webDriver.manage().window().maximize();
        this.webDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(webDriver, 40);
    }

    /**
     * Returns a WebDriver object.
     *
     * @return a WebDriver.
     */
    public WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * Closes a WebDriver instance.
     */
    public void quitDriver() {
        webDriver.quit();
        webDriver = null;
    }

    /**
     * Returns an WebDriver waiter instance.
     *
     * @return WebDriverWait instance.
     */
    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }
}
