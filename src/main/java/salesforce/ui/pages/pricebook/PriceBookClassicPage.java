/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.pricebook;

import salesforce.ui.pages.pricebook.addproducts.AbstractAddProduct;

/**
 * Defines PriceBookClassicPage.
 *
 * @author Alan Escalera.
 * @version 1.0 1 April 2020.
 */
public class PriceBookClassicPage extends AbstractPriceBookPage {
    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public void clickOnRelatedTab() {

    }

    @Override
    public AbstractAddProduct clickOnAddProductsButton() {
        return null;
    }

    @Override
    public String getProductName(final String productName) {
        return null;
    }

    @Override
    public String getListPrice() {
        return null;
    }

    @Override
    public String getProductCode() {
        return null;
    }
}
