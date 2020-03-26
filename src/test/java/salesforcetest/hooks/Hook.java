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
import salesforce.ui.helpers.LeadHelper;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.PageTransporter;
import salesforce.ui.pages.campaign.AbstractCampaignPage;
import salesforce.ui.pages.campaignlist.AbstractCampaignListPage;

/**
 * Manages Hook instance.
 *
 * @author Alan Escalera.
 * @version 1.0 17 March 2020.
 */
public class Hook {
    private Context context;
    private AbstractCampaignListPage abstractCampaignListPage;
    private PageTransporter pageTransporter;
    private AbstractCampaignPage abstractCampaignPage;
    private OpportunityApiHelper opportunityApiHelper;
    private LeadHelper leadHelper;

    /**
     * Constructor Hook.
     *
     * @param context dependency injection.
     */
    public Hook(final Context context) {
        this.context = context;
        pageTransporter = new PageTransporter();
        opportunityApiHelper = new OpportunityApiHelper();
        leadHelper = new LeadHelper();
    }

    /**
     * Deletes campaign.
     */
    @After("@DeletesCampaign")
    public void deletesCampaign() {
        pageTransporter.navigateToPage("Campaigns Page");
        abstractCampaignListPage = AppPageFactory.getCampaignsPage();
        abstractCampaignPage = abstractCampaignListPage.selectCampaignName(context.getNewCampaign().getCampaignName());
        abstractCampaignListPage = abstractCampaignPage.deleteCampaign();
    }

    /**
     * Deletes opportunity.
     */
    @After("@DeletesOpportunity")
    public void deletesOpportunity() {
        leadHelper.deleteLeads(context.getLeads());
        final String expected = "204";
        for (Opportunity opportunity : context.getOpportunities()) {
            Assert.assertEquals(opportunity.getStatusCode(), expected);
        }
    }

    /**
     * Deletes leads.
     */
    @After("@DeletesLeads")
    public void deletesLeads() {
        opportunityApiHelper.deleteOpportunities(context.getOpportunities());
    }
}
