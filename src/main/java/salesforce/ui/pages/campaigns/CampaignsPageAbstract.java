/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.campaigns;

import salesforce.ui.pages.BasePage;

/**
 * Defines CampaignsPageAbstract.
 *
 * @author Alan Escalera.
 * @version 1.0 19 March 2020.
 */
public abstract class CampaignsPageAbstract extends BasePage {

    @Override
    protected void waitUntilPageObjectIsLoaded() {
    }

    /**
     * Clicks on the new button.
     *
     * @return NewCampaignPageAbstract instance.
     */
    public abstract NewCampaignPageAbstract clickOnNewButton();
}
