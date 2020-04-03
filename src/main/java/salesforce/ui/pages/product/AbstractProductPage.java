/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.product;

import salesforce.ui.pages.AbstractBasePage;
import salesforce.ui.pages.product.newpricebookentry.AbstractNewPriceBookEntryPage;

/**
 * Defines AbstractNewProductPage.
 *
 * @author Alan Escalera.
 * @version 1.0 1 April 2020.
 */
public abstract class AbstractProductPage extends AbstractBasePage {

    /**
     * Clicks on add standard price button.
     *
     * @return NewPriceBookEntry instance.
     */
    public abstract AbstractNewPriceBookEntryPage clickOnAddStandardPriceButton();
}
