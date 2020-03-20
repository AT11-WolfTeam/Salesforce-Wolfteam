/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.campaigns;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.AppPageFactory;

/**
 * Defines CampaignsPageClassic.
 *
 * @author Alan Escalera.
 * @version 1.0 19 March 2020.
 */
public class CampaignsPageClassic extends CampaignsPageAbstract {
    @FindBy(xpath = "//input[@class='btn' and @name='new']")
    private WebElement newButton;

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
}
