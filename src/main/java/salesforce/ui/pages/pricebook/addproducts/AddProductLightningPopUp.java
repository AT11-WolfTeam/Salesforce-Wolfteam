/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.pricebook.addproducts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.pricebook.editselectedpricebookentries.AbstractEditSelectedPriceBookEntriesPage;

/**
 * Defines AddProductLightningPopUp.
 *
 * @author Alan Escalera.
 * @version 1.0 1 April 2020.
 */
public class AddProductLightningPopUp extends AbstractAddProduct {
    @FindBy(xpath = "//div[@class='modal-container slds-modal__container']//button[@title='Next']")
    private WebElement nextButton;

    private static final String PRODUCT_CHECK_BOX = "//table//tbody//a[@title='%s']/../../..//label";

    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public void checkProductToAdd(final String productName) {
        webDriver.findElement(By.xpath(String.format(PRODUCT_CHECK_BOX, productName))).click();
    }

    @Override
    public AbstractEditSelectedPriceBookEntriesPage clickOnNextButton() {
        nextButton.click();
        return AppPageFactory.getEditSelectedPriceBookEntriesPage();
    }
}
