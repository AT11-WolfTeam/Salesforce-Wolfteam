/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.oportunitieslist;

import salesforce.ui.pages.AbstractBasePage;

/**
 * Defines an OpportunitiesListPageAbstract page.
 *
 * @author Enrique Carrizales.
 * @version 1.0 17 March 2020.
 */
public abstract class AbstractOpportunityListPage extends AbstractBasePage {

    /**
     * Clicks on a specific opportunity.
     *
     * @param opportunityName contains an String value.
     */
    public abstract void clickOnOpportunity(String opportunityName);
    public abstract String getStageName(String opportunityName);
}
