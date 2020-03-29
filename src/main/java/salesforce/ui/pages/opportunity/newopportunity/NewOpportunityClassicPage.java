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

    @FindBy(css = "input[id= '00N3h000002dl6U']")
    private WebElement orderNumberTextBox;

    @FindBy(css = "input[id= '00N3h000002dl6R']")
    private WebElement currentGeneratorTextBox;

    @FindBy(css = "input[id= '00N3h000002dl6V']")
    private WebElement trackingNumberTextBox;

    @FindBy(css = "input[id= '00N3h000002dl6T']")
    private WebElement mainCompetitorsTextBox;

    @FindBy(css = "textarea[id='opp14']")
    private WebElement descriptionTextArea;

    @FindBy(xpath = "//td[@id='bottomButtonRow']//input[@name='save' and @type='submit']")
    private WebElement saveButton;

    private static final String TYPE_COMBOBOX = "select[id='opp5']";
    private static final String LEAD_SOURCE_COMBOBOX = "select[id='opp6']";
    private static final String STAGE_COMBOBOX = "select[id= 'opp11']";
    private static final String DELIVERY_STATUS = "select[id= '00N3h000002dl6S']";

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
     * @param cssLocator value.
     * @return composed selector.
     */
    private Select getSelect(final String cssLocator) {
        return new Select(webDriver.findElement(By.cssSelector(cssLocator)));
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
        getSelect(DELIVERY_STATUS).selectByVisibleText(deliveryStatus);
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
    }

    @Override
    public void clickOnCancelButton() {

    }

    @Override
    public String getOpportunityName() {
        return null;
    }

    @Override
    public String geAccountName() {
        return null;
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public String getLead() {
        return null;
    }

    @Override
    public String getAmount() {
        return null;
    }

    @Override
    public String getCloseDate() {
        return null;
    }

    @Override
    public String getNextStep() {
        return null;
    }

    @Override
    public String getStage() {
        return null;
    }

    @Override
    public String getProbability() {
        return null;
    }

    @Override
    public String getCampaign() {
        return null;
    }

    @Override
    public String getOrderNumber() {
        return null;
    }

    @Override
    public String getCurrentGenerator() {
        return null;
    }

    @Override
    public String getTrackingNumber() {
        return null;
    }

    @Override
    public String getMainCompetitor() {
        return null;
    }

    @Override
    public String getDeliveryStatus() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
