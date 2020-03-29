/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.newopportunity;

import salesforce.ui.pages.AbstractBasePage;
import salesforce.ui.pages.opportunity.AbstractOpportunityPage;

public abstract class AbstractNewOpportunityPage extends AbstractBasePage {
    /**
     * Sets Opportunity Name.
     *
     * @param opportunityName value.
     */
    protected abstract void setOpportunityName(String opportunityName);

    /**
     * Sets Close Date
     *
     * @param closeDate value.
     */
    protected abstract void setCloseDate(String closeDate);

    /**
     * Sets Stage.
     *
     * @param stage value.
     */
    protected abstract void setStage(String stage);

    public abstract AbstractOpportunityPage clickSaveOpportunityButton();
}
