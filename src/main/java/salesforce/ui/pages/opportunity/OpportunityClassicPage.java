/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunity;

import core.utils.UtilSalesforce;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


/**
 * Defines an OpportunityClassicPage.
 *
 * @author Enrique Carrizales.
 * @version 1.0 21 March 2020.
 */
public class OpportunityClassicPage extends AbstractOpportunityPage {
    @FindBy(css = "td[id='opp17_ilecell']")
    private WebElement campaignField;

    @FindBy(xpath = "//img[@alt='Primary Campaign Source Lookup (New Window)']")
    private WebElement lookupButton;

    @FindBy(css = "input[name='inlineEditSave']")
    private WebElement saveButton;

    @FindBy(xpath = "//div[@id='opp17_ileinner']")
    private WebElement campaignSaved;

    @FindBy(css = "input[title='Edit']")
    private WebElement editButton;

    @FindBy(name = "resultsFrame")
    private WebElement resultsFrame;

    @FindBy(css = "input[value='Attach File']")
    private WebElement attachFileButton;


    private String parentHandle;
    protected static final String CAMPAIGN_NAME = "//th[@scope='row']//a[contains(text(),'%s')]";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(campaignField));
    }

    @Override
    protected void assignCampaign(final String campaignName) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,400)");
        clickCampaignField();
        clickLookupButton();
        selectCampaign(campaignName);
        clickSaveButton();
    }

    @Override
    protected String getCampaignName() {
        webDriverWait.until(ExpectedConditions.visibilityOf(campaignSaved));
        webDriverWait.until(ExpectedConditions.visibilityOf(editButton));
        return campaignSaved.getText();
    }

    /**
     * Selects the campaign.
     *
     * @param campaignName value.
     */
    private void selectCampaign(final String campaignName) {
        parentHandle = webDriver.getWindowHandle();
        try{
            UtilSalesforce.switchToNewWindow(parentHandle);
            webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(resultsFrame));
            clickCampaignSelected(campaignName);
        } finally {
            webDriver.switchTo().window(parentHandle);
        }
    }

    private void clickCampaignSelected(final String campaignName) {
        String campaignNameXpath = String.format(CAMPAIGN_NAME, campaignName);
        campaignNameSelect = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(campaignNameXpath)));
        campaignNameSelect.click();
    }

    @Override
    public void clickSaveButton() {
        saveButton.click();
    }

    /**
     * Clicks on campaign field.
     */
    private void clickCampaignField() {
        campaignField.click();
        campaignField.sendKeys(Keys.ENTER);
    }

    /**
     * Clicks on lookup button.
     */
    private void clickLookupButton() {
        lookupButton.click();
    }

    @Override
    public void changeOwner(final String ownerType) {

    }

    @Override
    public String getOwner(final String ownerType) {
        return null;
    }

    /**
     * Clicks on notes and attachments link.
     */
    private void clickOnAttachFileButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(attachFileButton));
        attachFileButton.click();
    }

    @Override
    public void clickOnNotesAndAttachmentsButton() {
        clickOnAttachFileButton();
    }
}
