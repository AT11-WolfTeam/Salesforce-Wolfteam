/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunity.newopportunity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import salesforce.entities.constants.OpportunityConstant;

/**
 * Manages new opportunity classic page.
 *
 * @author Juan Martinez.
 * * @version 1.0 29 March 2020.
 */
public class NewOpportunityClassicPage extends AbstractNewOpportunity {
    @FindBy(css = "h2[class='pageDescription']")
    private WebElement opportunityTitle;

    @FindBy(css = "input[id='opp3']")
    private WebElement opportunityNameTextBox;

    @FindBy(css = "input[id='opp4']")
    private WebElement accountNameTextBox;

    @FindBy(css = "input[id='opp7']")
    private WebElement amountTextBox;

    @FindBy(css = "input[id='opp9']")
    private WebElement closeDateTextBoxCalendar;

    @FindBy(xpath = "//label[text()= 'Close Date']")
    private WebElement closeDateLabel;

    @FindBy(css = "input[id= 'opp10']")
    private WebElement nextStepTextBox;

    @FindBy(css = "input[id= 'opp12']")
    private WebElement probabilityTextBox;

    @FindBy(css = "input[id= 'opp17']")
    private WebElement primaryCampaignSource;

    @FindBy(xpath = "//label[text()='Order Number']/../..//td[@class='dataCol col02']//input")
    private WebElement orderNumberTextBox;

    @FindBy(xpath = "//label[text()='Current Generator(s)']/../..//td[@class='dataCol col02']//input")
    private WebElement currentGeneratorTextBox;

    @FindBy(xpath = "//label/../..//td[@class='dataCol last col02']//input")
    private WebElement trackingNumberTextBox;

    @FindBy(xpath = "//label[text()='Main Competitor(s)']/../..//td[@class='dataCol']//input")
    private WebElement mainCompetitorsTextBox;

    @FindBy(css = "textarea[id='opp14']")
    private WebElement descriptionTextArea;

    @FindBy(xpath = "//td[@id='bottomButtonRow']//input[@name='save' and @type='submit']")
    private WebElement saveButton;

    @FindBy(css = "input[value='Cancel']")
    private WebElement cancelButton;

    @FindBy(css = "select[id='opp5']")
    private WebElement typeCombobox;

    @FindBy(css = "select[id='opp6']")
    private WebElement leadCombobox;

    @FindBy(css = "select[id= 'opp11']")
    private WebElement stageCombobox;

    @FindBy(xpath = "//label[text()='Delivery/Installation Status']"
            + "/../..//td[@class='dataCol']//span//select")
    private WebElement deliveryStatus;

