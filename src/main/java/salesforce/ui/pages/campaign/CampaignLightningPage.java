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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.campaigncontact.AbstractCampaignContactPage;
import salesforce.ui.pages.campaigncontact.CampaignContactPopupLightningPage;
import salesforce.ui.pages.campaignlist.AbstractCampaignListPage;
import salesforce.ui.pages.campaignmembers.AbstractCampaignMembersPage;
import salesforce.ui.pages.campaignmembers.CampaignMembersLightningPage;

/**
 * Defines CampaignLightningPage.
 *
 * @author Alan Escalera.
 * @version 1.0 22 March 2020.
 */
public class CampaignLightningPage extends AbstractCampaignPage {
    private Actions actions;

    @FindBy(xpath = "//div[@title='Delete' and contains(text(),'Delete')]")
    private WebElement deleteCampaignScroll;

    @FindBy(xpath = "//button[@title='Delete' and @type='button']")
    private WebElement deleteButtonConfirm;

    @FindBy(xpath = "//div[@class='slds-grid primaryFieldRow']//div[@role='group']//li[@class='slds-button"
            + " slds-button--icon-border-filled oneActionsDropDown']//div[@class='uiMenu']")
    private WebElement iconDropDown;

    @FindBy(xpath = "//div[@title='Add Contacts']")
    private WebElement addContactsButton;

    @FindBy(css = "span[class='view-all-label']")
    private WebElement viewAllLink;

    /**
     * Constructor CampaignLightningPage.
     */
    public CampaignLightningPage() {
        actions = new Actions(webDriver);
    }

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(iconDropDown));
    }

    @Override
    public AbstractCampaignListPage deleteCampaign() {
        clickIconDropDown();
        clickDeleteCampaignScroll();
        clickDeleteConfirmButton();
        return AppPageFactory.getCampaignsPage();
    }

    @Override
    public AbstractCampaignContactPage addCampaignMembers() {
        ClickOnAddContacts();
        return new CampaignContactPopupLightningPage();
    }

    /**
     * Clicks on view all dropdownlist.
     */
    private void clickOnViewAll() {
        webDriverWait.until(ExpectedConditions.visibilityOf(viewAllLink));
        viewAllLink.click();
    }

    @Override
    public AbstractCampaignMembersPage viewMembers() {
        clickOnViewAll();
        return new CampaignMembersLightningPage();
    }

    /**
     * Clicks on add contacts.
     */
    private void ClickOnAddContacts() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addContactsButton));
        addContactsButton.click();
    }

    /**
     * Clicks on Icon Drop Down.
     */
    private void clickIconDropDown() {
        iconDropDown.click();
    }

    /**
     * Clicks in Delete Campaigns Scroll.
     */
    private void clickDeleteCampaignScroll() {
        actions.moveToElement(deleteCampaignScroll).click().build().perform();
    }

    /**
     * Clicks on delete confirm button.
     */
    private void clickDeleteConfirmButton() {
        deleteButtonConfirm.click();
    }
}
