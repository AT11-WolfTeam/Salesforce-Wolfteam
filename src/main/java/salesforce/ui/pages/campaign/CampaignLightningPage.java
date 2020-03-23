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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.campaigns.CampaignsPageAbstract;

public class CampaignLightningPage extends CampaignAbstractPage {
    private Actions actions;

    @FindBy(xpath = "//div[@title='Delete' and contains(text(),'Delete')]")
    private WebElement deleteCampaignScroll;

    @FindBy(xpath = "//button[@title='Delete' and @type='button']")
    private WebElement deleteButtonConfirm;

    @FindBy(xpath = "//div[@class='slds-grid primaryFieldRow']//div[@role='group']//li[@class='slds-button"
            + " slds-button--icon-border-filled oneActionsDropDown']//div[@class='uiMenu']")
    private WebElement iconDropDown;

    public CampaignLightningPage() {
        actions = new Actions(webDriver);
    }
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(iconDropDown));
    }

    @Override
    public CampaignsPageAbstract deleteCampaign() {
        clickIconDropDown();
        clickDeleteCampaignScroll();
        clickDeleteButtonConfirm();
        return AppPageFactory.getCampaignsPage();
    }

    private void clickIconDropDown(){
        iconDropDown.click();
    }

    private void clickDeleteCampaignScroll(){
        actions.moveToElement(deleteCampaignScroll).click().build().perform();
    }

    private void clickDeleteButtonConfirm(){
        deleteButtonConfirm.click();
    }
}
