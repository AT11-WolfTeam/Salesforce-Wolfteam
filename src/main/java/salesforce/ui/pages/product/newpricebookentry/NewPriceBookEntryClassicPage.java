/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.product.newpricebookentry;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Defines NewPriceBookEntryClassicPage.
 *
 * @author Alan Escalera.
 * @version 1.0 1 April 2020.
 */
public class NewPriceBookEntryClassicPage extends AbstractNewPriceBookEntryPage {
    @FindBy(css = "input[title='Unit Price']")
    private WebElement standardPriceField;

    @FindBy(css = "input[title='Save']")
    private WebElement saveButton;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(standardPriceField));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(saveButton));
    }

    /**
     * Sets list price book value.
     *
     * @param listPriceValue string.
     */
    private void setListPriceField(final String listPriceValue) {
        standardPriceField.sendKeys(listPriceValue);
    }

    /**
     * Clicks on save button.
     */
    private void clickOnSaveButton() {
        saveButton.click();
    }

    @Override
    public void saveNewPriceBookEntity(final String listPriceValue, final String priceBookName) {
        setListPriceField(listPriceValue);
        clickOnSaveButton();
    }
}
