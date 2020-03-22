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

public class OpportunityUi {
    private String campaignName;

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

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

    public HashMap<String, String> getOpportunityEdit() {
        HashMap<String, String> values = new HashMap<>();
        HashMap<String, Supplier> strategyMapEducation = composeOpportunityDetailsToGet();
        for (String key : strategyMapEducation.keySet()) {
            values.put(key, strategyMapEducation.get(key).get().toString());
        }
        return values;
    }

    private HashMap<String, Supplier> composeOpportunityDetailsToGet() {
        HashMap<String, Supplier> strategyMap = new HashMap<>();
        strategyMap.put(OpportunityConstant.CAMPAIGN_NAME, () -> getCampaignName());
        return strategyMap;
    }

}
