/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunity;

import org.openqa.selenium.WebElement;
import salesforce.entities.OpportunityUi;
import salesforce.ui.pages.AbstractBasePage;
import salesforce.ui.pages.opportunity.taskopportunity.AbstractTaskOpportunity;
import salesforce.ui.pages.task.AbstractTask;

import java.util.HashMap;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Defines OpportunitiesClassicPage.
 *
 * @author Alan Escalera.
 * @version 1.0 19 March 2020.
 */
public abstract class AbstractOpportunityPage extends AbstractBasePage {
    private static final String CAMPAIGN_NAME = "Campaign Name";
    protected WebElement campaignNameSelect;

    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Assigns a campaign.
     *
     * @param campaignName value.
     */
    protected abstract void assignCampaign(String campaignName);

    /**
     * Sets the form of new Campaign.
     *
     * @param opportunityUi entity.
     * @param fields      map.
     */
    public void editOpportunity(final OpportunityUi opportunityUi, final Set<String> fields) {
        HashMap<String, Runnable> strategtyMap = composeStrategyMap(opportunityUi);
        fields.forEach(field -> strategtyMap.get(field).run());
    }

    /**
     * Sets the information of new campaign.
     *
     * @param opportunityUi entity.
     * @return HashMap value.
     */
    protected HashMap<String, Runnable> composeStrategyMap(final OpportunityUi opportunityUi) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(CAMPAIGN_NAME, () -> assignCampaign(opportunityUi.getCampaignName()));
        return strategyMap;
    }

    /**
     * Gets map of the information set.
     *
     * @return HashMap values.
     */
    public HashMap<String, String> getOpportunityDetails() {
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
        strategyMap.put(CAMPAIGN_NAME, () -> getCampaignName());
        return strategyMap;
    }

    /**
     * Returns Campaign Name.
     *
     * @return String value.
     */
    protected abstract String getCampaignName();

    /**
     * clicks on Save Button.
     */
    public abstract void clickSaveButton();

    /**
     * Changes an Opportunity owner.
     * @param ownerType contains a String value.
     */
    public abstract void changeOwner(String ownerType);

    /**
     * Returns an Opportunity owner.
     * @param ownerType contains a String value.
     * @return String value.
     */
    public abstract String getOwner(String ownerType);

    /**
     * Clicks on Add task.
     */
    public abstract AbstractTaskOpportunity clickAddTask();


    /**
     * Allows to open notes and attachments page.
     */
    public abstract void clickOnNotesAndAttachmentsButton();

}
