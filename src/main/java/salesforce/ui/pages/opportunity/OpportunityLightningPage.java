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
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.task.AbstractTask;

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

    @FindBy(xpath = "/html/body/div[4]/div[1]/section/div/div/div[1]/div[3]/div/div[1]/div/div[3]/div[1]/div/div/section/div/div/div[1]/section/div/div[3]/div/div/div[2]/div[2]/button/span")
    private WebElement saveTaskButton;

    protected static final String CAMPAIGN_NAME = "a div div[title='%s']";

    @FindBy(xpath = "//div[@class='slds-form-element slds-form-element_readonly slds-form-element_edit slds-grow "
            + "slds-hint-parent override--slds-form-element']//a[contains(@data-refid,'recordId')]")
    private WebElement campaignSaved;

    @FindBy(xpath = "/html/body/div[4]/div[1]/section/div/div/div[1]/div[1]/div/div[1]/div/div[3]/div[1]/div/div/section/div/div/div[1]/section/div/div[3]/div/div/div[1]/section/div/section/div/div/div/div/div/div[1]/div/div/div/lightning-grouped-combobox/div/div/lightning-base-combobox/div/div[1]/input")
    private WebElement subjectField;

    private static final String TASK_NAME = "//a[@class='subjectLink slds-truncate' and contains(text(),'%s')]";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(changeStageButton));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(detailsTab));
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
    protected String getCampaignName() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(campaignSaved));
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
    protected void setSubjectTask(final String subject) {
        subjectField.sendKeys(subject);
    }

    @Override
    public AbstractTask clickTaskOoEdit(final String task) {
        String campaignNameCss = String.format(TASK_NAME, task);
        taskNameSelected = webDriver.findElement(By.cssSelector(campaignNameCss));
        taskNameSelected.click();
        return AppPageFactory.getTaskPage();
    }

    @Override
    protected String getSubjectTask() {
        return taskNameSelected.getText();
    }

    public void clickAddTask() {
        addTaskButton.click();
    }


}
