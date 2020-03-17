/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Defines a page base.
 *
 * @author Enrique Carrizales.
 * @version 1.0 17 March 2020.
 */
public class HomePage extends BasePage {

    // Contains a main button.
    @FindBy(css = "button[class = slds-button]")
    private WebElement btn_apps;

    /**
     * Defines a webDriver waiter.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(btn_apps));
    }

    public void clickOnAppsButton() {
        btn_apps.click();
    }

    
}
