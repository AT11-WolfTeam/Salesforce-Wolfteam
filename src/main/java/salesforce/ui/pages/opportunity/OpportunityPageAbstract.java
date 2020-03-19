/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunity;

import salesforce.ui.pages.BasePage;

/**
 * Manages a web page.
 *
 * @author Enrique Carrizales.
 * @version 1.0 19 March 2020.
 */
public abstract class OpportunityPageAbstract extends BasePage {

    /**
     * Display all opportunities.
     */
    protected abstract void displayAllOpportunities();
}
