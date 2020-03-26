/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.newcampaign;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Defines NewCampaignPageClassic.
 *
 * @author Alan Escalera.
 * @version 1.0 19 March 2020.
 */
public class NewCampaignClassicPage extends AbstractNewCampaignPage {
    @FindBy(css = "input[id='cpn1']")
    private WebElement campaignNameField;

    @FindBy(css = "input[id='cpn16']")
    private WebElement activeCheckBox;

    @FindBy(css = "input[name='save']")
    private WebElement saveButton;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(campaignNameField));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(campaignNameField));
    }

    @Override
    protected void setCampaignNameField(final String campaignName) {
        campaignNameField.sendKeys(campaignName);
    }

    @Override
    protected void setCampaignActiveCheckBox(final String campaignActive) {
        if (campaignActive.equals(IS_ACTIVE)) {
            activeCheckBox.click();
        }
    }

    @Override
    public void clickSaveButton() {
        saveButton.click();
    }
}
