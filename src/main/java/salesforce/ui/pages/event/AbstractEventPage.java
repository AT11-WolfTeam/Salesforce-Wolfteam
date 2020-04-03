/*
 *  Copyright (c) 2019 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.event;

import salesforce.entities.constants.EventConstant;
import salesforce.ui.pages.AbstractBasePage;
import java.util.HashMap;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Manages AbstractEventPage.
 *
 * @author Enrique Carrizales.
 * @version 1.0 02 April 2020.
 */
public abstract class AbstractEventPage extends AbstractBasePage {

    /**
     * Gets subject value.
     *
     * @return a String value.
     */
    protected abstract String getSubject();

    /**
     * Gets startDate value.
     *
     * @return a String value.
     */
    protected abstract String getStartDate();

    /**
     * Gets endDate value.
     *
     * @return a String value.
     */
    protected abstract String getEndDate();

    /**
     * Gets assignedTo value.
     *
     * @return a String value.
     */
    protected abstract String getAssignedTo();

    /**
     * Gets fields of UI.
     *
     * @return a hash map value.
     */
    private HashMap<String, Supplier> composeStrategyMap() {
        HashMap<String, Supplier> strategyMap = new HashMap<>();
        strategyMap.put(EventConstant.SUBJECT, this::getSubject);
        strategyMap.put(EventConstant.START_DATE, this::getStartDate);
        strategyMap.put(EventConstant.END_DATE, this::getEndDate);
        strategyMap.put(EventConstant.ASSIGNED_TO, this::getAssignedTo);
        return strategyMap;
    }

    /**
     * Gets fields with String value.
     *
     * @param fields contains a Set value.
     * @return a hash map value.
     */
    public HashMap<String, String> getEventResult(final Set<String> fields) {
        HashMap<String, String> values = new HashMap<>();
        HashMap<String, Supplier> strategyMap = composeStrategyMap();
        for (String field: fields) {
            values.put(field, strategyMap.get(field).get().toString());
        }
        return values;
    }
}
