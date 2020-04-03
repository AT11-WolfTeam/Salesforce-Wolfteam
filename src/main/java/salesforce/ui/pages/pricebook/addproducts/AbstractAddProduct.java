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
import salesforce.ui.pages.AbstractBasePage;

/**
 * Defines AbstractAddProduct.
 *
 * @author Alan Escalera.
 * @version 1.0 1 April 2020.
 */
public abstract class AbstractAddProduct extends AbstractBasePage {

    /**
     * Clicks on check box to add.
     *
     * @param productName value.
     */
    public abstract void checkProductToAdd(String productName);

    /**
     * Gets a web element.
     *
     * @param xpath value.
     * @param concatText value.
     * @return composed web element.
     */
    public WebElement getWebElement(final String xpath, final String concatText) {
        return webDriver.findElement(By.xpath(String.format(xpath, concatText)));
    }
}
