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

public class TaskOpportunityLightning extends AbstractTaskOpportunity {
    @FindBy(xpath = "//div[@class='riseTransitionEnabled']//label[text()='Subject']//following-sibling::div//input")
    private WebElement subjectField;

    private static final String TASK_NAME = "//a[@class='subjectLink slds-truncate' and contains(text(),'%s')]";



    @FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//button[@class='slds-button"
            + " slds-button--brand cuf-publisherShareButton MEDIUM uiButton']")
    private WebElement saveTaskButton;

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
        String taskToEditCss = String.format(TASK_NAME, task);
        taskNameSelected = webDriver.findElement(By.xpath(taskToEditCss));
        taskNameSelected.click();
        return AppPageFactory.getTaskPage();
    }

    @Override
    public void clickSaveTask() {
        saveTaskButton.click();
    }

}
