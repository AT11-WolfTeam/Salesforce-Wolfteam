/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunity.taskopportunity;

import org.openqa.selenium.WebElement;
import salesforce.entities.TaskOpportunity;
import salesforce.entities.constants.TaskConstant;
import salesforce.ui.pages.AbstractBasePage;
import salesforce.ui.pages.task.AbstractTask;

import java.util.HashMap;
import java.util.Set;

/**
 * Defines AbstractTaskOpportunity.
 *
 * @author Alan Escalera.
 * @version 1.0 24 March 2020.
 */
public abstract class AbstractTaskOpportunity extends AbstractBasePage {
    protected WebElement taskNameSelected;

    /**
     * Sets Subject task.
     * @param subject value.
     */
    protected abstract void setSubjectTask(String subject);

    /**
     * Sets contact.
     * @param contact value.
     */
    protected abstract void setContact(String contact);

    protected abstract void setDueDate(String dueDate);

    /**
     * Clicks on task to edit.
     * @param task value.
     * @return TaskPage instance.
     */
    public abstract AbstractTask clickTaskToEdit(String task);

    /**
     * Clicks on save task.
     */
    public abstract void clickSaveTask();

    /**
     * Sets the form of new task.
     *
     * @param taskOpportunity entity.
     * @param fields map.
     */
    public void setNewTask(final TaskOpportunity taskOpportunity, final Set<String> fields) {
        HashMap<String, Runnable> strategtyMap = composeStrategyMap(taskOpportunity);
        fields.forEach(field -> strategtyMap.get(field).run());
    }

    /**
     * Sets the information to Task.
     *
     * @param taskOpportunity entity.
     * @return HashMap value.
     */
    protected HashMap<String, Runnable> composeStrategyMap(final TaskOpportunity taskOpportunity) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(TaskConstant.SUBJECT, () -> setSubjectTask(taskOpportunity.getSubject()));
        strategyMap.put(TaskConstant.CONTACT, () -> setContact(taskOpportunity.getContact()));
        strategyMap.put(TaskConstant.DUE_DATE, () -> setDueDate(taskOpportunity.getDueDate()));
        return strategyMap;
    }
}
