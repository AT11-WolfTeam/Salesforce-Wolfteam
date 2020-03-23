/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunity;

import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Defines an OpportunityLightningPage.
 *
 * @author Enrique Carrizales.
 * @version 1.0 21 March 2020.
 */
public class OpportunityLightningPage extends OpportunityPageAbstract {

    @FindBy(css = "div[data-aura-class='forceOutputOwnerIdLookupWithChangeLink'] button")
    //svg[data-key='change_owner']
    private WebElement changeOwnerButton;

    @FindBy(css = "button[class*='slds-button slds-button--brand slds']")
    private WebElement changeStageButton;

    @FindBy(css = "a[title='Details']")
    private WebElement detailsTab;

    @FindBy(css = "button[title='Edit Primary Campaign Source']")
    private WebElement editCampaign;

    @FindBy(css = "div button[title='Save']")
    private WebElement saveButton;

    protected static final String CAMPAIGN_NAME = "a div div[title='%s']";

    @FindBy(xpath = "//div[@class='slds-form-element slds-form-element_readonly slds-form-element_edit slds-grow "
            + "slds-hint-parent override--slds-form-element']//a[contains(@data-refid,'recordId')]")
    private WebElement campaignSaved;

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
    protected void assignCampaign(final String campaignName) {
        clickDetailsTab();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,400)");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(editCampaign));
        clickEditCampaign();

        String campaignNameCss = String.format(CAMPAIGN_NAME, campaignName);
        campaignNameSelect = WebDriverManager.getInstance().getWebDriver().findElement(By.cssSelector(campaignNameCss));
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
}
