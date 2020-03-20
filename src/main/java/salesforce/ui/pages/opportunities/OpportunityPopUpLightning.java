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
 * Defines OpportunityPopUpLightning.
 *
 * @author Alan Escalera.
 * @version 1.0 19 March 2020.
 */
public class OpportunityPopUpLightning extends OpportunityPageAbstract {
    @FindBy(css = "a[title='Details']")
    private WebElement detailsTab;

    @FindBy(css = "button[title='Edit Primary Campaign Source']")
    private WebElement editCampaign;

    @FindBy(css = "div button[title='Save']")
    private WebElement saveButton;

    @FindBy(xpath = "//div[@class='slds-form-element slds-form-element_readonly slds-form-element_edit slds-grow "+
            "slds-hint-parent override--slds-form-element']//div//a")
    private WebElement campaignSaved;

    protected static final String CAMPAIGN_NAME = "a div div[title='%s']";


    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    @Override
    protected void assignCampaign(final String campaignName) {
        clickDetailsTab();
        clickEditCampaign();

        String campaignNameCss = String.format(CAMPAIGN_NAME, campaignName);
        campaignNameSelect = WebDriverManager.getInstance().getWebDriver().findElement(By.cssSelector(campaignNameCss));
        campaignNameSelect.click();
    }

    /**
     * Clicks on Details Tab.
     */
    private void clickDetailsTab(){
        detailsTab.click();
    }

    /**
     * Clicks on Edit Campaign.
     */
    private void clickEditCampaign(){
        editCampaign.click();
    }

    @Override
    public void clickSaveButton(){
        saveButton.click();
    }

    public String getTextCampaignSaved() {
        return campaignSaved.getText();
    }
}
