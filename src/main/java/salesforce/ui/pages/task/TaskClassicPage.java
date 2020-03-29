/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import salesforce.utils.UtilSalesforce;

/**
 * Defines a TaskClassicPage.
 *
 * @author Alan Escalera.
 * @version 1.0 23 March 2020.
 */
public class TaskClassicPage extends AbstractTask {
    @FindBy(css = "input[title='Edit']")
    private WebElement editButton;

    @FindBy(css = "select[name='tsk12']")
    private WebElement statusComboBox;

    @FindBy(css = "select[name='tsk13']")
    private WebElement priorityComboBox;

    @FindBy(css = "input[name='tsk5']")
    protected WebElement subjectField;

    @FindBy(css = "input[name='save']")
    private WebElement saveButtonTask;

    @FindBy(xpath = "//td[text()='Priority']/..//div[@id='tsk13_ileinner']")
    private WebElement prioritySelected;

    @FindBy(xpath = "//td[text()='Status']/..//div[@id='tsk12_ileinner']")
    private WebElement statusSelected;

    @FindBy(xpath = "//td[@class='labelCol' and text()='Name']/..//td//div[@id='tsk2_ileinner']")
    private WebElement contactName;

    @FindBy(xpath = "//td[@class='labelCol' and text()='Due Date']/..//td[@id='tsk4_ilecell']")
    private WebElement dueDate;

    @FindBy(xpath = "//input[@id='tsk2']/..//a[@id='whobtn']")
    private WebElement contactLookupButton;

    @FindBy(xpath = "//input[@id='tsk4']")
    private WebElement dueDateField;

    @FindBy(name = "resultsFrame")
    private WebElement resultsFrame;

    private WebElement subjectName;
    private WebElement contactNameSelected;
    private static final String SUBJECT_NAME = "//td[text()='Subject']/..//div[text()='%s']";
    private static final String CONTACT_NAME = "//a[text()='%s']";
    private String parentHandle;
    private Select select;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(editButton));
    }

    @Override
    public void clickEditButton() {
        editButton.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(statusComboBox));
    }

    @Override
    public void setStatus(final String statusToSelect) {
        select = new Select(statusComboBox);
        select.selectByValue(statusToSelect);
    }

    @Override
    public void setPriority(final String priorityToSelect) {
        select = new Select(priorityComboBox);
        select.selectByValue(priorityToSelect);
    }

    @Override
    public void setAssignedTo(String assignedTo) {
        //Todo
    }

    @Override
    public void clickOnSaveTaskButton() {
        saveButtonTask.click();
    }

    @Override
    protected String getPriority() {
        return prioritySelected.getText();
    }

    @Override
    protected String getStatus() {
        return statusSelected.getText();
    }

    @Override
    protected void setSubject(final String subject) {
        subjectField.clear();
        subjectField.sendKeys(subject);
    }

    @Override
    protected String getSubject(final String subject) {
        String subjectXpath = String.format(SUBJECT_NAME, subject);
        subjectName = webDriver.findElement(By.xpath(subjectXpath));
        return subjectName.getText();
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
     * @param contact value.
     */
    private void clickOnContactSelected(final String contact) {
        String campaignNameXpath = String.format(CONTACT_NAME, contact);
        contactNameSelected = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(campaignNameXpath)));
        contactNameSelected.click();
    }

    /**
     * clicks on contactLookupButton.
     */
    private void clickContactLookup() {
        contactLookupButton.click();
    }

    @Override
    protected String getContact() {
        return contactName.getText();
    }

    @Override
    protected void setDueDate(final String dueDate) {
        dueDateField.sendKeys(dueDate);
    }

    @Override
    protected String getDueDate() {
        return dueDate.getText();
    }

    @Override
    protected String getAssignedTo() {
        return null;
    }
}
