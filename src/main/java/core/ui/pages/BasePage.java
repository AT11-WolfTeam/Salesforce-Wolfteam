/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package core.ui.pages;

import core.selenium.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Defines a page base.
 *
 * @author Enrique Carrizales.
 * @version 1.0 16 March 2020.
 */
public abstract class BasePage {

    // Contains a WebDriver instance.
    protected WebDriver webDriver;

    // Contains a WebDriverWait instance.
    protected WebDriverWait webDriverWait;

    public BasePage() {
        webDriver = WebDriverManager.getInstance().getWebDriver();
        webDriver.manage().window().maximize();
        webDriverWait = WebDriverManager.getInstance().getWebDriverWait();
        PageFactory.initElements(webDriver, this);
        waitUntilPageObjectIsLoaded();
    }

    protected abstract void waitUntilPageObjectIsLoaded();
}
