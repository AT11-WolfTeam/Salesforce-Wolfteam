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
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Defines AddProductClassicPage.
 *
 * @author Alan Escalera.
 * @version 1.0 1 April 2020.
 */
public class AddProductClassicPage extends AbstractAddProduct {
    @FindBy(css = "div[id='lineItemView_listBody']")
    private WebElement tableProducts;

    @FindBy(css = "input[title='Select']")
    private WebElement selectButton;

    private static final String PRODUCT_CHECK_BOX = "//div[@id='lineItemView_listBody']//tbody//span[text()='%s']"
         + "/../../../..//input";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(tableProducts));
    }

    @Override
    public void checkProductToAdd(final String productName) {
        webDriver.findElement(By.xpath(String.format(PRODUCT_CHECK_BOX, productName))).click();
        selectButton.click();
    }
}
