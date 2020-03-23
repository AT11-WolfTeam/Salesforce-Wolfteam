/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.campaign;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.campaigns.CampaignsPageAbstract;

/**
 * Defines CampaignClassicPage.
 *
 * @author Alan Escalera.
 * @version 1.0 22 March 2020.
 */
public class CampaignClassicPage extends CampaignAbstractPage {
    @FindBy(css = "input[title='Delete']")
    private WebElement deleteButton;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(deleteButton));
    }

    @Override
    public CampaignsPageAbstract deleteCampaign() {
        deleteButton.click();
        webDriverWait.until(ExpectedConditions.alertIsPresent());
        webDriver.switchTo().alert().accept();
        return AppPageFactory.getCampaignsPage();
    }
}
