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
import org.testng.Assert;
import salesforce.api.requestapi.OpportunityApiHelper;
import salesforce.entities.Context;
import salesforce.entities.Opportunity;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.PageTransporter;
import salesforce.ui.pages.campaign.CampaignAbstractPage;
import salesforce.ui.pages.campaignlist.CampaignListPageAbstract;

/**
 * Manages Hook instance.
 *
 * @author Alan Escalera.
 * @version 1.0 17 March 2020.
 */
public class Hook {
    private Context context;
    private CampaignListPageAbstract campaignListPageAbstract;
    private PageTransporter pageTransporter;
    private CampaignAbstractPage campaignAbstractPage;
    private OpportunityApiHelper opportunityApiHelper;

    /**
     * Constructor Hook.
     *
     * @param context dependency injection.
     */
    public Hook(final Context context) {
        this.context = context;
        pageTransporter = new PageTransporter();
        opportunityApiHelper = new OpportunityApiHelper();
    }

    /**
     * Deletes campaign.
     */
    @After("@DeletesCampaign")
    public void deletesCampaign() {
        pageTransporter.navigateToPage("Campaigns Page");
        campaignListPageAbstract = AppPageFactory.getCampaignsPage();
        campaignAbstractPage = campaignListPageAbstract.selectCampaignName(context.getNewCampaign().getCampaignName());
        campaignListPageAbstract = campaignAbstractPage.deleteCampaign();
    }

    /**
     * Deletes opportunity.
     */
    @After("@DeletesOpportunity")
    public void deletesOpportunity() {
        opportunityApiHelper.deleteOpportunities(context.getOpportunities());
        final String expected = "204";
        for (Opportunity opportunity : context.getOpportunities()) {
            Assert.assertEquals(opportunity.getStatusCode(), expected);
        }
    }
}
