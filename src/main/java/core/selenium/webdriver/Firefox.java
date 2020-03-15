/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package core.selenium.webdriver;

import io.github.bonigarcia.wdm.FirefoxDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static io.github.bonigarcia.wdm.DriverManagerType.FIREFOX;

/**
 * Manages Firefox WebDriver.
 *
 * @author Enrique Carrizales.
 * @version 1.0 14 March 2020.
 */
public class Firefox implements IDriver {

    /**
     * Manage a WebDriver.
     *
     * @return Returns an instance WebDriver.
     */
    @Override
    public WebDriver initDriver() {
        FirefoxDriverManager.getInstance(FIREFOX).version("73.0").setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        return new FirefoxDriver(firefoxOptions);
    }
}
