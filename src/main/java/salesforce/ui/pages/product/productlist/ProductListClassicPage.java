/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.product.productlist;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.product.ProductClassicPage;

/**
 * Defines ProductListClassicPage.
 *
 * @author Alan Escalera.
 * @version 1.0 3 April 2020.
 */
public class ProductListClassicPage extends AbstractProductListPage {
    private static final String PRODUCT_CELL_PARTIAL_LOCATOR = "//div[@class='hotListElement']//th//a[text()='%s']";

    @FindBy(css = "input[title='New']")
    private WebElement newButton;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(newButton));
    }

    @Override
    public void deleteAProduct(final String productName) {
        webDriver.findElement(By.xpath(String.format(PRODUCT_CELL_PARTIAL_LOCATOR, productName))).click();
        ProductClassicPage productClassicPage = new ProductClassicPage();
        productClassicPage.clickOnDeleteButton();
    }
}
