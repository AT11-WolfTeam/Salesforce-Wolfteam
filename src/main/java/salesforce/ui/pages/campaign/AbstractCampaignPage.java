/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.campaign;

import salesforce.entities.Lead;
import salesforce.ui.pages.AbstractBasePage;
import salesforce.ui.pages.campaignlist.AbstractCampaignListPage;

import java.util.ArrayList;

/**
 * Defines CampaignAbstractPage.
 *
 * @author Alan Escalera.
 * @version 1.0 22 March 2020.
 */
public abstract class AbstractCampaignPage extends AbstractBasePage {
    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Deletes Campaign.
     *
     * @return CampaignsPageAbstract instance.
     */
    public abstract AbstractCampaignListPage deleteCampaign();

    /**
     * Add leads to a Campaign.
     * @param leadArrayList
     */
    public abstract void addLeads(ArrayList<Lead> leadArrayList);

}
