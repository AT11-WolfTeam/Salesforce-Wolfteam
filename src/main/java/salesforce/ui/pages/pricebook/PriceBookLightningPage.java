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
 * Defines PriceBookLightningPage.
 *
 * @author Alan Escalera.
 * @version 1.0 1 April 2020.
 */
public class PriceBookLightningPage extends AbstractPriceBookPage {
    @FindBy(xpath = "//span[text()='Related']")
    private WebElement relatedTab;

    @FindBy(xpath = "//a[@title='Add Products']")
    private WebElement addProductsButton;

    private String productNameTable;
    private static final String LIST_PRICE = "//div[1][article]//table//tbody//tr//th[1]//div//a[contains(text()"
         + ",'%s')]/../../..//td[2]";
    private static final String PRODUCT_NAME = "//div[1][article]//table//tbody//tr//th[1]//div//a[contains(text()"
         + ",'%s')]";
    private static final String PRODUCT_CODE = "//div[1][article]//table//tbody//tr//th[1]//div//a[contains(text()"
         + ",'%s')]/../../..//td[1]";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(relatedTab));
        webDriver.navigate().refresh();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(relatedTab));
    }

    /**
     * Clicks on Related Tab.
     */
    private void clickOnRelatedTab() {
        relatedTab.click();
    }

    @Override
    public AbstractAddProduct clickOnAddProductsButton() {
        clickOnRelatedTab();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addProductsButton));
        addProductsButton.click();
        return AppPageFactory.getAddProductPage();
    }

    @Override
    public String getProductName(final String productName) {
        productNameTable = webDriver.findElement(By.xpath(String.format(PRODUCT_NAME, productName))).getText();
        return productNameTable;
    }

    @Override
    public String getListPrice() {
        return  webDriver.findElement(By.xpath(String.format(LIST_PRICE, productNameTable))).getText();
    }

    @Override
    public String getProductCode() {
        return webDriver.findElement(By.xpath(String.format(PRODUCT_CODE, productNameTable))).getText();
    }
}
