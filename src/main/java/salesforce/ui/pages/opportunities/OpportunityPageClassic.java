/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunities;

import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Defines OpportunityPageClassic.
 *
 * @author Alan Escalera.
 * @version 1.0 19 March 2020.
 */
public class OpportunityPageClassic extends OpportunityPageAbstract {
    @FindBy(css = "div[id='opp17_ileinner']")
    private WebElement campaignField;

    @FindBy(xpath = "//img[@alt='Primary Campaign Source Lookup (New Window)']")
    private WebElement lookupButton;

    @FindBy(css = "input[name='inlineEditSave']")
    private WebElement saveButton;

    protected static final String CAMPAIGN_NAME = "//a[contains(text(),'%s')]";

    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    @Override
    protected void assignCampaign(final String campaignName) {
        clickCampaignField();
        // Perform the click operation that opens new window
        clickLookupButton();
        selectCampaign(campaignName);
        clickSaveButton();
    }

    @Override
    protected String getCampaignName() {
        return null;
    }

    /**
     * Selects the campaign.
     * @param campaignName value.
     */
    private void selectCampaign(final String campaignName) {
        // Switch to new window opened
        for(String winHandle : WebDriverManager.getInstance().getWebDriver().getWindowHandles()){
            WebDriverManager.getInstance().getWebDriver().switchTo().window(winHandle);
        }
        // Perform the actions on new window
        String campaignNameCss = String.format(CAMPAIGN_NAME, campaignName);
        campaignNameSelect = WebDriverManager.getInstance().getWebDriver().findElement(By.cssSelector(campaignNameCss));
        campaignNameSelect.click();
        // Close the new window, if that window no more required
        WebDriverManager.getInstance().getWebDriver().switchTo().defaultContent();
    }

    @Override
    public void clickSaveButton() {
        saveButton.click();
    }

    /**
     * Clicks on campaign field.
     */
    private void clickCampaignField(){
        campaignField.click();
        campaignField.click();
    }

    /**
     * Clicks on lookup button.
     */
    private void clickLookupButton(){
        lookupButton.click();
    }
}
