/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.entities;

import salesforce.entities.constants.TaskConstant;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Manages Task information.
 *
 * @author Alan Escalera.
 * @version 1.0 24 March 2020.
 */
public class TaskUi {
    private String subject;
    private String status;
    private String priority;
    private String account;

    /**
     * Returns status value.
     *
     * @return string value.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets status value.
     *
     * @param status value.
     */
    public void setStatus(final String status) {
        this.status = status;
    }

    /**
     * Returns priority value.
     *
     * @return string value.
     */
    public String getPriority() {
        return priority;
    }

    /**
     * Sets priority value.
     *
     * @param priority value.
     */
    public void setPriority(final String priority) {
        this.priority = priority;
    }

    /**
     * Returns account value.
     *
     * @return string value.
     */
    public String getAccount() {
        return account;
    }

    /**
     * Sets account value.
     *
     * @param account value.
     */
    public void setAccount(final String account) {
        this.account = account;
    }

    /**
     * Returns subject value.
     *
     * @return string value.
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets account value.
     *
     * @param subject value.
     */
    public void setSubject(String subject) {
        this.subject = subject;
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
     * @param mapTask map.
     * @return HashMap values.
     */
    private HashMap<String, Runnable> composeStrategy(final Map<String, String> mapTask) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(TaskConstant.SUBJECT, () -> setSubject(mapTask.get(TaskConstant.SUBJECT)));
        strategyMap.put(TaskConstant.STATUS, () -> setStatus(mapTask.get(TaskConstant.STATUS)));
        strategyMap.put(TaskConstant.PRIORITY, () -> setPriority(mapTask.get(TaskConstant.PRIORITY)));
        strategyMap.put(TaskConstant.ACCOUNT, () -> setAccount(mapTask.get(TaskConstant.ACCOUNT)));
        return strategyMap;
    }

    /**
     * Gets map of the information set.
     *
     * @return HashMap values.
     */
    public HashMap<String, String> getTaskEdited() {
        HashMap<String, String> values = new HashMap<>();
        HashMap<String, Supplier> strategyMapTaskEdited = composeTaskDetailsToGet();
        for (String key : strategyMapTaskEdited.keySet()) {
            values.put(key, strategyMapTaskEdited.get(key).get().toString());
        }
        System.out.println(values.toString());
        return values;
    }

    /**
     * composeOpportunityDetailsToGet to get attributes.
     *
     * @return HashMap values.
     */
    private HashMap<String, Supplier> composeTaskDetailsToGet() {
        HashMap<String, Supplier> strategyMap = new HashMap<>();
        strategyMap.put(TaskConstant.SUBJECT, () -> getSubject());
        strategyMap.put(TaskConstant.PRIORITY, () -> getPriority());
        strategyMap.put(TaskConstant.STATUS, () -> getStatus());
        strategyMap.put(TaskConstant.ACCOUNT, () -> getAccount());
        return strategyMap;
    }
}