    private static final String TYPE_COMBOBOX = "select[id='opp5']";
    private static final String LEAD_SOURCE_COMBOBOX = "select[id='opp6']";
    private static final String STAGE_COMBOBOX = "select[id= 'opp11']";
    private static final String DELIVERY_STATUS = "//label[text()='Delivery/Installation Status']"
            + "/../..//td[@class='dataCol']//span//select";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(opportunityTitle));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(opportunityTitle));
    }

    @Override
    public void setOpportunityName(final String opportunityName) {
        webDriverWait.until(ExpectedConditions.visibilityOf(opportunityNameTextBox));
        opportunityNameTextBox.clear();
        opportunityNameTextBox.sendKeys(opportunityName);
    }

    @Override
    public void setAccountNameTextBox(final String accountName) {
        webDriverWait.until(ExpectedConditions.visibilityOf(accountNameTextBox));
        accountNameTextBox.clear();
        accountNameTextBox.sendKeys(accountName);
    }

    /**
     * Gets combobox selector.
     *
     * @param cssLocator value.
     * @return composed selector.
     */
    private Select getSelect(final String cssLocator) {
        return new Select(webDriver.findElement(By.cssSelector(cssLocator)));
    }

    /**
     * Gets combobox selector.
     *
     * @param xpathLocator value.
     * @return composed selector.
     */
    private Select getSelectByXpath(final String xpathLocator) {
        return new Select(webDriver.findElement(By.xpath(xpathLocator)));
    }

    @Override
    public void selectTypeCombobox(final String typeName) {
        getSelect(TYPE_COMBOBOX).selectByVisibleText(typeName);
    }

    @Override
    public void selectLeadSourceCombobox(final String leadName) {
        getSelect(LEAD_SOURCE_COMBOBOX).selectByVisibleText(leadName);
    }

    @Override
    public void setAmountTextBox(final String amountValue) {
        webDriverWait.until(ExpectedConditions.visibilityOf(amountTextBox));
        amountTextBox.clear();
        amountTextBox.sendKeys(amountValue);
    }

    @Override
    public void setCloseDateCalendar(final String dateValue) {
        webDriverWait.until(ExpectedConditions.visibilityOf(closeDateTextBoxCalendar));
        closeDateTextBoxCalendar.clear();
        closeDateTextBoxCalendar.sendKeys(dateValue);
    }

    @Override
    public void setNextStepTextBox(final String nextStep) {
        webDriverWait.until(ExpectedConditions.visibilityOf(nextStepTextBox));
        nextStepTextBox.clear();
        nextStepTextBox.sendKeys(nextStep);
    }

    @Override
    public void selectStageCombobox(final String stageName) {
        getSelect(STAGE_COMBOBOX).selectByVisibleText(stageName);
    }

    @Override
    public void setProbabilityTextBox(final String probabilityName) {
        webDriverWait.until(ExpectedConditions.visibilityOf(probabilityTextBox));
        probabilityTextBox.clear();
        probabilityTextBox.sendKeys(probabilityName);
    }

    @Override
    public void selectCampaignItem(final String campaignName) {
        webDriverWait.until(ExpectedConditions.visibilityOf(primaryCampaignSource));
        primaryCampaignSource.clear();
        primaryCampaignSource.sendKeys(campaignName);
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
        webDriverWait.until(ExpectedConditions.visibilityOf(mainCompetitorsTextBox));
        mainCompetitorsTextBox.clear();
        mainCompetitorsTextBox.sendKeys(mainCompetitor);
    }

    @Override
    public void selectDeliveryStatus(final String deliveryStatus) {
        getSelectByXpath(DELIVERY_STATUS).selectByVisibleText(deliveryStatus);
    }

    @Override
    public void setDescriptionTextarea(final String description) {
        webDriverWait.until(ExpectedConditions.visibilityOf(descriptionTextArea));
        descriptionTextArea.clear();
        descriptionTextArea.sendKeys(description);
    }

    @Override
    public void clickOnSaveButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(saveButton));
        saveButton.click();
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
        return accountNameTextBox.getAttribute(OpportunityConstant.VALUE);
    }

    @Override
    public String getType() {
        return typeCombobox.getAttribute(OpportunityConstant.VALUE);
    }

    @Override
    public String getLead() {
        return leadCombobox.getAttribute(OpportunityConstant.VALUE);
    }

    @Override
    public String getAmount() {
        return amountTextBox.getAttribute(OpportunityConstant.VALUE);
    }

    @Override
    public String getCloseDate() {
        return closeDateTextBoxCalendar.getAttribute(OpportunityConstant.VALUE);
    }

    @Override
    public String getNextStep() {
        return nextStepTextBox.getAttribute(OpportunityConstant.VALUE);
    }

    @Override
    public String getStage() {
        return stageCombobox.getAttribute(OpportunityConstant.VALUE);
    }

    @Override
    public String getProbability() {
        return probabilityTextBox.getAttribute(OpportunityConstant.VALUE);
    }

    @Override
    public String getCampaign() {
        return primaryCampaignSource.getAttribute(OpportunityConstant.VALUE);
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
        return mainCompetitorsTextBox.getAttribute(OpportunityConstant.VALUE);
    }

    @Override
    public String getDeliveryStatus() {
        return deliveryStatus.getAttribute(OpportunityConstant.VALUE);
    }

    @Override
    public String getDescription() {
        return descriptionTextArea.getAttribute(OpportunityConstant.VALUE);
    }
}
