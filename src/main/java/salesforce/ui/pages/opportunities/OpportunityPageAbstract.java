/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunities;

import org.openqa.selenium.WebElement;
import salesforce.entities.NewCampaign;
import salesforce.ui.pages.BasePage;

import java.util.HashMap;
import java.util.Set;

/**
 * Defines OpportunitiesPageClassic.
 *
 * @author Alan Escalera.
 * @version 1.0 19 March 2020.
 */
public abstract class OpportunityPageAbstract extends BasePage {
    private static final String CAMPAIGN_NAME = "Campaign Name";
    protected WebElement campaignNameSelect;

    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Assigns a campaign.
     * @param campaignName value.
     */
    protected abstract void assignCampaign(String campaignName);


    public void editOpportunity(final NewCampaign newCampaign, final Set<String> fields) {
        HashMap<String, Runnable> strategtyMap = composeStrategyMap(newCampaign);
        fields.forEach(field -> strategtyMap.get(field).run());
    }

    /**
     * Sets the information of new campaign.
     *
     * @param newCampaign entity.
     * @return HashMap value.
     */
    protected HashMap<String, Runnable> composeStrategyMap(final NewCampaign newCampaign) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(CAMPAIGN_NAME, () -> assignCampaign(newCampaign.getCampaignName()));
        return strategyMap;
    }

    /**
     * clicks on Save Button.
     */
    protected abstract void clickSaveButton();
}
