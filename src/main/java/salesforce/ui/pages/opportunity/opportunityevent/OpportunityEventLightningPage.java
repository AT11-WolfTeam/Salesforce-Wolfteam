/*
 *  Copyright (c) 2019 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunity.opportunityevent;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Manages OpportunityEventLightningPage.
 *
 * @author Enrique Carrizales.
 * @version 1.0 02 April 2020.
 */
public class OpportunityEventLightningPage extends AbstractOpportunityEvent {

    @FindBy(xpath = "//label[contains(text(), 'Subject')]//..//input")
    private WebElement subjectTextBox;

    @FindBy(xpath = "//legend[contains(text(),'Start')]//..//input[@class='slds-input']")
    private WebElement startDateTextBox;

    @FindBy(xpath = "//legend[contains(text(),'End')]//..//input[@class='slds-input']")
    private WebElement endDateTextBox;

    @FindBy(css = "input[class*=' default input'][placeholder*='Search Users']")
    private WebElement assignedToListBox;

    @FindBy(xpath = "//label[span[contains(text(), 'Location')]]//..//input")
    private WebElement locationTextBox;

    @FindBy(xpath = "//div[contains(@class,'testid__publisher-quick-action-collapser for')]//button[contains"
            + "(@class,'slds-button slds-button--brand cuf')]")
    private WebElement saveButton;

    private static final String ASSIGNED_TO_LIST_BOX_PARTIAL_LOCATOR = "//span[text()='%s']";
    private static final String OPTION_ASSIGNED_TO_LIST_BOX_PARTIAL_LOCATOR = "//a[*[div[text()='%s']]]";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(locationTextBox));
    }

    @Override
    protected void setSubject(final String subject) {
        subjectTextBox.sendKeys(subject);
    }

    @Override
    protected void setStartDate(final String startDate) {
        startDateTextBox.clear();
        startDateTextBox.sendKeys(startDate);
    }

    @Override
    protected void setEndDate(final String endDate) {
        endDateTextBox.clear();
        endDateTextBox.sendKeys(endDate);
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
    protected void clickOnSaveButton() {
        saveButton.click();
    }
}
