/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.newopportunity;

import salesforce.entities.Opportunity;
import salesforce.entities.constants.OpportunityConstant;
import salesforce.ui.pages.AbstractBasePage;
import salesforce.ui.pages.opportunity.AbstractOpportunityPage;

import java.util.HashMap;
import java.util.Set;

/**
 * Defines AbstractNewOpportunityPage.
 *
 * @author Alan Escalera.
 * @version 1.0 29 March 2020.
 */
public abstract class AbstractNewOpportunityPage extends AbstractBasePage {
    /**
     * Sets Opportunity Name.
     *
     * @param opportunityName value.
     */
    protected abstract void setOpportunityName(String opportunityName);

    /**
     * Sets Close Date.
     *
     * @param closeDate value.
     */
    protected abstract void setCloseDate(String closeDate);

    /**
     * Sets Stage.
     *
     * @param stage value.
     */
    protected abstract void setStage(String stage);

    /**
     * Returns AbstractOpportunityPage.
     *
     * @return instance.
     */
    public abstract AbstractOpportunityPage clickSaveOpportunityButton();

    /**
     * Sets the form of new Contract.
     *
     * @param newOpportunity entity.
     * @param fields map.
     */
    public void setNewOpportunity(final Opportunity newOpportunity, final Set<String> fields) {
        HashMap<String, Runnable> strategtyMap = composeStrategyMap(newOpportunity);
        fields.forEach(field -> strategtyMap.get(field).run());
    }

    /**
     * Sets the information of new Contract.
     *
     * @param newOpportunity entity.
     * @return HashMap value.
     */
    protected HashMap<String, Runnable> composeStrategyMap(final Opportunity newOpportunity) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(OpportunityConstant.NAME, () -> setOpportunityName(newOpportunity.getName()));
        strategyMap.put(OpportunityConstant.CLOSE_DATE, () -> setCloseDate(newOpportunity.getCloseDate()));
        strategyMap.put(OpportunityConstant.STAGE_NAME, () -> setStage(newOpportunity.getStageName()));
        return strategyMap;
    }
}
