/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunity.choosepricebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * Manages opportunities choose price books page.
 *
 * @author Juan Martinez.
 * @version 1.0 02 april 2020.
 */
public class ChoosePriceBookClassicPage extends AbstractChoosePriceBook {
    @FindBy(name = "save")
    private WebElement saveButton;

    private static final String PRICE_BOOK_COMBOBOX = "p1";

    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Gets price book selector web element.
     *
     * @return selector web element.
     */
    private Select getPriceBookComboBox() {
        return new Select(webDriver.findElement(By.id(PRICE_BOOK_COMBOBOX)));
    }

    /**
     * Selects price book on combobox.
     *
     * @param priceBookName value.
     */
    private void selectPriceBookComboBox(final String priceBookName) {
        getPriceBookComboBox().selectByVisibleText(priceBookName);
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
        selectPriceBookComboBox(priceBookName);
        clickOnSaveButton();
    }
}
