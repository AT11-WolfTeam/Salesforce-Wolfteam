/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunities;

import salesforce.entities.Opportunity;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.BasePage;

public abstract class NewOpportunityPageAbstract extends BasePage {

    protected abstract void setOpportunityName(String opportunityName);

    public OpportunityPageAbstract createOpportunity(Opportunity opportunity) {
        //Do with strategy

        setOpportunityName(opportunity.getName());
        return AppPageFactory.getOpportunityPage();
    }
}
