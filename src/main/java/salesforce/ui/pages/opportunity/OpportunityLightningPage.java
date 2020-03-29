/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunity;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.opportunity.opportunitycontactroles.AbstractContactRolesPage;
import salesforce.ui.pages.opportunity.opportunitycontactroles.ContactRolesLightningPage;
import salesforce.ui.pages.opportunity.taskopportunity.AbstractTaskOpportunity;
import salesforce.ui.pages.owner.ChangeOpportunityOwnerLightningPopup;

/**
 * Defines an OpportunityLightningPage.
 *
 * @author Enrique Carrizales.
 * @version 1.0 21 March 2020.
 */
public class OpportunityLightningPage extends AbstractOpportunityPage {
    @FindBy(css = "div[data-aura-class='forceOutputOwnerIdLookupWithChangeLink'] button")
    private WebElement changeOwnerButton;

    @FindBy(css = "button[class*='slds-button slds-button--brand slds']")
    private WebElement changeStageButton;

    @FindBy(css = "div[class='ownerName'] a[data-aura-class='forceOutputLookup']")
    private WebElement opportunityOwnerLabel;

    @FindBy(css = "a[title='Details']")
    private WebElement detailsTab;

    @FindBy(css = "button[title='Edit Primary Campaign Source']")
    private WebElement editCampaign;

    @FindBy(css = "div button[title='Save']")
    private WebElement saveButton;

    @FindBy(css = "button[title='Add']")
    private WebElement addTaskButton;

    @FindBy(css = "span[title='Contact Roles']")
    private WebElement contactRoles;

    protected static final String CAMPAIGN_NAME = "a div div[title='%s']";

    @FindBy(xpath = "//div[@class='slds-form-element slds-form-element_readonly slds-form-element_edit slds-grow "
            + "slds-hint-parent override--slds-form-element']//a[contains(@data-refid,'recordId')]")
    private WebElement campaignSaved;

    @FindBy(xpath = "//div[@class='entityNameTitle slds-line-height--reset']")
    private WebElement entityNameTitle;

    @FindBy(xpath = "//span[@class='slds-card__header-title slds-truncate slds-m-right--xx-small'"
            + " and contains(text(),'Notes & Attachments')]")
    private WebElement notesAndAttachmentsLink;

    @FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//button"
            + "[@class='slds-button slds-button--brand slds-path__mark-complete stepAction active uiButton']")
    private WebElement markAsCurrentStageButton;

    private static final String STAGE_BUTTON = "//div[@class='windowViewMode-normal oneContent active lafPageHost']"
            + "//a//span[text()='Closed']";

    @FindBy(xpath = "//div[@class='modal-container slds-modal__container']//select[@class='stepAction required-field"
            + " select']")
    private WebElement selectCloseStageComboBox;

    @FindBy(xpath = "//div[@class='modal-container slds-modal__container']//button[@title='Save']")
    private WebElement saveCloseOpportunity;

    Select select;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(changeStageButton));
    }

    @Override
    public void changeOwner(final String ownerType) {
        changeOwnerButton.click();
        ChangeOpportunityOwnerLightningPopup changeOpportunityOwnerPopup = new ChangeOpportunityOwnerLightningPopup();
        changeOpportunityOwnerPopup.clickOnOwnerNameTextBox();
        changeOpportunityOwnerPopup.selectOwner(ownerType);
        changeOpportunityOwnerPopup.clickOnChangeOwnerButton();
    }

    @Override
    public String getOwner(final String ownerType) {
        return opportunityOwnerLabel.getText();
    }

    @Override
    protected void assignCampaign(final String campaignName) {
        clickDetailsTab();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,400)");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(editCampaign));
        clickEditCampaign();

        String campaignNameCss = String.format(CAMPAIGN_NAME, campaignName);
        campaignNameSelect = webDriver.findElement(By.cssSelector(campaignNameCss));
        campaignNameSelect.click();
    }

    @Override
    public void clickOnAStage(String stageName) {
        webDriver.findElement(By.xpath(String.format(STAGE_BUTTON, stageName))).click();
    }

    @Override
    public void clickOnMarkAsCurrentStageButton() {
        markAsCurrentStageButton.click();
    }

    @Override
    public void clickOnSelectCloseStage(String closeAs) {
        clickOnMarkAsCurrentStageButton();
        selectCloseStageAs(closeAs);
        clickOnSaveCloseOpportunity();
    }

    private void clickOnSaveCloseOpportunity() {
        saveCloseOpportunity.click();
    }

    private void selectCloseStageAs(String closeAs) {
        select = new Select(selectCloseStageComboBox);
        select.selectByValue(closeAs);
    }

    @Override
    protected String getCampaignName() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(campaignSaved));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(contactRoles));
        return campaignSaved.getText();
    }

    /**
     * Clicks on Details Tab.
     */
    private void clickDetailsTab() {
        detailsTab.click();
    }

    /**
     * Clicks on Edit Campaign.
     */
    private void clickEditCampaign() {
        editCampaign.click();
    }

    @Override
    public void clickSaveButton() {
        saveButton.click();
    }

    @Override
    public AbstractTaskOpportunity clickAddTask() {
        addTaskButton.click();
        return AppPageFactory.getTaskOpportunity();
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

    /**
     * Clicks on contact role button.
     */
    private void clickOnContactRolesButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(contactRoles));
        contactRoles.click();
    }

    @Override
    public AbstractContactRolesPage clickOnContactRoles() {
        clickOnContactRolesButton();
        return new ContactRolesLightningPage();
    }
}
