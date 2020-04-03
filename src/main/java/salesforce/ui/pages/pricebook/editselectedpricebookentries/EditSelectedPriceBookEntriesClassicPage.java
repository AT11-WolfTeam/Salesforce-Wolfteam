/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.pricebook.editselectedpricebookentries;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Defines EditSelectedPriceBookEntriesClassicPage.
 *
 * @author Alan Escalera.
 * @version 1.0 1 April 2020.
 */
public class EditSelectedPriceBookEntriesClassicPage extends AbstractEditSelectedPriceBookEntriesPage {
    @FindBy(xpath = "//td[@class='numericalColumn dataCell'] //input[@type='checkbox']")
    private WebElement checkBoxPrice;

    @FindBy(css = "input[title='Save']")
    private WebElement saveButton;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(checkBoxPrice));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(checkBoxPrice));
    }

    @Override
    public void clickOnSaveButton() {
        checkBoxPrice.click();
        saveButton.click();
    }
}
