/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.pricebook.addproducts;

import salesforce.ui.pages.AbstractBasePage;
import salesforce.ui.pages.pricebook.editselectedpricebookentries.AbstractEditSelectedPriceBookEntriesPage;

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
     * Clicks on next button.
     * @return EditSelectedPriceBookEntriesPage instance.
     */
    public abstract AbstractEditSelectedPriceBookEntriesPage clickOnNextButton();
}
