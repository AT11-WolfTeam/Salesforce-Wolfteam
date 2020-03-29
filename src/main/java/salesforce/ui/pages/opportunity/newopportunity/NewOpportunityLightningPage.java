/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunity.newopportunity;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.entities.constants.OpportunityConstant;

public class NewOpportunityLightningPage extends AbstractNewOpportunity {
    @FindBy(css = "h2[class^='inlineTitle slds-p-top--large slds-p-horizontal--medium']")
    private WebElement newOpportunityTitle;

    @FindBy(xpath = "//div//label//span[text()='Opportunity Name']/../..//input")
    private WebElement opportunityNameTextBox;

    @FindBy(xpath = "//div//label//span[text()='Account Name']/../..//input")
    private WebElement accountNameTextBox;

    @FindBy(xpath = "//label//span[text()='Account Name']/../..//div//ul//span[@class='pillText']")
    private WebElement accountItem;

    @FindBy(xpath = "//span[text()='Amount']/../..//input")
    private WebElement amountTextBox;

    @FindBy(xpath = "//span[text()='Next Step']/../..//input")
    private WebElement nextStepTextBox;

    @FindBy(xpath = "//span[text()='Probability (%)']/../..//input")
    private WebElement probabilityTextBox;

    @FindBy(xpath = "//span[text()='Primary Campaign Source']/../..//input")
    private WebElement campaignTextBox;

    @FindBy(xpath = "//label//span[text()='Primary Campaign Source']/../..//div//ul//span[@class='pillText']")
    private WebElement campaignItem;

    @FindBy(xpath = "//span[text()='Order Number']/../..//input")
    private WebElement orderNumberTextBox;

    @FindBy(xpath = "//span[text()='Main Competitor(s)']/../..//input")
    private WebElement mainCompetitorTextBox;

    @FindBy(xpath = "//span[text()='Current Generator(s)']/../..//input")
    private WebElement currentGeneratorTextBox;

    @FindBy(xpath = "//span[text()='Tracking Number']/../..//input")
    private WebElement trackingNumberTextBox;

    @FindBy(xpath = "//span[text()='Type']/../../div//a[@class='select']")
    private WebElement typeCombobox;

    @FindBy(xpath = "//span[text()='Lead Source']/../../div//a[@class='select']")
    private WebElement leadSourceCombobox;

    @FindBy(xpath = "//span[text()='Stage']/../../div//a[@class='select']")
    private WebElement stageCombobox;

    @FindBy(xpath = "//span[text()='Delivery/Installation Status']/../../div//a[@class='select']")
    private WebElement deliveryStatusCombobox;

    @FindBy(xpath = "//span[text()='Close Date']/../../div//input[@class=' input']")
    private WebElement closeDateCalendar;

    @FindBy(css = "textarea[class=' textarea']")
    private WebElement descriptionTextarea;

    @FindBy(css = "div button[title='Save']")
    private WebElement saveButton;

    @FindBy(css = "div button[title='Cancel']")
    private WebElement cancelButton;

