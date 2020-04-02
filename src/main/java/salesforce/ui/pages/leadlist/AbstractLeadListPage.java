/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.leadlist;

import salesforce.entities.Lead;
import salesforce.ui.pages.AbstractBasePage;

import java.util.List;

/**
 * Manages AbstractLeadListPage.
 *
 * @author Enrique Carrizales.
 * @version 1.0 29 March 2020.
 */
public abstract class AbstractLeadListPage extends AbstractBasePage {

    /**
     * Changes Lead Status of leads.
     *
     * @param leads contains a Lead object list.
     */
    public void changeLeadStatus(final List<Lead> leads) {
        for (Lead lead : leads) {
            clickOnCheckButton(lead);
        }
        clickOnChangeStatusLeadButton();
    }

    /**
     * Reviews leads in a page.
     *
     * @param leads contains a list value.
     * @return int value.
     */
    public abstract List<Lead> getLeadsUpdated(List<Lead> leads);

    /**
     * Clicks on a Change Status button.
     */
    protected abstract void clickOnChangeStatusLeadButton();

    /**
     * Clicks on a Check box of a row in lead table.
     *
     * @param lead contains an object.
     */
    protected abstract void clickOnCheckButton(Lead lead);
}
