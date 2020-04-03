/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.pricebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.pricebook.addproducts.AbstractAddProduct;

/**
 * Defines PriceBookClassicPage.
 *
 * @author Alan Escalera.
 * @version 1.0 1 April 2020.
 */
public class PriceBookClassicPage extends AbstractPriceBookPage {
    @FindBy(css = "input[title='Add']")
    private WebElement addButton;

    private String productNameTable;
    private static final String PRODUCT_NAME = "//tr//th//a[text()='%s']";
    private static final String LIST_PRICE = "//tr//th//a[text()='%s']/../..//td[3]";
    private static final String PRODUCT_CODE = "//tr//th//a[text()='%s']/../..//td[2]";
    
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(addButton));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addButton));
    }

    @Override
    public AbstractAddProduct clickOnAddProductsButton() {
        addButton.click();
        return AppPageFactory.getAddProductPage();
    }

    @Override
    public String getProductName(final String productName) {
        productNameTable = webDriver.findElement(By.xpath(String.format(PRODUCT_NAME, productName))).getText();
        return webDriver.findElement(By.xpath(String.format(PRODUCT_NAME, productName))).getText();
    }

    @Override
    public String getListPrice() {
        return webDriver.findElement(By.xpath(String.format(LIST_PRICE, productNameTable))).getText();
    }

    @Override
    public String getProductCode() {
        return webDriver.findElement(By.xpath(String.format(PRODUCT_CODE, productNameTable))).getText();
    }
}
