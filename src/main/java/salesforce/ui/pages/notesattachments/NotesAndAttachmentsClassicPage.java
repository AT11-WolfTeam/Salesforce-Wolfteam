/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.notesattachments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.File;

/**
 * Manages notes and attachments on Classic user experience.
 *
 * @author Juan Martinez.
 * @version 1.0 21 March 2020.
 */
public class NotesAndAttachmentsClassicPage extends NotesAndAttachmentsPageAbstract {
    @FindBy(css = "input[id='file']")
    private WebElement chooseFileLabel;

    @FindBy(css = "input[id='Attach']")
    private WebElement attachFileButton;

    @FindBy(css = "input[value=' Done ']")
    private WebElement doneButton;

    private static final String FILE_NAME_PATH = "//a[starts-with(text(), '%s')]";
    private static final int END = 4;
    private static final int INIT = 0;

    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Sets file path value.
     * @param fileAbsolutePath value.
     */
    private void setFilePath(final String fileAbsolutePath) {
        webDriverWait.until(ExpectedConditions.visibilityOf(chooseFileLabel));
        chooseFileLabel.sendKeys(fileAbsolutePath);
    }

    /**
     * Clicks on attach file button.
     */
    private void clickOnAttachFileButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(attachFileButton));
        attachFileButton.click();
    }

    /**
     * Clicks on done button.
     */
    private void clickOnDoneButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(doneButton));
        doneButton.click();
    }

    @Override
    public void clickOnUploadFiles(final String filePath) {
        File file = new File(filePath);
        String fileAbsolutePath = file.getAbsolutePath();
        setFilePath(fileAbsolutePath);
        clickOnAttachFileButton();
        clickOnDoneButton();
    }

    /**
     * Gets web element composed.
     *
     * @param xPath value.
     * @param concatText value.
     * @return a web element.
     */
    private WebElement getWebElement(final String xPath, final String concatText) {
        return webDriver.findElement(By.xpath(String.format(xPath, concatText)));
    }

    /**
     * Gets uploaded file name.
     * @param fileName string.
     * @return file name value.
     */
    private String getFileNameText(final String fileName) {
        return getWebElement(FILE_NAME_PATH, fileName).getText();
    }

    @Override
    public String getUploadedFileName(final String fileName) {
        String file = getFileNameText(fileName);
        return file.substring(INIT, file.length() - END);
    }
}
