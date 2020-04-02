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
 * Defines NewPriceBookEntryLightningPopUp.
 *
 * @author Alan Escalera.
 * @version 1.0 1 April 2020.
 */
public class NewPriceBookEntryLightningPopUp extends AbstractNewPriceBookEntryPage {
    @FindBy(xpath = "//div[@class='windowViewMode-normal oneRecordActionWrapper isModal active lafPageHost']"
            + "//input[@class='input uiInputSmartNumber']")
    private WebElement listPriceField;

    @FindBy(xpath = "//div[@class='windowViewMode-normal oneRecordActionWrapper isModal active lafPageHost']"
            + "//button[@title='Save']")
    private WebElement saveButton;

    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Sets list price book value.
     *
     * @param listPriceValue string.
     */
    private void setListPriceField(final String listPriceValue) {
        webDriverWait.until(ExpectedConditions.visibilityOf(listPriceField));
        listPriceField.sendKeys(listPriceValue);
    }

    /**
     * Clicks on save button.
     */
    private void clickOnSaveButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(saveButton));
        saveButton.click();
    }

    @Override
    public void saveNewPriceBookEntity(final String listPriceValue, final String priceBookName) {
        setListPriceField(listPriceValue);
        clickOnSaveButton();
    }
}
