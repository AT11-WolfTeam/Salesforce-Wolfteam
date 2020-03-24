/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.task;

/**
 * Defines an TaskClassicPage.
 *
 * @author Alan Escalera.
 * @version 1.0 23 March 2020.
 */
public class TaskClassicPage extends AbstractTask {
    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public void clickEditButton() {

    }

    @Override
    public void selectStatus(String statusToSelect) {

    }

    @Override
    public void selectPriority(String priorityToSelect) {

    }

    @Override
    public void clickOnSaveTaskButton() {

    }

    @Override
    protected String getPriority() {
        return null;
    }

    @Override
    protected String getStatus() {
        return null;
    }
}
