/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.aplications;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.BasePage;

/**
 * Defines an AppsLightningOrderedMenu page.
 *
 * @author Enrique Carrizales.
 * @version 1.0 18 March 2020.
 */
public class AppsLightningOrderedMenu extends BasePage {
    @FindBy(css = "a[id='07p3h0000004JoeAAE']")
    private WebElement marketingButton;

    @FindBy(css = "button[class='slds-button']")
    private WebElement linkTextViewAll;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(linkTextViewAll));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(linkTextViewAll));
    }

    /**
     * Clicks on marketing button.
     */
    public void clickOnMarketingButton() {
        marketingButton.click();
    }
}
