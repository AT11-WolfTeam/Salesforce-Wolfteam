/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.pricebook.addproducts;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    @FindBy(css = "div[class='forceModalActionContainer--footerAction forceModalActionContainer']")
    private WebElement popupFooter;

    private static final String PRODUCT_CHECK_BOX = "//table//tbody//a[@title='%s']/../../..//label";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(popupFooter));
    }

    /**
     * Clicks on popup footer.
     */
    private void clickOnPopupFooter() {
        webDriverWait.until(ExpectedConditions.visibilityOf(popupFooter));
        popupFooter.click();
    }

    /**
     * Checks product by name.
     * @param productName value.
     */
    private void checkProduct(final String productName) {
        getWebElement(PRODUCT_CHECK_BOX, productName).click();
    }

    /**
     * Clicks on next button.
     */
    public void clickOnNextButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(nextButton));
        nextButton.click();
    }

    @Override
    public void checkProductToAdd(final String productName) {
        clickOnPopupFooter();
        checkProduct(productName);
        try {
            clickOnNextButton();
        } catch (StaleElementReferenceException StaleElement) {
            clickOnNextButton();
        }
//        return AppPageFactory.getEditSelectedPriceBookEntriesPage();
    }
}
