/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages;

import core.utils.GradleReader;
import salesforce.ui.components.menu.TopClassicMenu;
import salesforce.ui.components.menu.TopLightningMenu;
import salesforce.ui.components.menu.TopMenuAbstract;
import salesforce.ui.pages.campaign.AbstractCampaignPage;
import salesforce.ui.pages.campaign.CampaignClassicPage;
import salesforce.ui.pages.campaign.CampaignLightningPage;
import salesforce.ui.pages.campaignlist.AbstractCampaignListPage;
import salesforce.ui.pages.campaignlist.CampaignListClassicPage;
import salesforce.ui.pages.campaignlist.CampaignListLightningPage;
import salesforce.ui.pages.newcampaign.AbstractNewCampaignPage;
import salesforce.ui.pages.newcampaign.NewCampaignClassicPage;
import salesforce.ui.pages.newcampaign.NewCampaignLightningPopUp;
import salesforce.ui.pages.oportunitieslist.AbstractOpportunityListPage;
import salesforce.ui.pages.oportunitieslist.OpportunityListClassicPage;
import salesforce.ui.pages.oportunitieslist.OpportunityListLightningPage;
import salesforce.ui.pages.opportunities.AbstractOpportunitiesPage;
import salesforce.ui.pages.opportunities.OpportunitiesClassicPage;
import salesforce.ui.pages.opportunities.OpportunitiesLightningPage;
import salesforce.ui.pages.opportunity.AbstractOpportunityPage;
import salesforce.ui.pages.opportunity.OpportunityClassicPage;
import salesforce.ui.pages.opportunity.OpportunityLightningPage;
import salesforce.ui.pages.task.AbstractTask;
import salesforce.ui.pages.task.TaskClassicPage;
import salesforce.ui.pages.task.TaskLightningPage;

/**
 * Builds a page specific.
 *
 * @author Enrique Carrizales.
 * @version 1.0 17 March 2020.
 */
public class AppPageFactory {
    private static String userExperience = GradleReader.getInstance().getUserExperience();

    /**
     * Returns a page from a user experience.
     *
     * @return TopMenu instance.
     */
    public static TopMenuAbstract getTopMenu() {
        if (userExperience.equals("Classic")) {
            return new TopClassicMenu();
        }
        return new TopLightningMenu();
    }

    /**
     * Returns a campaigns page.
     *
     * @return CampaignsPage instance.
     */
    public static AbstractCampaignListPage getCampaignsPage() {
        if (userExperience.equals("Classic")) {
            return new CampaignListClassicPage();
        }
        return new CampaignListLightningPage();
    }

    /**
     * Returns a Opportunities page.
     *
     * @return OpportunitiesPage instance.
     */
    public static AbstractOpportunitiesPage getOpportunitiesPage() {
        if (userExperience.equals("Classic")) {
            return new OpportunitiesClassicPage();
        }
        return new OpportunitiesLightningPage();
    }

    /**
     * Returns a Opportunity page.
     *
     * @return OpportunityPage instance.
     */
    public static AbstractOpportunityPage getOpportunityPage() {
        if (userExperience.equals("Classic")) {
            return new OpportunityClassicPage();
        }
        return new OpportunityLightningPage();
    }

    /**
     * Returns a New campaigns page.
     *
     * @return NewCampaignsPage instance.
     */
    public static AbstractNewCampaignPage getNewCampaignPage() {
        if (userExperience.equals("Classic")) {
            return new NewCampaignClassicPage();
        }
        return new NewCampaignLightningPopUp();
    }

    /**
     * Returns a OpportunityList page.
     *
     * @return OpportunityListPage instance;
     */
    public static AbstractOpportunityListPage getOpportunityList() {
        if (userExperience.equals("Classic")) {
            return new OpportunityListClassicPage();
        }
        return new OpportunityListLightningPage();
    }

    /**
     * Returns a campaigns page.
     *
     * @return CampaignsPage instance.
     */
    public static AbstractCampaignPage getCampaignPage() {
        if (userExperience.equals("Classic")) {
            return new CampaignClassicPage();
        }
        return new CampaignLightningPage();
    }

    /**
     * Returns a task page.
     *
     * @return task instance.
     */
    public static AbstractTask getTaskPage() {
        if (userExperience.equals("Classic")) {
            return new TaskClassicPage();
        }
        return new TaskLightningPage();
    }
}
