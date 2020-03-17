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
import salesforce.ui.pages.opportunities.OpportunitiesPageAbstract;
import salesforce.ui.pages.opportunities.OpportunitiesPageClassic;
import salesforce.ui.pages.opportunities.OpportunitiesPageLightning;

public class AppPageFactory {

    //Enum
    UserExperience userExperience = GradleReader.getInstance().getUserExperince();

    public static OpportunitiesPageAbstract getOpportunitiesPage() {
        if (userExperience == UserExperience.CLASSIC) {
            return new OpportunitiesPageClassic();
        } else if (userExperience == UserExperience.LIGHTNING) {
            return new OpportunitiesPageLightning();
        }
    }
}
