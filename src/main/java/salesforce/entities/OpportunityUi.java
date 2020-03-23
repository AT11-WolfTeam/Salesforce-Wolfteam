/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.entities;

import salesforce.entities.constants.OpportunityConstant;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Manages OpportunityUi instance.
 *
 * @author Alan Escalera.
 * @version 1.0 21 March 2020.
 */
public class OpportunityUi {
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
     * Strategy process information.
     *
     * @param mapOpportunity map.
     */
    public void processInformation(final Map<String, String> mapOpportunity) {
        HashMap<String, Runnable> strategyMap = composeStrategy(mapOpportunity);
        mapOpportunity.keySet().forEach(key -> strategyMap.get(key).run());
    }

    /**
     * ComposeStrategy to set attributes.
     *
     * @param mapOpportunity map.
     * @return HashMap values.
     */
    private HashMap<String, Runnable> composeStrategy(final Map<String, String> mapOpportunity) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(OpportunityConstant.CAMPAIGN_NAME, () -> setCampaignName(mapOpportunity.get(OpportunityConstant
                .CAMPAIGN_NAME)));
        return strategyMap;
    }

    /**
     * Gets map of the information set.
     *
     * @return HashMap values.
     */
    public HashMap<String, String> getOpportunityEdit() {
        HashMap<String, String> values = new HashMap<>();
        HashMap<String, Supplier> strategyMapEducation = composeOpportunityDetailsToGet();
        for (String key : strategyMapEducation.keySet()) {
            values.put(key, strategyMapEducation.get(key).get().toString());
        }
        return values;
    }

    /**
     * composeOpportunityDetailsToGet to get attributes.
     *
     * @return HashMap values.
     */
    private HashMap<String, Supplier> composeOpportunityDetailsToGet() {
        HashMap<String, Supplier> strategyMap = new HashMap<>();
        strategyMap.put(OpportunityConstant.CAMPAIGN_NAME, () -> getCampaignName());
        return strategyMap;
    }

}
