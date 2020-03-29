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
import salesforce.utils.DateFormatter;
import salesforce.utils.JsonFileReader;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Manages Task information.
 *
 * @author Alan Escalera.
 * @version 1.0 24 March 2020.
 */
public class TaskOpportunity {
    private String subject;
    private String status;
    private String priority;
    private String contact;
    private String dueDate;
    private String assignedTo;

    private Set<String> modifiedTaskFields = new HashSet<>();
    private static final String JSON_CONFIG_FILE = "config.json";

    /**
     * Gets status value.
     *
     * @return status value.
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
     * Gets priority value.
     *
     * @return priority value.
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
     * Gets account value.
     *
     * @return account value.
     */
    public String getContact() {
        return contact;
    }

    /**
     * Sets account value.
     *
     * @param contact value.
     */
    public void setContact(final String contact) {
        this.contact = contact;
    }

    /**
     * Gets subject value.
     *
     * @return subject value.
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets account value.
     *
     * @param subject value.
     */
    public void setSubject(final String subject) {
        this.subject = subject;
    }

    /**
     * Gets dueDate value.
     *
     * @return dueDate value.
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * Sets dueDate value.
     *
     * @param dueDate value.
     */
    public void setDueDate(final String dueDate) {
        this.dueDate = DateFormatter.formatDateUi(dueDate);
    }

    /**
     * Gets getAssignTo value.
     *
     * @return assignTo value.
     */
    public String getAssignedTo() {
        return assignedTo;
    }

    /**
     * Sets assignTo value.
     *
     * @param assignedTo value.
     */
    public void setAssignedTo(final String assignedTo) {
        this.assignedTo = new JsonFileReader(JSON_CONFIG_FILE).getUser(assignedTo).getUsername();
    }

    /**
     * Strategy process information.
     *
     * @param mapOpportunity map.
     */
    public void processInformation(final Map<String, String> mapOpportunity) {
        HashMap<String, Runnable> strategyMap = composeStrategy(mapOpportunity);
        mapOpportunity.keySet().forEach(key -> strategyMap.get(key).run());
        modifiedTaskFields.addAll(mapOpportunity.keySet());
    }

    /**
     * ComposeStrategy to set attributes.
     *
     * @param mapTask map.
     * @return HashMap values.
     */
    private HashMap<String, Runnable> composeStrategy(final Map<String, String> mapTask) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(TaskConstant.PRIORITY, () -> setPriority(mapTask.get(TaskConstant.PRIORITY)));
        strategyMap.put(TaskConstant.SUBJECT, () -> setSubject(mapTask.get(TaskConstant.SUBJECT)));
        strategyMap.put(TaskConstant.STATUS, () -> setStatus(mapTask.get(TaskConstant.STATUS)));
        strategyMap.put(TaskConstant.CONTACT, () -> setContact(mapTask.get(TaskConstant.CONTACT)));
        strategyMap.put(TaskConstant.DUE_DATE, () -> setDueDate(mapTask.get(TaskConstant.DUE_DATE)));
        strategyMap.put(TaskConstant.ASSIGNED_TO, () -> setAssignedTo(mapTask.get(TaskConstant.ASSIGNED_TO)));
        return strategyMap;
    }

    /**
     * Gets map of the information set.
     *
     * @return HashMap values.
     */
    public HashMap<String, String> getTaskEdited() {
        HashMap<String, String> taskValues = new HashMap<>();
        HashMap<String, Supplier> strategyMapTaskEdited = composeTaskDetailsToGet();
        for (String key : modifiedTaskFields) {
            taskValues.put(key, strategyMapTaskEdited.get(key).get().toString());
        }
        return taskValues;
    }

    /**
     * composeOpportunityDetailsToGet to get attributes.
     *
     * @return HashMap values.
     */
    private HashMap<String, Supplier> composeTaskDetailsToGet() {
        HashMap<String, Supplier> strategyMap = new HashMap<>();
        strategyMap.put(TaskConstant.PRIORITY, () -> getPriority());
        strategyMap.put(TaskConstant.STATUS, () -> getStatus());
        strategyMap.put(TaskConstant.SUBJECT, () -> getSubject());
        strategyMap.put(TaskConstant.CONTACT, () -> getContact());
        strategyMap.put(TaskConstant.DUE_DATE, () -> getDueDate());
        strategyMap.put(TaskConstant.ASSIGNED_TO, () -> getAssignedTo());
        return strategyMap;
    }
}
