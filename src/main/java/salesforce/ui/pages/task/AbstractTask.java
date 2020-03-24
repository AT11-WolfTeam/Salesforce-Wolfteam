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
import salesforce.ui.pages.AbstractBasePage;

/**
 * Defines an AbstractTask.
 *
 * @author Alan Escalera.
 * @version 1.0 23 March 2020.
 */
public abstract class AbstractTask extends AbstractBasePage {
    protected WebElement statusSelected;
    protected WebElement prioritySelected;

    /**
     * Clicks on edit button.
     */
    public abstract void clickEditButton();

    /**
     * Select status.
     */
    public abstract void selectStatus(final String statusToSelect);

    /**
     * Select priority.
     */
    public abstract void selectPriority(final String priorityToSelect);

    /**
     * Click on Save task button.
     */
    public abstract void clickOnSaveTaskButton();

    /**
     * Returns priority.
     * @return string value.
     */
    protected abstract String getPriority();

    /**
     * Returns status.
     * @return string value.
     */
    protected abstract String getStatus();
}
