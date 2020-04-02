/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.product.newproduct;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Defines NewProductLightningPopUp.
 *
 * @author Alan Escalera.
 * @version 1.0 1 April 2020.
 */
public class NewProductLightningPopUp extends AbstractNewProductPage {
    @FindBy(xpath = "//div[@class='windowViewMode-normal oneRecordActionWrapper isModal active lafPageHost']"
             + "//span[text()='Product Name']/../..//input")
    private WebElement productNameField;

    @FindBy(xpath = "//div[@class='windowViewMode-normal oneRecordActionWrapper isModal active lafPageHost']"
             + "//button[@title='Save']")
    private WebElement saveButton;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(productNameField));
    }

    @Override
    protected void setProductName(final String productName) {
        productNameField.sendKeys(productName);
    }

    @Override
    protected void setProductCode(final String productCode) {

    }

    @Override
    protected void setProductDescription(final String productDescription) {

    }

    @Override
    protected void clickOnSaveButton() {
        saveButton.click();
    }
}
