/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.notesattachments;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Manages notes and attachments on Classic user experience.
 *
 * @author Juan Martinez.
 * @version 1.0 21 March 2020.
 */
public class NotesAndAttachmentsClassicPage extends NotesAndAttachmentsPageAbstract {

    @FindBy(xpath = "//li[@class='slds-button slds-button--neutral slds-truncate']/a/div")
    private WebElement uploadFilesButton;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(uploadFilesButton));
    }

    @Override
    public void clickOnUploadFiles(final String filePath) {
        uploadFilesButton.sendKeys("src/test/resources/filestoupload/cucumber.png");
    }

    @Override
    public String getUploadedFileName(final String fileName) {
        return null;
    }
}
