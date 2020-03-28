/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.genericTabs;

import org.openqa.selenium.WebElement;
import salesforce.ui.pages.AbstractBasePage;
import salesforce.ui.pages.opportunity.AbstractOpportunityPage;

/**
 * Defines AbstractOpportunitiesPage.
 *
 * @author Alan Escalera.
 * @version 1.0 19 March 2020.
 */
public abstract class AbstractTabObjectsPage extends AbstractBasePage {
    protected WebElement nameOpportunitySelected;

    /**
     * Display a opportunity list.
     *
     * @param listName contains a String value.
     */
    public abstract void displayList(String listName);

    /**
     * Selects a opportunity.
     *
     * @param opportunityName value.
     * @return OpportunityPage instance.
     */
    public abstract AbstractOpportunityPage selectObjectByName(String opportunityName);

    /**
     * Displays an object.
     */
    public abstract void clickOnNewButton();

    /**
     * Deletes an object.
     *
     * @param nameObject contains a String value.
     */
    public abstract void clickOnDeleteButton(String nameObject);
}
