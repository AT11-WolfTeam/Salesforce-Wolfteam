/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.pricebook.editselectedpricebookentries;

import salesforce.entities.Product;
import salesforce.ui.pages.AbstractBasePage;
import salesforce.ui.pages.opportunity.opportunityproducts.AbstractOpportunityProductsPage;

/**
 * Defines AbstractEditSelectedPriceBookEntriesPage.
 *
 * @author Alan Escalera.
 * @version 1.0 1 April 2020.
 */
public abstract class AbstractEditSelectedPriceBookEntriesPage extends AbstractBasePage {

    /**
     * Clicks on save button.
     */
    public abstract void clickOnSaveButton();

    /**
     * Completes product values.
     * @param product instance.
     * @return instance of opportunity products.
     */
    public abstract AbstractOpportunityProductsPage completeProductValues(Product product);
}
