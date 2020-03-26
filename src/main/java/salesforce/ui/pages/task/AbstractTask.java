/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.task;

import org.openqa.selenium.WebElement;
import salesforce.entities.TaskOpportunity;
import salesforce.entities.constants.TaskConstant;
import salesforce.ui.pages.AbstractBasePage;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Defines an AbstractTask.
 *
 * @author Alan Escalera.
 * @version 1.0 23 March 2020.
 */
public abstract class AbstractTask extends AbstractBasePage {
    protected WebElement statusSelected;
    protected WebElement prioritySelected;
    protected WebElement subjectTitle;
    private Set<String> modifiedTaskFields = new HashSet<>();

    /**
     * Clicks on edit button.
     */
    public abstract void clickEditButton();

    /**
     * Sets status.
     *
     * @param statusToSelect value.
     */
    public abstract void setStatus(String statusToSelect);

    /**
     * Sets priority.
     *
     * @param priorityToSelect value.
     */
    public abstract void setPriority(String priorityToSelect);

    /**
     * Click on Save task button.
     */
    public abstract void clickOnSaveTaskButton();

    /**
     * Returns priority.
     *
     * @return string value.
     */
    protected abstract String getPriority();

    /**
     * Returns status.
     *
     * @return string value.
     */
    protected abstract String getStatus();

    /**
     * Sets subject.
     *
     * @param subject value.
     */
    protected abstract void setSubject(String subject);

    /**
     * Returns subject.
     *
     * @param subject value.
     * @return string value.
     */
    protected abstract String getSubject(String subject);

    /**
     * Sets Contact.
     *
     * @param contact value.
     */
    protected abstract void setContact(String contact);

    /**
     * Returns contact.
     *
     * @return string value.
     */
    protected abstract String getContact();

    /**
     * Sets due date.
     * @param dueDate value.
     */
    protected abstract void setDueDate(String dueDate);

    /**
     * Returns due date.
     *
     * @return string value
     */
    protected abstract String getDueDate();


    /**
     * Sets the form of new task.
     *
     * @param taskOpportunity entity.
     * @param fields map.
     */
    public void addInformationToTask(final TaskOpportunity taskOpportunity, final Set<String> fields) {
        HashMap<String, Runnable> strategtyMap = composeStrategyMap(taskOpportunity);
        fields.forEach(field -> strategtyMap.get(field).run());
        modifiedTaskFields.addAll(fields);
    }

    /**
     * Sets the information to Task.
     *
     * @param taskOpportunity entity.
     * @return HashMap value.
     */
    protected HashMap<String, Runnable> composeStrategyMap(final TaskOpportunity taskOpportunity) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(TaskConstant.PRIORITY, () -> setPriority(taskOpportunity.getPriority()));
        strategyMap.put(TaskConstant.STATUS, () -> setStatus(taskOpportunity.getStatus()));
        strategyMap.put(TaskConstant.SUBJECT, () -> setSubject(taskOpportunity.getSubject()));
        strategyMap.put(TaskConstant.CONTACT, () -> setContact(taskOpportunity.getContact()));
        strategyMap.put(TaskConstant.DUE_DATE, () -> setDueDate(taskOpportunity.getDueDate()));
        return strategyMap;
    }

    /**
     * Gets map of the information set.
     *
     * @param taskOpportunity object.
     * @return HashMap values.
     */
    public HashMap<String, String> getTaskDetails(final TaskOpportunity taskOpportunity) {
        HashMap<String, String> values = new HashMap<>();
        HashMap<String, Supplier> strategyMapEducation = composeTaskDetailsToGet(taskOpportunity);
        for (String key : modifiedTaskFields) {
            values.put(key, strategyMapEducation.get(key).get().toString());
        }
        return values;
    }

    /**
     * composeOpportunityDetailsToGet to get attributes.
     *
     * @param taskOpportunity object.
     * @return HashMap values.
     */
    private HashMap<String, Supplier> composeTaskDetailsToGet(final TaskOpportunity taskOpportunity) {
        HashMap<String, Supplier> strategyMap = new HashMap<>();
        strategyMap.put(TaskConstant.PRIORITY, () -> getPriority());
        strategyMap.put(TaskConstant.STATUS, () -> getStatus());
        strategyMap.put(TaskConstant.SUBJECT, () -> getSubject(taskOpportunity.getSubject()));
        strategyMap.put(TaskConstant.CONTACT, () -> getContact());
        strategyMap.put(TaskConstant.DUE_DATE, () -> getDueDate());
        return strategyMap;
    }
}
