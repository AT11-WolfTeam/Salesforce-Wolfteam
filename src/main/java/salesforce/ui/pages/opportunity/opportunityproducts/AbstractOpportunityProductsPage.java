/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunity.opportunityproducts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import salesforce.ui.pages.AbstractBasePage;
import salesforce.ui.pages.pricebook.addproducts.AbstractAddProduct;
import java.util.ArrayList;

/**
 * Defines opportunities products pages.
 *
 * @author Juan Martinez.
 * @version 1.0 02 april 2020.
 */
public abstract class AbstractOpportunityProductsPage extends AbstractBasePage {

    /**
     * Enables the option to select price book.
     *
     * @param priceBookName value.
     * @return add product instance.
     */
    public abstract AbstractAddProduct choosePriceBook(String priceBookName);

    /**
     * Gets web element.
     *
     * @param xpath value.
     * @param concatText value.
     * @return composed web element.
     */
    public WebElement getWebElement(final String xpath, final String concatText) {
        return webDriver.findElement(By.xpath(String.format(xpath, concatText)));
    }

    /**
     * Validates opportunity product information.
     *
     * @param opportunityName value.
     * @param product name.
     * @return list of validation data.
     */
    public abstract ArrayList<String> validateProductInformation(String opportunityName, String product);
}
