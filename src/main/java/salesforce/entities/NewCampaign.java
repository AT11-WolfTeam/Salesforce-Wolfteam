/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.entities;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages NewCampaign instance.
 *
 * @author Alan Escalera.
 * @version 1.0 19 March 2020.
 */
public class NewCampaign {
    private static final String CAMPAIGN_NAME = "Campaign Name";
    private String campaignName;

    /**
     * Returns campaignName value.
     *
     * @return string value.
     */
    public String getCampaignName() {
        return campaignName;
    }

    /**
     * Sets campaignName value.
     *
     * @param campaignName value.
     */
    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    /**
     * Strategy process information
     *
     * @param mapNewCampaign map.
     */
    public void processInformation(Map<String, String> mapNewCampaign) {
        HashMap<String, Runnable> strategyMap = composeStrategy(mapNewCampaign);
        mapNewCampaign.keySet().forEach(key -> strategyMap.get(key).run());
    }

    /**
     * ComposeStrategy to set attributes.
     *
     * @param mapNewCampaign map.
     * @return HashMap values.
     */
    private HashMap<String, Runnable> composeStrategy(Map<String, String> mapNewCampaign) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(CAMPAIGN_NAME, () -> setCampaignName(mapNewCampaign.get(CAMPAIGN_NAME)));
        return strategyMap;
    }
}
