/*
 *  Copyright (c) 2019 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.event;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.utils.DateFormatter;

/**
 * Manages EventClassicPage.
 *
 * @author Enrique Carrizales.
 * @version 1.0 02 April 2020.
 */
public class EventClassicPage extends AbstractEventPage {

    @FindBy(xpath = "//td[contains(text(),'Subject')]//..//div[contains(@id,'ev')]")
    private WebElement subjectLabel;

    @FindBy(xpath = "//td[contains(text(),'Start')]//..//div[contains(@id,'StartDate')]")
    private WebElement startDateLabel;

    @FindBy(xpath = "//td[contains(text(),'End')]//..//div[contains(@id,'EndDate')]")
    private WebElement endDateLabel;

    @FindBy(xpath = "//td[contains(text(),'Assigned To')]//..//a[@id]")
    private WebElement assignedToLabel;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(assignedToLabel));
    }

    @Override
    protected String getSubject() {
        return subjectLabel.getText();
    }

    @Override
    protected String getStartDate() {
        return DateFormatter.formatQuitTimeFormatSalesforce(startDateLabel.getText());
    }

    @Override
    protected String getEndDate() {
        return DateFormatter.formatQuitTimeFormatSalesforce(endDateLabel.getText());
    }

    @Override
    protected String getAssignedTo() {
        return assignedToLabel.getText();
    }
}
