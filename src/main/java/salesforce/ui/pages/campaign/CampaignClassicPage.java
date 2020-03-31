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
import salesforce.entities.Lead;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.campaignLeads.AddLeadsCampaignClassicPage;
import salesforce.ui.pages.campaigncontact.AbstractCampaignContactPage;
import salesforce.ui.pages.campaigncontact.CampaignContactClassicPage;
import salesforce.ui.pages.campaignlist.AbstractCampaignListPage;
import salesforce.ui.pages.campaignmembers.AbstractCampaignMembersPage;
import salesforce.ui.pages.campaignmembers.CampaignMembersClassicPage;

import java.util.List;

/**
 * Defines CampaignClassicPage.
 *
 * @author Alan Escalera.
 * @version 1.0 22 March 2020.
 */
public class CampaignClassicPage extends AbstractCampaignPage {
    @FindBy(css = "input[title='Delete']")
    private WebElement deleteButton;

    @FindBy(id = "managedetailLabel")
    private WebElement manageMembersCombobox;

    @FindBy(xpath = "//div[@id='managedetailMenu']/a[text()= 'Add Members - Search']")
    private WebElement addMembersItem;

    @FindBy(xpath = "//div[@id='managedetailMenu']/a[text()= 'Edit Members - Search']")
    private WebElement editMembersItem;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(deleteButton));
    }

    @Override
    public AbstractCampaignListPage deleteCampaign() {
        deleteButton.click();
        webDriverWait.until(ExpectedConditions.alertIsPresent());
        webDriver.switchTo().alert().accept();
        return AppPageFactory.getCampaignsPage();
    }

    @Override
    public void addLeads(final List<Lead> leadList) {
        clickOnManageMemberCombobox();
        clickOnAddMemberItem();
        AddLeadsCampaignClassicPage addLeadsCampaignClassicPage = new AddLeadsCampaignClassicPage();
        addLeadsCampaignClassicPage.addLead(leadList);
    }

    @Override
    public AbstractCampaignContactPage addCampaignMembers() {
        clickOnManageMemberCombobox();
        clickOnAddMemberItem();
        return new CampaignContactClassicPage();
    }

    /**
     * Clicks on edit button.
     */
    private void clickOnEditMembers() {
        webDriverWait.until(ExpectedConditions.visibilityOf(editMembersItem));
        editMembersItem.click();
    }

    @Override
    public AbstractCampaignMembersPage viewMembers() {
        clickOnManageMemberCombobox();
        clickOnEditMembers();
        return new CampaignMembersClassicPage();
    }

    @Override
    public void displayCampaignMembers() {
        //Todo
    }

    /**
     * Clicks on manage member combobox.
     */
    private void clickOnManageMemberCombobox() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(manageMembersCombobox));
        manageMembersCombobox.click();
    }

    /**
     * Clicks on add member item.
     */
    private void clickOnAddMemberItem() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addMembersItem));
        addMembersItem.click();
    }
}
