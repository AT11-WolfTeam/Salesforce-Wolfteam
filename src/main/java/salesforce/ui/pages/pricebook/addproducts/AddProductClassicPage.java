/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.pricebook.addproducts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.pricebook.editselectedpricebookentries.AbstractEditSelectedPriceBookEntriesPage;

/**
 * Defines AddProductClassicPage.
 *
 * @author Alan Escalera.
 * @version 1.0 1 April 2020.
 */
public class AddProductClassicPage extends AbstractAddProduct {
    @FindBy(xpath = "//div[@class='modal-container slds-modal__container']//button[@title='Next']")
    private WebElement nextButton;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(nextButton));
    }

    @Override
    public void checkProductToAdd(final String productName) {

    }

    @Override
    public AbstractEditSelectedPriceBookEntriesPage clickOnNextButton() {
        nextButton.click();
        return AppPageFactory.getEditSelectedPriceBookEntriesPage();
    }
}
