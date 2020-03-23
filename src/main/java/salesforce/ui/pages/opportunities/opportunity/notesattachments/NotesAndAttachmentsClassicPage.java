/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunities.opportunity.notesattachments;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Manages notes and attachments on Classic user experience.
 *
 * @author Juan Martinez.
 * @version 1.0 21 March 2020.
 */
public class NotesAndAttachmentsClassicPage extends NotesAndAttachmentsPageAbstract {

    @FindBy(xpath = "//li[@class='slds-button slds-button--neutral slds-truncate']/a/div")
    WebElement uploadFilesButton;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
//        webDriverWait.until(ExpectedConditions.visibilityOf(uploadFilesButton));
    }

    @Override
    public void clickOnUploadFiles() {
        uploadFilesButton.sendKeys("src/test/resources/filestoupload/cucumber.png");
    }

    @Override
    public String getUploadedFileName(String fileName) {
        return null;
    }
}
