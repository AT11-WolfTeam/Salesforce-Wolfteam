/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.product;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.product.newpricebookentry.AbstractNewPriceBookEntryPage;

/**
 * Defines NewProductLightningPopUp.
 *
 * @author Alan Escalera.
 * @version 1.0 1 April 2020.
 */
public class ProductLightningPage extends AbstractProductPage {
    @FindBy(xpath = "//span[@class='title' and text()='Related']")
    private WebElement relatedTab;

    @FindBy(xpath = "//a[@title='Add Standard Price']")
    private WebElement addStandardPriceButton;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(relatedTab));
    }

    @Override
    public AbstractNewPriceBookEntryPage clickOnAddStandardPriceButton() {
        clickOnRelatedTab();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addStandardPriceButton));
        addStandardPriceButton.click();
        return AppPageFactory.getNewPriceBookEntry();
    }

    /**
     * Clicks on Related Tab.
     */
    private void clickOnRelatedTab() {
        relatedTab.click();
    }
}
