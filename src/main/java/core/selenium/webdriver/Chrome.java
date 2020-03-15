/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package core.selenium.webdriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

/**
 * Manages Chrome WebDriver.
 *
 * @author Enrique Carrizales.
 * @version 1.0 14 March 2020.
 */
public class Chrome implements IDriver {

    /**
     * Manage a WebDriver.
     *
     * @return Returns an instance WebDriver.
     */
    @Override
    public WebDriver initDriver() {
        ChromeDriverManager.getInstance(CHROME).version("80.0.3987.16").setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        return new ChromeDriver(chromeOptions);
    }
}
