/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.pricebook;

import salesforce.ui.pages.AbstractBasePage;
import salesforce.ui.pages.pricebook.addproducts.AbstractAddProduct;

/**
 * Defines AbstractPriceBookPage.
 *
 * @author Alan Escalera.
 * @version 1.0 1 April 2020.
 */
public abstract class AbstractPriceBookPage extends AbstractBasePage {
    /**
     * Clicks on related tab.
     */
    public abstract void clickOnRelatedTab();

    /**
     * CLicks on add products button.
     * @return AddProduct instance.
     */
    public abstract AbstractAddProduct clickOnAddProductsButton();
}
