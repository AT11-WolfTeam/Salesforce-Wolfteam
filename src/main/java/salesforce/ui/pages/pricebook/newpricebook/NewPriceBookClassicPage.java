/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.pricebook.newpricebook;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Defines NewPriceBookClassicPage.
 *
 * @author Alan Escalera.
 * @version 1.0 1 April 2020.
 */
public class NewPriceBookClassicPage extends AbstractNewPriceBookPage {
    @FindBy(css = "input[id='Name']")
    private WebElement priceBookNameField;

    @FindBy(css = "input[title='Save']")
    private WebElement saveButton;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(saveButton));
        webDriverWait.until(ExpectedConditions.visibilityOf(priceBookNameField));
    }

    @Override
    protected void clickOnSaveButton() {
        saveButton.click();
    }

    @Override
    protected void setPriceBookName(final String priceBookName) {
        priceBookNameField.sendKeys(priceBookName);
    }
}
