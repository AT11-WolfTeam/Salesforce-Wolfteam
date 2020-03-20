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
import salesforce.ui.pages.opportunity.OpportunitiesClassicPage;
import salesforce.ui.pages.opportunity.OpportunitiesLightningPage;
import salesforce.ui.pages.opportunity.OpportunitiesPageAbstract;

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
     * Returns a page from a user experience.
     * @return OpportunitiesPage instance.
     */
    public static OpportunitiesPageAbstract getOpportunitiesPage() {
        Map<String, OpportunitiesPageAbstract> map = new HashMap<>();
        map.put(UserExperience.USER_EXPERIENCE_CLASSIC.get(), new OpportunitiesClassicPage());
        map.put(UserExperience.USER_EXPERIENCE_LIGHTNING.get(), new OpportunitiesLightningPage());
        return map.get(userExperience);
    }
}
