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
import salesforce.entities.Opportunity;
import salesforce.entities.constants.OpportunityConstant;
import salesforce.ui.pages.AbstractBasePage;
import salesforce.ui.pages.opportunity.opportunitycontactroles.AbstractContactRolesPage;
import salesforce.ui.pages.opportunity.opportunityproducts.AbstractOpportunityProductsPage;
import salesforce.ui.pages.opportunity.taskopportunity.AbstractTaskOpportunity;
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
    protected WebElement campaignNameSelect;

    /**
     * Assigns a campaign.
     *
     * @param campaignName value.
     */
    protected abstract void assignCampaign(String campaignName);

    /**
     * Clicks on a Stage.
     *
     * @param stageName value.
     */
    public abstract void clickOnAStage(String stageName);

    /**
     * Clicks on mark as current stage button.
     */
    public abstract void clickOnMarkAsCurrentStageButton();

    /**
     * Clicks on Select close stage.
     *
     * @param closeAs value.
     */
    public abstract void clickOnSelectCloseStage(String closeAs);

    /**
     * Refresh the page.
     */
    public abstract void refreshPage();

    /**
     * Sets the form of new Campaign.
     *
     * @param opportunity entity.
     * @param fields map.
     */
    public void editOpportunity(final Opportunity opportunity, final Set<String> fields) {
        HashMap<String, Runnable> strategtyMap = composeStrategyMap(opportunity);
        fields.forEach(field -> strategtyMap.get(field).run());
    }

    /**
     * Sets the information of new campaign.
     *
     * @param opportunity entity.
     * @return HashMap value.
     */
    protected HashMap<String, Runnable> composeStrategyMap(final Opportunity opportunity) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(OpportunityConstant.PRIMARY_CAMPAIGN_SOURCE, () -> assignCampaign(opportunity
                .getPrimaryCampaignSource()));
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
        strategyMap.put(OpportunityConstant.PRIMARY_CAMPAIGN_SOURCE, () -> getCampaignName());
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
     *
     * @param ownerType contains a String value.
     */
    public abstract void changeOwner(String ownerType);

    /**
     * Returns an Opportunity owner.
     *
     * @param ownerType contains a String value.
     * @return String value.
     */
    public abstract String getOwner(String ownerType);

    /**
     * Clicks on Add task.
     *
     * @return TaskOpportunity instance.
     */
    public abstract AbstractTaskOpportunity clickAddTask();

    /**
     * Clicks on New Event tab button.
     */
    public abstract void clickOnNewEventTabButton();

    /**
     * Allows to open notes and attachments page.
     */
    public abstract void clickOnNotesAndAttachmentsButton();

    /**
     * Clicks on contact roles of campaign.
     *
     * @return an instance on contact role.
     */
    public abstract AbstractContactRolesPage clickOnContactRoles();

    /**
     * Enables to validate opportunity values.
     */
    public abstract void enableToValidateOpportunity();

    /**
     * Clicks on a event.
     *
     * @param subject contains a event name.
     */
    public abstract void clickOnEvent(String subject);

    /**
     * Allows to open products of the opportunity.
     *
     * @return opportunity products instance.
     */
    public abstract AbstractOpportunityProductsPage clickOnProducts();
}
