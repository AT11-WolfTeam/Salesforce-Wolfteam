/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunity.opportunityproducts;

import salesforce.ui.pages.AbstractBasePage;
import salesforce.ui.pages.opportunity.choosepricebook.AbstractChoosePriceBook;

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
     * @return choose price book instance.
     */
    public abstract AbstractChoosePriceBook choosePriceBook();

    /**
     * adds products.
     */
    public abstract void addProducts();
}
