/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.campaignLeads;

import salesforce.entities.Lead;
import salesforce.ui.pages.AbstractBasePage;
import java.util.List;

/**
 * Defines AbstractCampaignLeadsPage.
 *
 * @author Enrique Carrizales.
 * @version 1.0 27 March 2020.
 */
public abstract class AbstractCampaignLeadsPage extends AbstractBasePage {

    /**
     * Counts leads added to a campaign.
     *
     * @param leadList contains a list value.
     * @return a int value.
     */
    public abstract int countLeadsInList(List<Lead> leadList);
}
