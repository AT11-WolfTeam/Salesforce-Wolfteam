/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.campaign;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.AbstractBasePage;

/**
 * Defines AddObjectCampaignLightningPopup.
 *
 * @author Enrique Carrizales.
 * @version 1.0 26 March 2020.
 */
public class AddObjectCampaignLightningPopup extends AbstractBasePage {

    @FindBy(xpath = "//button[span[contains(.,'Submit')]]")
    private WebElement submitButton;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(submitButton));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(submitButton));
    }

    /**
     * Click a button.
     */
    public void clickOnSubmitButton() {
        submitButton.click();
    }
}
