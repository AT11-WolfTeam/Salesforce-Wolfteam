/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunity.choosepricebook;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Manages opportunities choose price book lightning popup.
 *
 * @author Juan Martinez.
 * @version 1.0 02 april 2020.
 */
public class ChoosePriceBookLightningPopup extends AbstractChoosePriceBook {
    @FindBy(xpath = "//div[@class='full']/div")
    private WebElement priceBookDropdownList;

    @FindBy(xpath = "//div[@class='modal-footer slds-modal__footer']//span[contains(text(), 'Save')]")
    private WebElement saveButton;

    private static final String PRICE_BOOK_ITEM = "//div[@class='full']/div//a[contains(text(), '%s')]";

    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Clicks on price book dropdownlist.
     */
    private void clickOnPriceBookDropdownList() {
        webDriverWait.until(ExpectedConditions.visibilityOf(priceBookDropdownList));
        priceBookDropdownList.click();
    }

    /**
     * Selects price book name.
     *
     * @param priceBookName value.
     */
    private void selectPriceBookItem(final String priceBookName) {
        WebElement item = getWebElement(PRICE_BOOK_ITEM, priceBookName);
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click();", item);
    }

    /**
     * Clicks on save button.
     */
    private void clickOnSaveButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(saveButton));
        saveButton.click();
    }

    @Override
    public void selectPriceBookByName(final String priceBookName) {
        clickOnPriceBookDropdownList();
        selectPriceBookItem(priceBookName);
        clickOnSaveButton();
    }
}
