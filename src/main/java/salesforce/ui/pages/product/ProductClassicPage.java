/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.product;

import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.product.newpricebookentry.AbstractNewPriceBookEntryPage;

/**
 * Defines NewProductClassicPage.
 *
 * @author Alan Escalera.
 * @version 1.0 1 April 2020.
 */
public class ProductClassicPage extends AbstractProductPage {
    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public AbstractNewPriceBookEntryPage clickOnAddStandardPriceButton() {
        return AppPageFactory.getNewPriceBookEntry();
    }
}
