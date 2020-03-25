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
import salesforce.entities.OpportunityUi;
import salesforce.ui.pages.AbstractBasePage;
import salesforce.ui.pages.task.AbstractTask;

import java.util.HashMap;
import java.util.Set;

public abstract class AbstractTaskOpportunity extends AbstractBasePage {
    protected WebElement taskNameSelected;
    private static final String SUBJECT = "Subject";

    /**
     * Sets Subject task.
     */
    protected abstract void setSubjectTask(String subject);

    /**
     * Clicks on task to edit.
     */
    public abstract AbstractTask clickTaskToEdit(String task);

    /**
     * Clicks on save task.
     */
    public abstract void clickSaveTask();

    /**
     * Sets the form of new task.
     *
     * @param opportunityUi entity.
     * @param fields map.
     */
    public void setNewTask(final OpportunityUi opportunityUi, final Set<String> fields) {
        HashMap<String, Runnable> strategtyMap = composeStrategyMap(opportunityUi);
        fields.forEach(field -> strategtyMap.get(field).run());
    }

    /**
     * Sets the information to Task.
     *
     * @param opportunityUi entity.
     * @return HashMap value.
     */
    protected HashMap<String, Runnable> composeStrategyMap(final OpportunityUi opportunityUi) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(SUBJECT, () -> setSubjectTask(opportunityUi.getSubjectTask()));
        return strategyMap;
    }

}
