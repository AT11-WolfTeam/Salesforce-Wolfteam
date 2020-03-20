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
import salesforce.ui.pages.campaigns.CampaignsPageAbstract;
import salesforce.ui.pages.campaigns.CampaignsPageClassic;
import salesforce.ui.pages.campaigns.CampaignsPageLightning;
import salesforce.ui.pages.campaigns.NewCampaignPageAbstract;
import salesforce.ui.pages.campaigns.NewCampaignPageClassic;
import salesforce.ui.pages.campaigns.NewCampaignPopUpLightning;
import salesforce.ui.pages.opportunities.OpportunitiesPageAbstract;
import salesforce.ui.pages.opportunities.OpportunitiesPageClassic;
import salesforce.ui.pages.opportunities.OpportunitiesPopUpLightning;
import salesforce.ui.pages.opportunities.OpportunityPageAbstract;
import salesforce.ui.pages.opportunities.OpportunityPageClassic;
import salesforce.ui.pages.opportunities.OpportunityPopUpLightning;

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
    public static CampaignsPageAbstract getCampaignsPage() {
//        Map<String, CampaignsPageAbstract> map = new HashMap<>();
//        map.put(UserExperience.USER_EXPERIENCE_CLASSIC.get(), new CampaignsPageClassic());
//        map.put(UserExperience.USER_EXPERIENCE_LIGHTNING.get(), new CampaignsPageLightning());
//        return map.get(userExperience);
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
        Map<String, OpportunitiesPageAbstract> map = new HashMap<>();
        map.put(UserExperience.USER_EXPERIENCE_CLASSIC.get(), new OpportunitiesPageClassic());
        map.put(UserExperience.USER_EXPERIENCE_LIGHTNING.get(), new OpportunitiesPopUpLightning());
        return map.get(userExperience);
    }

    /**
     * Returns a Opportunity page.
     *
     * @return OpportunityPage instance.
     */
    public static OpportunityPageAbstract getOpportinityPage() {
        Map<String, OpportunityPageAbstract> map = new HashMap<>();
        map.put(UserExperience.USER_EXPERIENCE_CLASSIC.get(), new OpportunityPageClassic());
        map.put(UserExperience.USER_EXPERIENCE_LIGHTNING.get(), new OpportunityPopUpLightning());
        return map.get(userExperience);
    }

    /**
     * Returns a New campaigns page.
     *
     * @return NewCampaignsPage instance.
     */
    public static NewCampaignPageAbstract getNewCampaignPage() {
//        Map<String, NewCampaignPageAbstract> map = new HashMap<>();
//        map.put(UserExperience.USER_EXPERIENCE_CLASSIC.get(), new NewCampaignPageClassic());
//        map.put(UserExperience.USER_EXPERIENCE_LIGHTNING.get(), new NewCampaignPopUpLightning());
//        return map.get(userExperience);
        if (userExperience.equals("Classic")) {
            return new NewCampaignPageClassic();
        }
        return new NewCampaignPopUpLightning();

    }
}
