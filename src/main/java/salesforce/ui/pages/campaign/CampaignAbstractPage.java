/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.campaign;

import salesforce.ui.pages.BasePage;
import salesforce.ui.pages.campaigns.CampaignsPageAbstract;

public abstract class CampaignAbstractPage extends BasePage {
    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }
    public abstract CampaignsPageAbstract deleteCampaign();

}
