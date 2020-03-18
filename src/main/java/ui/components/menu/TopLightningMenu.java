/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.components.menu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.aplications.AppsLightningOrderedMenu;

/**
 * Manages a web page.
 *
 * @author Enrique Carrizales.
 * @version 1.0 17 March 2020.
 */
public class TopLightningMenu extends TopMenuAbstract {

    @FindBy(css = "button[class = slds-button]")
    private WebElement appsButton;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(appsButton));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(appsButton));
    }

    /**
     * Click on apps button.
     */
    @Override
    protected AppsLightningOrderedMenu clickOnAppsButton() {
        appsButton.click();
        return new AppsLightningOrderedMenu();
    }
}
