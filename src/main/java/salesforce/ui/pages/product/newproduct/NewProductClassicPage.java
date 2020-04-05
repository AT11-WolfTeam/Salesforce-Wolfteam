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
 * Defines NewProductClassicPage.
 *
 * @author Alan Escalera.
 * @version 1.0 1 April 2020.
 */
public class NewProductClassicPage extends AbstractNewProductPage {
    @FindBy(css = "input[id='Name']")
    private WebElement productNameField;

    @FindBy(css = "input[id='ProductCode']")
    private WebElement productCodeField;

    @FindBy(css = "textarea[id='Description']")
    private WebElement descriptionField;

    @FindBy(css = "input[title='Save']")
    private WebElement saveButton;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(productNameField));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(productNameField));
    }

    @Override
    protected void setProductName(final String productName) {
        productNameField.sendKeys(productName);
    }

    @Override
    protected void setProductCode(final String productCode) {
        productCodeField.sendKeys(productCode);
    }

    @Override
    protected void setProductDescription(final String productDescription) {
        descriptionField.sendKeys(productDescription);
    }

    @Override
    protected void clickOnSaveButton() {
        saveButton.click();
    }
}
