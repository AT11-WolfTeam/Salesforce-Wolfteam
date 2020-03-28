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
import salesforce.ui.components.span.AbstractUpdateLeadMessage;
import salesforce.ui.components.span.AddLeadClassicMessage;
import salesforce.ui.components.span.AddLeadLightningMessageSpan;
import salesforce.ui.pages.campaign.AbstractCampaignPage;
import salesforce.ui.pages.campaign.CampaignClassicPage;
import salesforce.ui.pages.campaign.CampaignLightningPage;
import salesforce.ui.pages.campaignLeads.AbstractCampaignLeadsPage;
import salesforce.ui.pages.campaignLeads.CampaignLeadsClassicPage;
import salesforce.ui.pages.campaignLeads.CampaignLeadsLightningPage;
import salesforce.ui.pages.campaigncontact.AbstractCampaignContactPage;
import salesforce.ui.pages.campaigncontact.CampaignContactClassicPage;
import salesforce.ui.pages.campaigncontact.CampaignContactPopupLightningPage;
import salesforce.ui.pages.campaignlist.AbstractCampaignListPage;
import salesforce.ui.pages.campaignlist.CampaignListClassicPage;
import salesforce.ui.pages.campaignlist.CampaignListLightningPage;
import salesforce.ui.pages.campaignmembers.AbstractCampaignMembersPage;
import salesforce.ui.pages.campaignmembers.CampaignMembersClassicPage;
import salesforce.ui.pages.campaignmembers.CampaignMembersLightningPage;
import salesforce.ui.pages.newcampaign.AbstractNewCampaignPage;
import salesforce.ui.pages.newcampaign.NewCampaignClassicPage;
import salesforce.ui.pages.newcampaign.NewCampaignLightningPopUp;
import salesforce.ui.pages.notesattachments.NotesAndAttachmentsClassicPage;
import salesforce.ui.pages.notesattachments.NotesAndAttachmentsLightningPage;
import salesforce.ui.pages.notesattachments.NotesAndAttachmentsPageAbstract;
import salesforce.ui.pages.oportunitieslist.AbstractOpportunityListPage;
import salesforce.ui.pages.oportunitieslist.OpportunityListClassicPage;
import salesforce.ui.pages.oportunitieslist.OpportunityListLightningPage;
import salesforce.ui.pages.genericTabs.AbstractTabObjectsPage;
import salesforce.ui.pages.genericTabs.TabObjectsClassicPage;
import salesforce.ui.pages.genericTabs.TabObjectsLightningPage;
import salesforce.ui.pages.opportunity.AbstractOpportunityPage;
import salesforce.ui.pages.opportunity.OpportunityClassicPage;
import salesforce.ui.pages.opportunity.OpportunityLightningPage;
import salesforce.ui.pages.opportunity.taskopportunity.AbstractTaskOpportunity;
import salesforce.ui.pages.opportunity.taskopportunity.TaskOpportunityClassic;
import salesforce.ui.pages.opportunity.taskopportunity.TaskOpportunityLightning;
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
    private static final String CLASSIC_USER_EXPERIENCE = "Classic";

    /**
     * Returns a page from a user experience.
     *
     * @return TopMenu instance.
     */
    public static TopMenuAbstract getTopMenu() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
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
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new CampaignListClassicPage();
        }
        return new CampaignListLightningPage();
    }

    /**
     * Allows to instance Opportunities page.
     *
     * @return OpportunitiesPage instance.
     */
    public static AbstractTabObjectsPage getTabObjectsPage() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new TabObjectsClassicPage();
        }
        return new TabObjectsLightningPage();
    }

    /**
     * Returns a campaigns page.
     *
     * @return CampaignsPage instance.
     */
    public static AbstractOpportunityPage getOpportunityPage() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
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
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
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
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
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
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
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
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new TaskClassicPage();
        }
        return new TaskLightningPage();
    }

    /**
     * Allows to identify notes and attachment user experience page.
     *
     * @return NotesAndAttachmentsPage instance.
     */
    public static NotesAndAttachmentsPageAbstract getNotesAndAttachments() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new NotesAndAttachmentsClassicPage();
        }
        return new NotesAndAttachmentsLightningPage();
    }

    /**
     * Allows to indentify campaign members user experience page.
     *
     * @return campaign members instance.
     */
    public static AbstractCampaignMembersPage getCampaignMembers() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new CampaignMembersClassicPage();
        }
        return new CampaignMembersLightningPage();
    }

    /**
     * Returns TaskOpportunity.
     *
     * @return task Opportunity instance.
     */
    public static AbstractTaskOpportunity getTaskOpportunity() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new TaskOpportunityClassic();
        }
        return new TaskOpportunityLightning();
    }

    /**
     * Allows to indentify campaign members user experience page.
     *
     * @return campaign members instance.
     */
    public static AbstractCampaignContactPage getCampaignContacts() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new CampaignContactClassicPage();
        }
        return new CampaignContactPopupLightningPage();
    }

    /**
     * Allows to get a web component message.
     *
     * @return a AddLeadLightningMessageSpan.
     */
    public static AbstractUpdateLeadMessage getAddLeadMessage() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new AddLeadClassicMessage();
        }
        return new AddLeadLightningMessageSpan();
    }

    /**
     * Allows to obtain leads details.
     *
     * @return a AbstractUpdateLeadMessage.
     */
    public static AbstractCampaignLeadsPage getCampaignLeadsPage() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new CampaignLeadsClassicPage();
        }
        return new CampaignLeadsLightningPage();
    }
}
