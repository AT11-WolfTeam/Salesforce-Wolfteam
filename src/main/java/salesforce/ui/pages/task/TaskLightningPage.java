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

    @FindBy(xpath = "//span[text()='In Progress']")
    protected WebElement priority;

    @FindBy(xpath = "//span[text()='High']")
    protected WebElement status;

    private static final String FIELD_COMBO_BOX = "//a[@title='%s']";



    Actions actions;

    public TaskLightningPage () {
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
    public void selectStatus(final String statusSelect) {
        clickOnStatusField();
        clickOnStatusToSelect(statusSelect);
    }

    @Override
    public void selectPriority(String priorityToSelect) {
        clickOnPriorityField();
        clickOnPriorityToSelect(priorityToSelect);
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

    /**
     * Clicks on status to select.
     * @param statusSelect string value.
     */
    private void clickOnStatusToSelect(final String statusSelect) {
        String statusXpath = String.format(FIELD_COMBO_BOX, statusSelect);
        statusSelected = webDriver.findElement(By.cssSelector(statusXpath));
        actions.moveToElement(statusSelected).click().build().perform();
    }

    /**
     * Click on priority field.
     */
    private void clickOnPriorityField () {
        priorityField.click();
    }

    /**
     * Clicks on priority to select.
     * @param statusSelect string value.
     */
    private void clickOnPriorityToSelect(final String statusSelect) {
        String priorityXpath = String.format(FIELD_COMBO_BOX, statusSelect);
        prioritySelected = webDriver.findElement(By.cssSelector(priorityXpath));
        actions.moveToElement(prioritySelected).click().build().perform();
    }
}