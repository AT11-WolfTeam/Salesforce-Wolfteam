/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforcetest.hooks;

import io.cucumber.java.After;
import salesforce.entities.Context;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.PageTransporter;
import salesforce.ui.pages.campaign.CampaignAbstractPage;
import salesforce.ui.pages.campaigns.CampaignsPageAbstract;

/**
 * Manages Hook instance.
 *
 * @author Alan Escalera.
 * @version 1.0 17 March 2020.
 */
public class Hook {
    private Context context;
    private CampaignsPageAbstract campaignsPageAbstract;
    private PageTransporter pageTransporter;
    private CampaignAbstractPage campaignAbstractPage;

    /**
     * Constructor Hook.
     *
     * @param context dependency injection.
     */
    public Hook(final Context context) {
        this.context = context;
        pageTransporter = new PageTransporter();
    }

    /**
     * Deletes campaign.
     */
    @After("@DeletesCampaign")
    public void deletesCampaign() {
        pageTransporter.navigateToPage("Campaigns Page");
        campaignsPageAbstract = AppPageFactory.getCampaignsPage();
        campaignAbstractPage = campaignsPageAbstract.selectCampaignName(context.getNewCampaign().getCampaignName());
        campaignsPageAbstract = campaignAbstractPage.deleteCampaign();
    }
}
