/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunity;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Manages opportunity page lightning.
 *
 * @author Juan Martinez.
 * @version 1.0 23 March 2020.
 */
public class OpportunityLightningPage extends OpportunityPageAbstract {

    @FindBy(xpath = "//div[@class='entityNameTitle slds-line-height--reset']")
    private WebElement entityNameTitle;

    @FindBy(xpath = "//span[@class='slds-card__header-title slds-truncate slds-m-right--xx-small'"
            + " and contains(text(),'Notes & Attachments')]")
    private WebElement notesAndAttachmentsLink;

    @FindBy(css = "div[data-aura-class='forceOutputOwnerIdLookupWithChangeLink'] button")

    private WebElement changeOwnerButton;

    @FindBy(css = "button[class*='slds-button slds-button--brand slds']")
    private WebElement changeStageButton;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(entityNameTitle));
    }

    /**
     * Clicks on notes and attachments link.
     */
    private void clickOnNotesAndAttachment() {
        webDriverWait.until(ExpectedConditions.visibilityOf(notesAndAttachmentsLink));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", notesAndAttachmentsLink);
    }

    @Override
    public void clickOnNotesAndAttachmentsButton() {
        clickOnNotesAndAttachment();
    }

    @Override
    public void changeOwner(final String ownerType) {
        changeOwnerButton.click();
        ChangeOpportunityOwnerLightningPopup changeOpportunityOwnerPopup = new ChangeOpportunityOwnerLightningPopup();
        changeOpportunityOwnerPopup.clickOnOwnerNameTextBox();
        changeOpportunityOwnerPopup.selectOwner(ownerType);
        changeOpportunityOwnerPopup.clickOnChangeOwnerButton();
    }
}
