/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.campaigns;

import org.openqa.selenium.WebElement;
import salesforce.ui.pages.BasePage;
import salesforce.ui.pages.campaign.CampaignAbstractPage;

/**
 * Defines CampaignsPageAbstract.
 *
 * @author Alan Escalera.
 * @version 1.0 19 March 2020.
 */
public abstract class CampaignsPageAbstract extends BasePage {
    protected WebElement nameCampaignSelected;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
    }

    /**
     * Clicks on the new button.
     *
     * @return NewCampaignPageAbstract instance.
     */
    public abstract NewCampaignPageAbstract clickOnNewButton();

    /**
     * Selects a campaign.
     *
     * @param campaignName value.
     * @return CampaignPageAbstract instance.
     */
    public abstract CampaignAbstractPage selectCampaignName(String campaignName);

}
