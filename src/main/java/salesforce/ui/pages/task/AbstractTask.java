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
import salesforce.entities.TaskUi;
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

    protected abstract void setSubject(String subject);

    /**
     * Returns subject.
     *
     * @return string value.
     */
    protected abstract String getSubject(String subject);

    /**
     * Sets the form of new task.
     *
     * @param taskUi entity.
     * @param fields map.
     */
    public void addInformationToTask(final TaskUi taskUi, final Set<String> fields) {
        HashMap<String, Runnable> strategtyMap = composeStrategyMap(taskUi);
        fields.forEach(field -> strategtyMap.get(field).run());
        modifiedTaskFields.addAll(fields);
    }

    /**
     * Sets the information to Task.
     *
     * @param taskUi entity.
     * @return HashMap value.
     */
    protected HashMap<String, Runnable> composeStrategyMap(final TaskUi taskUi) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(TaskConstant.PRIORITY, () -> setPriority(taskUi.getPriority()));
        strategyMap.put(TaskConstant.STATUS, () -> setStatus(taskUi.getStatus()));
        strategyMap.put(TaskConstant.SUBJECT, () -> setSubject(taskUi.getSubject()));
        return strategyMap;
    }

    /**
     * Gets map of the information set.
     *
     * @return HashMap values.
     */
    public HashMap<String, String> getTaskDetails(final TaskUi taskUi) {
        HashMap<String, String> values = new HashMap<>();
        HashMap<String, Supplier> strategyMapEducation = composeTaskDetailsToGet(taskUi);
        for (String key : modifiedTaskFields) {
            values.put(key, strategyMapEducation.get(key).get().toString());
        }
        return values;
    }

    /**
     * composeOpportunityDetailsToGet to get attributes.
     *
     * @return HashMap values.
     */
    private HashMap<String, Supplier> composeTaskDetailsToGet(final TaskUi taskUi) {
        HashMap<String, Supplier> strategyMap = new HashMap<>();
        strategyMap.put(TaskConstant.PRIORITY, () -> getPriority());
        strategyMap.put(TaskConstant.STATUS, () -> getStatus());
        strategyMap.put(TaskConstant.SUBJECT, () -> getSubject(taskUi.getSubject()));
        return strategyMap;
    }
}
