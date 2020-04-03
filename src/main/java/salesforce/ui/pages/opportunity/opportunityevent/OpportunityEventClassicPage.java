/*
 *  Copyright (c) 2019 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunity.opportunityevent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Manages OpportunityEventClassicPage.
 *
 * @author Enrique Carrizales.
 * @version 1.0 02 April 2020.
 */
public class OpportunityEventClassicPage extends AbstractOpportunityEvent {

    @FindBy(xpath = "//input[contains(@id,'evt') and @data-fieldname='subject']")
    private WebElement subjectTextBox;

    @FindBy(css = "input[data-fieldname='startdatetime']")
    private WebElement startDateTextBox;

    @FindBy(css = "input[data-fieldname='enddatetime']")
    private WebElement endDateTextBox;

    @FindBy(css = "input[id='publishersharebutton'][value='Create']")
    private WebElement createButton;

    @FindBy(css = "input[id*='ev'][data-fieldname='ownerid']")
    private WebElement asignedToTextBox;

    private static final String WEB_ELEMENT_ATTRIBUTE = "value";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(createButton));
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
        if (asignedToTextBox.getAttribute(WEB_ELEMENT_ATTRIBUTE).compareTo(assignedTo) != 0) {
            asignedToTextBox.sendKeys(assignedTo);
        }
    }

    @Override
    protected void clickOnSaveButton() {
        createButton.click();
    }
}
