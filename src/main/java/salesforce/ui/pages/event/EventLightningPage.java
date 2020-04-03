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
 * Manages EventLightningPage.
 *
 * @author Enrique Carrizales.
 * @version 1.0 02 April 2020.
 */
public class EventLightningPage extends AbstractEventPage {

    @FindBy(xpath = "//span[contains(text(),'Subject')]//..//..//span[@class='uiOutputText']")
    private WebElement subjectLabel;

    @FindBy(xpath = "//span[contains(text(),'Start')]//..//..//div[contains(@class,'slds-form-element__control sld')]"
            + "//span[@class='uiOutputDateTime']")
    private WebElement startDateLabel;

    @FindBy(xpath = "//span[contains(text(),'End')]//..//..//div[contains(@class,'slds-form-element__control sld')]"
            + "//span[@class='uiOutputDateTime']")
    private WebElement endDateLabel;

    @FindBy(xpath = "//div//span[text()='Assigned To']//..//..//span[contains(@class,'test-id__field-va')]//a")
    private WebElement assignedToLinkText;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(assignedToLinkText));
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
        return assignedToLinkText.getText();
    }
}
