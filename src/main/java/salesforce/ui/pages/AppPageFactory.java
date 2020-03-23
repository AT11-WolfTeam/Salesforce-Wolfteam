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
import salesforce.ui.pages.campaign.CampaignAbstractPage;
import salesforce.ui.pages.campaign.CampaignClassicPage;
import salesforce.ui.pages.campaign.CampaignLightningPage;
import salesforce.ui.pages.campaigns.CampaignsPageAbstract;
import salesforce.ui.pages.campaigns.CampaignsPageClassic;
import salesforce.ui.pages.campaigns.CampaignsPageLightning;
import salesforce.ui.pages.campaigns.NewCampaignPageAbstract;
import salesforce.ui.pages.campaigns.NewCampaignPageClassic;
import salesforce.ui.pages.campaigns.NewCampaignPopUpLightning;
import salesforce.ui.pages.oportunitieslist.OpportunityListClassicPage;
import salesforce.ui.pages.oportunitieslist.OpportunityListLightningPage;
import salesforce.ui.pages.oportunitieslist.OpportunityListPageAbstract;
import salesforce.ui.pages.opportunities.OpportunitiesPageAbstract;
import salesforce.ui.pages.opportunities.OpportunitiesPageClassic;
import salesforce.ui.pages.opportunities.OpportunitiesPopUpLightning;
import salesforce.ui.pages.opportunity.OpportunityClassicPage;
import salesforce.ui.pages.opportunity.OpportunityLightningPage;
import salesforce.ui.pages.opportunity.OpportunityPageAbstract;

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
    public static CampaignsPageAbstract getCampaignsPage() {
        if (userExperience.equals("Classic")) {
            return new CampaignsPageClassic();
        }
        return new CampaignsPageLightning();


    }

    /**
     * Returns a Opportunities page.
     *
     * @return OpportunitiesPage instance.
     */
    public static OpportunitiesPageAbstract getOpportunitiesPage() {
        if (userExperience.equals("Classic")) {
            return new OpportunitiesPageClassic();
        }
        return new OpportunitiesPopUpLightning();
    }

    /**
     * Returns a Opportunity page.
     *
     * @return OpportunityPage instance.
     */
    public static OpportunityPageAbstract getOpportunityPage() {
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
    public static NewCampaignPageAbstract getNewCampaignPage() {
        if (userExperience.equals("Classic")) {
            return new NewCampaignPageClassic();
        }
        return new NewCampaignPopUpLightning();

    }

    /**
     * Returns a OpportunityList page.
     *
     * @return OpportunityListPage instance;
     */
    public static OpportunityListPageAbstract getOpportunityList() {
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
    public static CampaignAbstractPage getCampaignPage() {
        if (userExperience.equals("Classic")) {
            return new CampaignClassicPage();
        }
        return new CampaignLightningPage();
    }
}
