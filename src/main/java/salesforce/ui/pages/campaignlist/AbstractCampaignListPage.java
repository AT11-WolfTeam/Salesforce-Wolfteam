/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.campaignlist;

import org.openqa.selenium.WebElement;
import salesforce.ui.pages.AbstractBasePage;
import salesforce.ui.pages.campaign.AbstractCampaignPage;
import salesforce.ui.pages.newcampaign.AbstractNewCampaignPage;

/**
 * Defines CampaignsPageAbstract.
 *
 * @author Alan Escalera.
 * @version 1.0 19 March 2020.
 */
public abstract class AbstractCampaignListPage extends AbstractBasePage {
    protected WebElement nameCampaignSelected;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
    }

    /**
     * Clicks on the new button.
     *
     * @return NewCampaignPageAbstract instance.
     */
    public abstract AbstractNewCampaignPage clickOnNewButton();

    /**
     * Selects a campaign.
     *
     * @param campaignName value.
     * @return CampaignPageAbstract instance.
     */
    public abstract AbstractCampaignPage selectCampaignName(String campaignName);
}
