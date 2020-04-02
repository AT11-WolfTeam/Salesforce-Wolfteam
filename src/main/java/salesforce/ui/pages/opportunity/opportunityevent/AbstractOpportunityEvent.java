/*
 *  Copyright (c) 2019 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunity.opportunityevent;

import salesforce.entities.OpportunityEvent;
import salesforce.entities.constants.EventConstant;
import salesforce.ui.pages.AbstractBasePage;
import java.util.HashMap;
import java.util.Set;

/**
 * Manages AbstractOpportunityEvent.
 *
 * @author Enrique Carrizales.
 * @version 1.0 02 April 2020.
 */
public abstract class AbstractOpportunityEvent extends AbstractBasePage {

    /**
     * Sets a subject field.
     *
     * @param subject contains a String value.
     */
    protected abstract void setSubject(String subject);

    /**
     * Sets a startDate field.
     *
     * @param startDate contains a String value.
     */
    protected abstract void setStartDate(String startDate);

    /**
     * Sets an endDate field.
     *
     * @param endDate contains a String value.
     */
    protected abstract void setEndDate(String endDate);

    /**
     * Sets an assignedTo field.
     *
     * @param assignedTo contains a String value.
     */
    protected abstract void setAssignedTo(String assignedTo);

    /**
     * Sets the information to Task.
     *
     * @param opportunityEvent contains an OpportunityEvent.
     * @return a HashMap value.
     */
    private HashMap<String, Runnable> composeStrategyMap(final OpportunityEvent opportunityEvent) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(EventConstant.SUBJECT, () -> setSubject(opportunityEvent.getSubject()));
        strategyMap.put(EventConstant.START_DATE, () -> setStartDate(opportunityEvent.getStartDate()));
        strategyMap.put(EventConstant.END_DATE, () -> setEndDate(opportunityEvent.getEndDate()));
        strategyMap.put(EventConstant.ASSIGNED_TO, () -> setAssignedTo(opportunityEvent.getAssignedTo()));
        return strategyMap;
    }

    /**
     * Sets the form of new task.
     *
     * @param opportunityEvent contains an OpportunityEvent.
     * @param fields contains a map.
     */
    public void setNewEvent(final OpportunityEvent opportunityEvent, final Set<String> fields) {
        HashMap<String, Runnable> strategtyMap = composeStrategyMap(opportunityEvent);
        fields.forEach(field -> strategtyMap.get(field).run());
    }
}
