/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunity.taskopportunity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.task.AbstractTask;

/**
 * Defines TaskOpportunityClassic.
 *
 * @author Alan Escalera.
 * @version 1.0 24 March 2020.
 */
public class TaskOpportunityClassic extends AbstractTaskOpportunity {
    @FindBy(xpath = "//input[@name='tsk5__09D3h0000012ZVJ']")
    private WebElement subjectField;

    @FindBy(xpath = "//input[@name='publishersharebutton']")
    private WebElement saveTaskButton;

    private static final String TASK_NAME = "//div[@class='taskInnerContent']//a[text()='%s']";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(subjectField));
    }

    @Override
    protected void setSubjectTask(final String subject) {
        subjectField.sendKeys(subject);
    }

    @Override
    public AbstractTask clickTaskToEdit(final String task) {
        String taskToEditXpath = String.format(TASK_NAME, task);
        taskNameSelected = webDriver.findElement(By.xpath(taskToEditXpath));
        taskNameSelected.click();
        return AppPageFactory.getTaskPage();
    }

    @Override
    public void clickSaveTask() {
        saveTaskButton.click();
    }
}
