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
 * Defines NewProductClassicPage.
 *
 * @author Alan Escalera.
 * @version 1.0 1 April 2020.
 */
public class ProductClassicPage extends AbstractProductPage {
    @FindBy(css = "input[title='Add']")
    private WebElement addButton;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addButton));
        webDriverWait.until(ExpectedConditions.visibilityOf(addButton));
    }

    @Override
    public AbstractNewPriceBookEntryPage clickOnAddStandardPriceButton() {
        addButton.click();
        return AppPageFactory.getNewPriceBookEntry();
    }
}
