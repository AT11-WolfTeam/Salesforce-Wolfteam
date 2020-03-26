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
import salesforce.entities.Lead;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.campaignlist.AbstractCampaignListPage;
import salesforce.ui.pages.lead.AddLeadsCampaignLightningPopup;

import java.util.List;

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

    @FindBy(xpath = "//a[div[contains(.,'Add Leads')]]")
    private WebElement addLeadsButton;

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
    public void addLeads(final List<Lead> leadList) {
        addLeadsButton.click();
        AddLeadsCampaignLightningPopup addLeadsCampaignLightningPopup = new AddLeadsCampaignLightningPopup();
//        addLeadsCampaignPopup
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
