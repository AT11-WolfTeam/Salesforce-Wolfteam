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

import java.util.ArrayList;

/**
 * Defines NewCampaignPopUpLightning.
 *
 * @author Alan Escalera.
 * @version 1.0 19 March 2020.
 */
public class NewCampaignLightningPopUp extends AbstractNewCampaignPage {
    @FindBy(xpath = "//div[@class='uiInput uiInputText uiInput--default uiInput--input']//input[@class=' input']")
    private WebElement campaignNameField;

    @FindBy(xpath = "//div[@class='slds-form-element__control']//input[@type='checkbox']")
    private WebElement activeCheckBox;

    @FindBy(css = "button[title='Save']")
    private WebElement saveButton;

    @FindBy(xpath = "//h2[starts-with(@id, 'title_')]")
    private WebElement addContactsPopupTitle;

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

    @Override
    public void checkContacts(ArrayList<String> namesOfContacts) {
        clickOnAddContactsPopupTitle();
    }

    private void clickOnAddContactsPopupTitle() {
        webDriverWait.until(ExpectedConditions.visibilityOf(addContactsPopupTitle));
        addContactsPopupTitle.click();
    }
}
