/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.pricebook.pricebooklist;

import salesforce.ui.pages.AbstractBasePage;

/**
 * Defines AbstractPriceBookListPage.
 *
 * @author Alan Escalera.
 * @version 1.0 3 April 2020.
 */
public abstract class AbstractPriceBookListPage extends AbstractBasePage {

    /**
     * Deletes a price book.
     *
     * @param priceBookName value.
     */
    public abstract void deleteAPriceBook(String priceBookName);
}
