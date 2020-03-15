/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package core.selenium;

import core.selenium.webdriver.Chrome;
import core.selenium.webdriver.Firefox;
import core.selenium.webdriver.IDriver;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages WebDriver instances.
 *
 * @author Enrique Carrizales.
 * @version 1.0 14 March 2020.
 */
public class WebDriverFactory {

    /**
     * Returns an specific WebDriver.
     *
     * @param browser WebDriver name
     * @return an WebDriver instance.
     */
    public static WebDriver getWebDriver(final String browser) {
        Map<String, IDriver> map = new HashMap<>();
        map.put("chrome", new Chrome());
        map.put("firefox", new Firefox());

        return map.get(browser).initDriver();
    }
}
