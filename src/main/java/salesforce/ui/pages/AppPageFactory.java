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
import salesforce.ui.pages.campaigns.NewCampaignPageAbstract;
import salesforce.ui.pages.campaigns.NewCampaignPageClassic;
import salesforce.ui.pages.campaigns.NewCampaignPopUpLightning;
import salesforce.ui.pages.oportunitieslist.OpportunityListClassicPage;
import salesforce.ui.pages.oportunitieslist.OpportunityListLightningPage;
import salesforce.ui.pages.oportunitieslist.OpportunityListPageAbstract;
import salesforce.ui.pages.opportunities.OpportunitiesPageAbstract;
import salesforce.ui.pages.opportunities.OpportunitiesPageClassic;
import salesforce.ui.pages.opportunities.OpportunitiesPageLightning;
import salesforce.ui.pages.opportunity.OpportunityClassicPage;
import salesforce.ui.pages.opportunity.OpportunityLightningPage;
import salesforce.ui.pages.opportunity.OpportunityPageAbstract;
import salesforce.ui.pages.notesattachments.NotesAndAttachmentsClassicPage;
import salesforce.ui.pages.notesattachments.NotesAndAttachmentsLightningPage;
import salesforce.ui.pages.notesattachments.NotesAndAttachmentsPageAbstract;
import java.util.HashMap;
import java.util.Map;

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
        Map<String, TopMenuAbstract> map = new HashMap<>();
        map.put(UserExperience.USER_EXPERIENCE_CLASSIC.get(), new TopClassicMenu());
        map.put(UserExperience.USER_EXPERIENCE_LIGHTNING.get(), new TopLightningMenu());
        return map.get(userExperience);
    }

    /**
     * Returns a campaigns page.
     *
     * @return CampaignsPage instance.
     */
    public static NewCampaignPageAbstract getNewCampaignPage() {
        Map<String, NewCampaignPageAbstract> map = new HashMap<>();
        map.put(UserExperience.USER_EXPERIENCE_CLASSIC.get(), new NewCampaignPageClassic());
        map.put(UserExperience.USER_EXPERIENCE_LIGHTNING.get(), new NewCampaignPopUpLightning());
        return map.get(userExperience);
    }

    /**
     * Returns a Opportunities page.
     *
     * @return OpportunitiesPage instance.
     */
    public static OpportunitiesPageAbstract getOpportunitiesPage() {
        if (UserExperience.USER_EXPERIENCE_CLASSIC.get().equals(userExperience)) {
            return new OpportunitiesPageClassic();
        } else if (UserExperience.USER_EXPERIENCE_LIGHTNING.get().equals(userExperience)) {
            return new OpportunitiesPageLightning();
        }
        return null;
    }

    /**
     * Returns a OpportunityList page.
     *
     * @return OpportunityListPage instance;
     */
    public static OpportunityListPageAbstract getOpportunityList() {
        if (UserExperience.USER_EXPERIENCE_CLASSIC.get().equals(userExperience)) {
            return new OpportunityListClassicPage();
        } else if (UserExperience.USER_EXPERIENCE_LIGHTNING.get().equals(userExperience)) {
            return new OpportunityListLightningPage();
        }
        return null;
    }

    /**
     * Allows to identify opportunity user experience page.
     *
     * @return OpportunityPage instance.
     */
    public static OpportunityPageAbstract getOpportunityPage() {
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
}
