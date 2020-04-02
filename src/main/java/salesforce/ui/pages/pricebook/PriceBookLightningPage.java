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

    private String productNameString;

    private static final String ROW_TABLE = "//div[1][article]//table//tbody//tr[th[1][div[a[contains(text(),'%s')]]] and td[2][span[contains(text(),'%s')]]]";
    private static final String LIST_PRICE = "//div[1][article]//table//tbody//tr//th[1]//div//a[contains(text(),'%s')]/../../..//td[2]";
    private static final String PRODUCT_NAME = "//div[1][article]//table//tbody//tr//th[1]//div//a[contains(text(),'%s')]";


    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(relatedTab));
        webDriver.navigate().refresh();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(relatedTab));
    }

    @Override
    public void clickOnRelatedTab() {
        relatedTab.click();
    }

    @Override
    public AbstractAddProduct clickOnAddProductsButton() {
        addProductsButton.click();
        return AppPageFactory.getAddProductPage();
    }

    @Override
    public String getProductName(final String productName) {
        productNameString = webDriver.findElement(By.xpath(String.format(PRODUCT_NAME, productName))).getText();
        return productNameString;
    }

    @Override
    public String getListPrice() {
        return productNameString = webDriver.findElement(By.xpath(String.format(LIST_PRICE, productNameString))).getText();
    }


}
