/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.campaigns;

import salesforce.entities.NewCampaign;
import salesforce.ui.pages.BasePage;
import java.util.HashMap;
import java.util.Set;

/**
 * Defines NewCampaignPageAbstract.
 *
 * @author Alan Escalera.
 * @version 1.0 19 March 2020.
 */
public abstract class NewCampaignPageAbstract extends BasePage {
    private static final String CAMPAIGN_NAME = "Campaign Name";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
    }

    /**
     * Sets the form of new Campaign.
     *
     * @param newCampaign entity.
     * @param fields map.
     */
    protected void setNewCampaign(final NewCampaign newCampaign, final Set<String> fields) {
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
        strategyMap.put(CAMPAIGN_NAME, () -> setCampaignNameField(newCampaign.getCampaignName()));
        return strategyMap;
    }

    /**
     * Sets campaignNameField value.
     *
     * @param campaignName value.
     */
    protected abstract void setCampaignNameField(String campaignName);
}
