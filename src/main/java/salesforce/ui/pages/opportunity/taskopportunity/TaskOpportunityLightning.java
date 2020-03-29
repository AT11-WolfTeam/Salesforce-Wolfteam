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
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.task.AbstractTask;

/**
 * Defines TaskOpportunityLightning.
 *
 * @author Alan Escalera.
 * @version 1.0 24 March 2020.
 */
public class TaskOpportunityLightning extends AbstractTaskOpportunity {
    @FindBy(xpath = "//div[@class='']//div[@class='riseTransitionEnabled']//label[text()='Subject']//following-"
            + "sibling::div//input")
    private WebElement subjectField;

    private static final String TASK_NAME = "//a[@class='subjectLink slds-truncate' and contains(text(),'%s')]";

    @FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//button[@class='slds-button"
            + " slds-button--brand cuf-publisherShareButton MEDIUM uiButton']")
    private WebElement saveTaskButton;

    @FindBy(xpath = "//div[@class='']//div[@class='riseTransitionEnabled']//span[text()='Due Date']/.."
            + "//following-sibling::div//input")
    private WebElement dueDateField;

    @FindBy(xpath = "//input[@class='default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--"
            + "input uiInput uiAutocomplete uiInput--default uiInput--lookup']")
    private WebElement searchContactsField;

    @FindBy(css = "a[class='select']")
    private WebElement statusListBox;

    @FindBy(css = "input[class*=' default input'][placeholder*='Search Users']")
    private WebElement assignedToListBox;

    private WebElement contactSelected;

    private static final String CONTACT_SPECIFIC = "//ul[@class='lookup__list  visible']//div[@title='%s']";
    private static final String ASSIGNED_TO_LIST_BOX_PARTIAL_LOCATOR = "//span[text()='%s']";
    private static final String OPTION_ASSIGNED_TO_LIST_BOX_PARTIAL_LOCATOR = "//a[*[div[text()='%s']]]";
    private static final String OPTION_STATUS_LIST_BOX_PARTIAL_LOCATOR = "//li[contains(.,'%s')]//a";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(subjectField));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(searchContactsField));
    }

    @Override
    protected void setSubjectTask(final String subject) {
        subjectField.sendKeys(subject);
    }

    @Override
    protected void setContact(final String contact) {
        clickOnContactField();
        selectContact(contact);
    }

    /**
     * Selects a contact on the combo box.
     *
     * @param contact value.
     */
    private void selectContact(final String contact) {
        String selectContactXpath = String.format(CONTACT_SPECIFIC, contact);
        contactSelected = webDriver.findElement(By.xpath(selectContactXpath));
        contactSelected.click();
    }

    /**
     * Clicks on contactField.
     */
    private void clickOnContactField() {
        searchContactsField.click();
    }

    @Override
    protected void setDueDate(final String dueDate) {
        dueDateField.sendKeys(dueDate);
    }

    @Override
    protected void setStatus(final String status) {
        String optionStatusListBoxPartialLocator = String.format(OPTION_STATUS_LIST_BOX_PARTIAL_LOCATOR, status);
        statusListBox.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(optionStatusListBoxPartialLocator)))
                .click();
    }

    @Override
    protected void setAssignedTo(final String assignedTo) {
        String assignedToListBoxLocator = String.format(ASSIGNED_TO_LIST_BOX_PARTIAL_LOCATOR, assignedTo);
        try {
            webDriver.findElement(By.xpath(assignedToListBoxLocator));
        } catch (NoSuchElementException elementNotFound) {
            String optionAssignedToListBoxLocator = String.format(OPTION_ASSIGNED_TO_LIST_BOX_PARTIAL_LOCATOR,
                    assignedToListBoxLocator);
            assignedToListBox.click();
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(optionAssignedToListBoxLocator)))
                    .click();
        }
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
