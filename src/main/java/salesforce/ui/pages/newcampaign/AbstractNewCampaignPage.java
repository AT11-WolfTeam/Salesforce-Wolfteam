/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.newcampaign;

import salesforce.entities.NewCampaign;
import salesforce.ui.pages.AbstractBasePage;

import java.util.HashMap;
import java.util.Set;

/**
 * Defines NewCampaignPageAbstract.
 *
 * @author Alan Escalera.
 * @version 1.0 19 March 2020.
 */
public abstract class AbstractNewCampaignPage extends AbstractBasePage {
    private static final String CAMPAIGN_NAME = "Campaign Name";
    protected static final String IS_ACTIVE = "true";
    private static final String ACTIVE = "Active";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
    }

    /**
     * Sets the form of new Campaign.
     *
     * @param newCampaign entity.
     * @param fields      map.
     */
    public void setNewCampaign(final NewCampaign newCampaign, final Set<String> fields) {
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
        strategyMap.put(ACTIVE, () -> setCampaignActiveCheckBox(newCampaign.getActive()));
        return strategyMap;
    }

    /**
     * Sets campaignNameField value.
     *
     * @param campaignName value.
     */
    protected abstract void setCampaignNameField(String campaignName);

    /**
     * Sets CampaignActiveCheckBox.
     * @param campaignActive value.
     */
    protected abstract void setCampaignActiveCheckBox(String campaignActive);

    /**
     * clicks on Save Button.
     */
    public abstract void clickSaveButton();
}
