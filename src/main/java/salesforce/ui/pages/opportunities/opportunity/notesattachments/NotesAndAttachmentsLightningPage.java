/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunities.opportunity.notesattachments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.opportunities.opportunity.notesattachments.uploadfiles.UploadFilesPopUp;
import salesforce.utils.UploadFileRobot;

import java.io.File;

/**
 * Manages notes and attachments on Lightning user experience.
 *
 * @author Juan Martinez.
 * @version 1.0 21 March 2020.
 */
public class NotesAndAttachmentsLightningPage extends NotesAndAttachmentsPageAbstract {
    private static final String UPLOADED_FILE_NAME = "//span[text()='%s']";

    @FindBy(xpath = "//h1[@class='slds-page-header__title listViewTitle slds-truncate']")
    private WebElement notesAndAttachmentsTitle;

    @FindBy(xpath = "//a[@title='Upload Files']")
    private WebElement uploadFilesButton;

    private WebElement getWebElement(final String xpathValue, final String textToConcat) {
        return webDriver.findElement(By.xpath(String.format(xpathValue, textToConcat)));
    }

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(notesAndAttachmentsTitle));
    }

    private void clickOnUploadFilesButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(uploadFilesButton));
        uploadFilesButton.click();
    }

    private void closeUploadFilesPopUp() {
        UploadFilesPopUp uploadFilesPopUp = new UploadFilesPopUp();
        uploadFilesPopUp.clickOnDoneButton();
    }

    @Override
    public void clickOnUploadFiles() {
        File file = new File("src/test/resources/filestoupload/cucumber.png");
        String filePath = file.getAbsolutePath();
        clickOnUploadFilesButton();
        UploadFileRobot.uploadFile(filePath);
        closeUploadFilesPopUp();
    }

    private String getFileNameText(final String fileName) {
        return getWebElement(UPLOADED_FILE_NAME, fileName).getText(); //it is not working
    }

    @Override
    public String getUploadedFileName(final String fileName) {
        return getFileNameText(fileName);
    }
}
