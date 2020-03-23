/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.campaigns;

import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.campaign.CampaignAbstractPage;

/**
 * Defines CampaignsPageLightning.
 *
 * @author Alan Escalera.
 * @version 1.0 19 March 2020.
 */
public class CampaignsPageLightning extends CampaignsPageAbstract {
    @FindBy(xpath = "//a[@title='New']")
    private WebElement newButton;
    protected static final String NAME_CAMPAIGN = "a[title='%s']";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(newButton));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(newButton));
    }

    @Override
    public NewCampaignPageAbstract clickOnNewButton() {
        newButton.click();
        return AppPageFactory.getNewCampaignPage();
    }

    @Override
    public CampaignAbstractPage selectCampaignName(final String campaignName) {
        String opportunityNameCss = String.format(NAME_CAMPAIGN, campaignName);
        nameCampaignSelected = WebDriverManager.getInstance().getWebDriver().findElement(By
                .cssSelector(opportunityNameCss));
        nameCampaignSelected.click();
        return AppPageFactory.getCampaignPage();
    }

}
