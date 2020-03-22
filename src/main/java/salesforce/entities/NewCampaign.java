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
    private static final String ACTIVE = "Active";

    private String active;
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
    public void setCampaignName(final String campaignName) {
        this.campaignName = campaignName;
    }

    /**
     * Returns Active value.
     *
     * @return string value
     */
    public String getActive() {
        return active;
    }

    /**
     * Sets Active value.
     *
     * @param active value.
     */
    private void setActive(final String active) {
        this.active = active;
    }

    /**
     * Strategy process information.
     *
     * @param mapNewCampaign map.
     */
    public void processInformation(final Map<String, String> mapNewCampaign) {
        HashMap<String, Runnable> strategyMap = composeStrategy(mapNewCampaign);
        mapNewCampaign.keySet().forEach(key -> strategyMap.get(key).run());
    }

    /**
     * ComposeStrategy to set attributes.
     *
     * @param mapNewCampaign map.
     * @return HashMap values.
     */
    private HashMap<String, Runnable> composeStrategy(final Map<String, String> mapNewCampaign) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(CAMPAIGN_NAME, () -> setCampaignName(mapNewCampaign.get(CAMPAIGN_NAME)));
        strategyMap.put(ACTIVE, () -> setActive(mapNewCampaign.get(ACTIVE)));
        return strategyMap;
    }

}