    private static final String ACCOUNT_NAME = "//div[@title='%s']";
    private static final String TYPE_NAME = "//a[@title='%s']";
    private static final String LEAD_NAME = "//a[@title='%s']";
    private static final String STAGE_NAME = "//a[@title='%s']";
    private static final String CAMPAIGN_NAME = "//div[text()='%s']";
    private static final String DELIVERY_NAME = "//a[@title='%s']";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(opportunityNameTextBox));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(opportunityNameTextBox));
    }

    @Override
    public void setOpportunityName(final String opportunityName) {
        webDriverWait.until(ExpectedConditions.visibilityOf(opportunityNameTextBox));
        opportunityNameTextBox.clear();
        opportunityNameTextBox.sendKeys(opportunityName);
    }

    /**
     * Sets item for value.
     * @param xpath value.
     * @param value string.
     */
    private void setItem(final String xpath, final String value) {
        webDriverWait.until(ExpectedConditions.visibilityOf(getWebElement(xpath, value)));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(getWebElement(xpath, value)));
        getWebElement(xpath, value).click();
    }

    @Override
    public void setAccountNameTextBox(final String accountName) {
        webDriverWait.until(ExpectedConditions.visibilityOf(accountNameTextBox));
        accountNameTextBox.click();
        setItem(ACCOUNT_NAME, accountName);
    }

    @Override
    public void selectTypeCombobox(final String typeName) {
        webDriverWait.until(ExpectedConditions.visibilityOf(typeCombobox));
        typeCombobox.click();
        setItem(TYPE_NAME, typeName);
    }

    @Override
    public void selectLeadSourceCombobox(final String leadName) {
        webDriverWait.until(ExpectedConditions.visibilityOf(leadSourceCombobox));
        leadSourceCombobox.click();
        setItem(LEAD_NAME, leadName);
    }

    @Override
    public void setAmountTextBox(final String amountValue) {
        webDriverWait.until(ExpectedConditions.visibilityOf(amountTextBox));
        amountTextBox.clear();
        amountTextBox.sendKeys(amountValue);
    }

    @Override
    public void setCloseDateCalendar(final String dateValue) {
        webDriverWait.until(ExpectedConditions.visibilityOf(closeDateCalendar));
        closeDateCalendar.clear();
        closeDateCalendar.sendKeys(dateValue);
    }

    @Override
    public void setNextStepTextBox(final String nextStep) {
        webDriverWait.until(ExpectedConditions.visibilityOf(nextStepTextBox));
        nextStepTextBox.clear();
        nextStepTextBox.sendKeys(nextStep);
    }

    @Override
    public void selectStageCombobox(final String stageName) {
        webDriverWait.until(ExpectedConditions.visibilityOf(stageCombobox));
        stageCombobox.click();
        setItem(STAGE_NAME, stageName);
    }

    @Override
    public void setProbabilityTextBox(final String probabilityName) {
        webDriverWait.until(ExpectedConditions.visibilityOf(probabilityTextBox));
        probabilityTextBox.clear();
        probabilityTextBox.sendKeys(probabilityName);
    }

    @Override
    public void selectCampaignItem(final String campaignName) {
        webDriverWait.until(ExpectedConditions.visibilityOf(campaignTextBox));
        campaignTextBox.click();
        setItem(CAMPAIGN_NAME, campaignName);
    }

    @Override
    public void setOrderNumberTextBox(final String orderNumber) {
        webDriverWait.until(ExpectedConditions.visibilityOf(orderNumberTextBox));
        orderNumberTextBox.clear();
        orderNumberTextBox.sendKeys(orderNumber);
    }

    @Override
    public void setCurrentGeneratorTextBox(final String currentGenerator) {
        webDriverWait.until(ExpectedConditions.visibilityOf(currentGeneratorTextBox));
        currentGeneratorTextBox.clear();
        currentGeneratorTextBox.sendKeys(currentGenerator);
    }

    @Override
    public void setTrackingNumberTextBox(final String trackingNumber) {
        webDriverWait.until(ExpectedConditions.visibilityOf(trackingNumberTextBox));
        trackingNumberTextBox.clear();
        trackingNumberTextBox.sendKeys(trackingNumber);
    }

    @Override
    public void setMainCompetitorTextBox(final String mainCompetitor) {
        webDriverWait.until(ExpectedConditions.visibilityOf(mainCompetitorTextBox));
        mainCompetitorTextBox.clear();
        mainCompetitorTextBox.sendKeys(mainCompetitor);
    }

    @Override
    public void selectDeliveryStatus(final String deliveryStatus) {
        webDriverWait.until(ExpectedConditions.visibilityOf(deliveryStatusCombobox));
        deliveryStatusCombobox.click();
        setItem(DELIVERY_NAME, deliveryStatus);
    }

    @Override
    public void setDescriptionTextarea(final String description) {
        webDriverWait.until(ExpectedConditions.visibilityOf(descriptionTextarea));
        descriptionTextarea.clear();
        descriptionTextarea.sendKeys(description);
    }

    @Override
    public void clickOnSaveButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(saveButton));
        saveButton.click();
    }

    @Override
    public void clickOnCancelButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(cancelButton));
        cancelButton.click();
    }

    @Override
    public String getOpportunityName() {
        return opportunityNameTextBox.getAttribute(OpportunityConstant.VALUE);
    }

    @Override
    public String geAccountName() {
        return accountItem.getText();
    }

    @Override
    public String getType() {
        return typeCombobox.getText();
    }

    @Override
    public String getLead() {
        return leadSourceCombobox.getText();
    }

    @Override
    public String getAmount() {
        return amountTextBox.getAttribute(OpportunityConstant.VALUE);
    }

    @Override
    public String getCloseDate() {
        return closeDateCalendar.getAttribute(OpportunityConstant.VALUE);
    }

    @Override
    public String getNextStep() {
        return nextStepTextBox.getAttribute(OpportunityConstant.VALUE);
    }

    @Override
    public String getStage() {
        return stageCombobox.getText();
    }

    @Override
    public String getProbability() {
        return probabilityTextBox.getAttribute(OpportunityConstant.VALUE);
    }

    @Override
    public String getCampaign() {
        return campaignItem.getText();
    }

    @Override
    public String getOrderNumber() {
        return orderNumberTextBox.getAttribute(OpportunityConstant.VALUE);
    }

    @Override
    public String getCurrentGenerator() {
        return currentGeneratorTextBox.getAttribute(OpportunityConstant.VALUE);
    }

    @Override
    public String getTrackingNumber() {
        return trackingNumberTextBox.getAttribute(OpportunityConstant.VALUE);
    }

    @Override
    public String getMainCompetitor() {
        return mainCompetitorTextBox.getAttribute(OpportunityConstant.VALUE);
    }

    @Override
    public String getDeliveryStatus() {
        return deliveryStatusCombobox.getText();
    }

    @Override
    public String getDescription() {
        return descriptionTextarea.getAttribute(OpportunityConstant.VALUE);
    }
}
