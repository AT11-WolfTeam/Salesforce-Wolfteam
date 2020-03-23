/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages;

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
public abstract class AbstractBasePage {
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    /**
     * Initializes instances required.
     */
    public AbstractBasePage() {
        webDriver = WebDriverManager.getInstance().getWebDriver();
        webDriver.manage().window().maximize();
        webDriverWait = WebDriverManager.getInstance().getWebDriverWait();
        PageFactory.initElements(webDriver, this);
        waitUntilPageObjectIsLoaded();
    }

    /**
     * Waits until the web element is loaded.
     */
    protected abstract void waitUntilPageObjectIsLoaded();
}
