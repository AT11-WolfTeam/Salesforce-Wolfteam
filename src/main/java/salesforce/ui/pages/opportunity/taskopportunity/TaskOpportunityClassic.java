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
import org.openqa.selenium.support.ui.Select;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.task.AbstractTask;
import salesforce.utils.UtilSalesforce;

/**
 * Defines TaskOpportunityClassic.
 *
 * @author Alan Escalera.
 * @version 1.0 24 March 2020.
 */
public class TaskOpportunityClassic extends AbstractTaskOpportunity {
    @FindBy(xpath = "//input[@name='tsk5__09D3h0000012ZVJ']")
    private WebElement subjectField;

    @FindBy(css = "input[data-fieldname='ownerid'][id*='tsk']")
    private WebElement assignedToField;

    @FindBy(css = "select[id*='tsk12']")
    private WebElement statusListBox;

    @FindBy(css = "input[name='tsk4__09D3h0000012ZVJ']")
    private WebElement dueDateField;

    @FindBy(xpath = "//div//select[@name='tsk2__09D3h0000012ZVJ_mlktp']/../../../..//div//div//a//"
            + "img[@class='lookupIcon']")
    private WebElement contactLookupIcon;

    @FindBy(name = "resultsFrame")
    private WebElement resultsFrame;

    @FindBy(xpath = "//input[@name='publishersharebutton']")
    private WebElement saveTaskButton;

    private WebElement contactNameSelected;

    private static final String TASK_NAME = "//div[@class='taskInnerContent']//a[text()='%s']";
    private static final String CONTACT_NAME = "//a[text()='%s']";
    private static final String WEB_ELEMENT_ATTRIBUTE = "value";
    private String parentHandle;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(subjectField));
    }

    @Override
    protected void setSubjectTask(final String subject) {
        subjectField.sendKeys(subject);
    }

    @Override
    protected void setContact(final String contact) {
        clickContactLookup();
        assignContact(contact);
    }

    /**
     * Assigns contact.
     *
     * @param contact value.
     */
    private void assignContact(final String contact) {
        parentHandle = webDriver.getWindowHandle();
        try {
            UtilSalesforce.switchToNewWindow(parentHandle);
            webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(resultsFrame));
            clickOnContactSelected(contact);
        } finally {
            webDriver.switchTo().window(parentHandle);
        }
    }

    /**
     * Clicks on contact selected.
     *
     * @param contact value.
     */
    private void clickOnContactSelected(final String contact) {
        String contactNameXpath = String.format(CONTACT_NAME, contact);
        contactNameSelected = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(contactNameXpath)));
        contactNameSelected.click();
    }

    /**
     * Clicks on contact lookup.
     */
    private void clickContactLookup() {
        contactLookupIcon.click();
    }

    @Override
    protected void setDueDate(final String dueDate) {
        dueDateField.sendKeys(dueDate);
    }

    @Override
    protected void setStatus(final String status) {
        Select select = new Select(statusListBox);
        select.selectByVisibleText(status);
    }

    @Override
    protected void setAssignedTo(final String assignedTo) {
        if (assignedToField.getAttribute(WEB_ELEMENT_ATTRIBUTE).compareTo(assignedTo) != 0) {
            assignedToField.sendKeys(assignedTo);
        }
    }

    @Override
    public AbstractTask clickTaskToEdit(final String task) {
        String taskToEditXpath = String.format(TASK_NAME, task);
        taskNameSelected = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(taskToEditXpath)));
        taskNameSelected.click();
        return AppPageFactory.getTaskPage();
    }

    @Override
    public void clickSaveTask() {
        saveTaskButton.click();
    }
}
