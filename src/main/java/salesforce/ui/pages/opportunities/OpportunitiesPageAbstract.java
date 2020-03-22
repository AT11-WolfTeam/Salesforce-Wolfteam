/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunities;

import org.openqa.selenium.WebElement;
import salesforce.ui.pages.BasePage;

/**
 * Defines OpportunitiesPageAbstract.
 *
 * @author Alan Escalera.
 * @version 1.0 19 March 2020.
 */
public abstract class OpportunitiesPageAbstract extends BasePage {
    protected WebElement nameOpportunitySelected;

    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Display a opportunity list.
     *
     * @param listName contains a String value.
     */
    public abstract void displayOpportunityList(String listName);

    /**
     * Selects a opportunity.
     *
     * @param opportunityName value.
     * @return OpportunityPage instance.
     */
    public abstract OpportunityPageAbstract selectOpportunityName(String opportunityName);
}
