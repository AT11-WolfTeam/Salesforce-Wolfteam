/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.lead;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.AbstractBasePage;

/**
 * Defines DeleteObjectLightningPopup.
 *
 * @author Enrique Carrizales.
 * @version 1.0 26 March 2020.
 */
public class DeleteObjectLightningPopup extends AbstractBasePage {

    @FindBy(css = "button[class*='slds-button slds-button--neutral uiButton-']")
    private WebElement deleteButton;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(deleteButton));
    }

    /**
     * Clicks on a button.
     */
    public void clickOnDeleteButton() {
        deleteButton.click();
    }
}
