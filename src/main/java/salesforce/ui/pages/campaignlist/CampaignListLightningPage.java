/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.campaignlist;

import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.campaign.AbstractCampaignPage;
import salesforce.ui.pages.newcampaign.AbstractNewCampaignPage;

/**
 * Defines CampaignsPageLightning.
 *
 * @author Alan Escalera.
 * @version 1.0 19 March 2020.
 */
public class CampaignListLightningPage extends AbstractCampaignListPage {
    @FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//div[@title='New']")
    private WebElement newButton;

    protected static final String NAME_CAMPAIGN = "//div[@class='windowViewMode-normal oneContent active lafPageHost']"
            + "//a[@title='%s']";
    private static final String CAMPAIGN_CHECKBOX = "//a[contains(text(),'%s')]/../../../td//a";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(newButton));
            webDriverWait.until(ExpectedConditions.visibilityOf(newButton));
        } catch (StaleElementReferenceException elementHasDisappeared) {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(newButton));
            webDriverWait.until(ExpectedConditions.visibilityOf(newButton));
        }
    }

    @Override
    public AbstractNewCampaignPage clickOnNewButton() {
        newButton.click();
        return AppPageFactory.getNewCampaignPage();
    }

    @Override
    public AbstractCampaignPage selectCampaignName(final String campaignName) {
        String opportunityNameXpath = String.format(NAME_CAMPAIGN, campaignName);
        nameCampaignSelected = WebDriverManager.getInstance().getWebDriver().findElement(By
                .xpath(opportunityNameXpath));
        nameCampaignSelected.click();
        return AppPageFactory.getCampaignPage();
    }

}
