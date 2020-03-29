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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Defines an TaskLightningPage.
 *
 * @author Alan Escalera.
 * @version 1.0 23 March 2020.
 */
public class TaskLightningPage extends AbstractTask {
    @FindBy(xpath = "//button[@title='Edit Name']")
    private WebElement editButton;

    @FindBy(xpath = "//div[@class='active']//span[text()='Status']/../..//a")
    private WebElement statusField;

    @FindBy(xpath = "//div[@class='active']//span[text()='Priority']/../..//a")
    private WebElement priorityField;

    @FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//button[@title='Save']")
    private WebElement saveButtonTask;

    @FindBy(xpath = "//div//span[text()='Status']//..//..//span[contains(@class,'test-id__field-va')]//span")
    private WebElement status;

    @FindBy(xpath = "//span[text()='High']")
    private WebElement priority;

    @FindBy(xpath = "//span[text()='Name']/../..//div//a[@data-refid='recordId']")
    private WebElement contactName;

    @FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//span[@class='uiOutputDate']")
    private WebElement dueDate;

    @FindBy(xpath = "//div[@class='active']//label[text()='Subject']/../..//input")
    private WebElement subjectField;

    @FindBy(xpath = "//input[@class='inputDate input']")
    private WebElement dueDateField;

    @FindBy(xpath = "//label//span[text()='Name']/../..//div//div[@class='autocompleteWrapper slds-grow']")
    private WebElement contactsField;

    @FindBy(xpath = "//div//span[text()='Assigned To']//..//..//span[contains(@class,'test-id__field-va')]//a")
    private WebElement assignedToLinkText;

    private WebElement contactSelected;

    private static final String FIELD_COMBO_BOX = "//a[@title='%s']";
    private static final String SUBJECT_TITLE = "//div[@class='slds-page-header__title slds-m-right--small slds-"
            + "align-middle fade-text']//span[text()='%s']";
    private static final String CONTACT_COMBO_BOX = "//a[@role='option']//div[@title='%s']";
    private Actions actions;
    private JavascriptExecutor js = (JavascriptExecutor) webDriver;
    private static final String SCROLL_DOWN = "window.scrollBy(0,300)";
    private static final String SCROLL_UP = "window.scrollBy(0,300)";

    /**
     * Constructor TaskLightningPage.
     */
    public TaskLightningPage() {
        actions = new Actions(webDriver);
    }

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(editButton));
    }

    @Override
    public void clickEditButton() {
        editButton.click();
    }

    /**
     * Clicks on status field.
     */
    private void clickOnStatusField() {
        statusField.click();
    }

    @Override
    public void setStatus(final String statusSelect) {
        clickOnStatusField();
        clickOnStatusToSelect(statusSelect);
    }

    @Override
    public void setPriority(final String priorityToSelect) {
        js.executeScript(SCROLL_DOWN);
        clickOnPriorityField();
        clickOnPriorityToSelect(priorityToSelect);
    }

    @Override
    public void setAssignedTo(final String assignedTo) {
        //Todo
    }

    @Override
    public void clickOnSaveTaskButton() {
        saveButtonTask.click();
    }

    @Override
    protected String getPriority() {
        return priority.getText();
    }

    @Override
    protected String getStatus() {
        return status.getText();
    }

    @Override
    protected void setSubject(final String subject) {
        deleteField(subjectField.getAttribute("value"), subjectField);
        subjectField.sendKeys(subject);
    }

    /**
     * Deletes the field of the element.
     *
     * @param text of the field.
     * @param subjectField element.
     */
    private void deleteField(final String text, final WebElement subjectField) {
        int numberCharacters = text.length();
        while (numberCharacters > 0) {
            subjectField.sendKeys(Keys.BACK_SPACE);
            numberCharacters--;
        }
    }

    @Override
    protected String getSubject(final String subject) {
        js.executeScript(SCROLL_UP);
        String statusXpath = String.format(SUBJECT_TITLE, subject);
        subjectTitle = webDriver.findElement(By.xpath(statusXpath));
        return subjectTitle.getText();
    }

    @Override
    protected void setContact(final String contact) {
        contactsField.click();
        selectContact(contact);
    }

    /**
     * Selects the contact.
     *
     * @param contact value.
     */
    private void selectContact(final String contact) {
        String statusXpath = String.format(CONTACT_COMBO_BOX, contact);
        contactSelected = webDriver.findElement(By.xpath(statusXpath));
        actions.moveToElement(contactSelected).click().build().perform();
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
        return assignedToLinkText.getText();
    }

    /**
     * Clicks on status to select.
     *
     * @param statusSelect string value.
     */
    private void clickOnStatusToSelect(final String statusSelect) {
        String statusXpath = String.format(FIELD_COMBO_BOX, statusSelect);
        statusSelected = webDriver.findElement(By.xpath(statusXpath));
        actions.moveToElement(statusSelected).click().build().perform();
    }

    /**
     * Click on priority field.
     */
    private void clickOnPriorityField() {
        priorityField.click();
    }

    /**
     * Clicks on priority to select.
     *
     * @param statusSelect string value.
     */
    private void clickOnPriorityToSelect(final String statusSelect) {
        String priorityXpath = String.format(FIELD_COMBO_BOX, statusSelect);
        prioritySelected = webDriver.findElement(By.xpath(priorityXpath));
        actions.moveToElement(prioritySelected).click().build().perform();
    }
}
