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
import core.utils.UserExperience;
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
import salesforce.ui.pages.opportunities.OpportunitiesClassicPage;
import salesforce.ui.pages.opportunities.OpportunitiesLightningPage;
import salesforce.ui.pages.opportunity.OpportunityClassicPage;
import salesforce.ui.pages.opportunity.OpportunityLightningPage;
import salesforce.ui.pages.notesattachments.NotesAndAttachmentsClassicPage;
import salesforce.ui.pages.notesattachments.NotesAndAttachmentsLightningPage;
import salesforce.ui.pages.notesattachments.NotesAndAttachmentsPageAbstract;
import salesforce.ui.pages.opportunities.AbstractOpportunitiesPage;
import salesforce.ui.pages.opportunity.AbstractOpportunityPage;

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
        if (UserExperience.USER_EXPERIENCE_CLASSIC.get().equals(userExperience)) {
            return new OpportunitiesClassicPage();
        } else if (UserExperience.USER_EXPERIENCE_LIGHTNING.get().equals(userExperience)) {
            return new OpportunitiesLightningPage();
        }
        return null;
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
        if (UserExperience.USER_EXPERIENCE_CLASSIC.get().equals(userExperience)) {
            return new OpportunityListClassicPage();
        } else if (UserExperience.USER_EXPERIENCE_LIGHTNING.get().equals(userExperience)) {
            return new OpportunityListLightningPage();
        }
        return null;
    }

    /**
     * Returns a campaigns page.
     *
     * @return CampaignsPage instance.
     */
    public static AbstractOpportunityPage getOpportunityPage() {
        if (UserExperience.USER_EXPERIENCE_CLASSIC.get().equals(userExperience)) {
            return new OpportunityClassicPage();
        } else if (UserExperience.USER_EXPERIENCE_LIGHTNING.get().equals(userExperience)) {
            return new OpportunityLightningPage();
        }
        return null;
    }

    /**
     * Allows to identify notes and attachment user experience page.
     *
     * @return NotesAndAttachmentsPage instance.
     */
    public static NotesAndAttachmentsPageAbstract getNotesAndAttachments() {
        if (UserExperience.USER_EXPERIENCE_CLASSIC.get().equals(userExperience)) {
            return new NotesAndAttachmentsClassicPage();
        } else if (UserExperience.USER_EXPERIENCE_LIGHTNING.get().equals(userExperience)) {
            return new NotesAndAttachmentsLightningPage();
        }
        return null;
    }

    /**
     * Gets an instance campaign page.
     * @return campaign page.
     */
    public static AbstractCampaignPage getCampaignPage() {
        if (userExperience.equals("Classic")) {
            return new CampaignClassicPage();
        }
        return new CampaignLightningPage();
    }
}

