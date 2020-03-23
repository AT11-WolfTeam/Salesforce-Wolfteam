/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.notesattachments.uploadfiles;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.BasePage;

/**
 * Allows to show upload files popup.
 *
 * @author Juan Martinez.
 * @version 1.0 23 March 2020.
 */
public class UploadFilesPopUp extends BasePage {

    @FindBy(xpath = "//h2[@class='title slds-text-heading--medium slds-hyphenate']")
    private WebElement popupTitle;

    @FindBy(xpath = "//span[@class=' label bBody' and text()='Done']")
    private WebElement doneButton;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(popupTitle));
    }

    /**
     * Clicks on Done button.
     */
    private void clickOnDonePopUpButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(doneButton));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", doneButton);
    }

    /**
     * Allows to close uploaded files popup.
     */
    public void clickOnDoneButton() {
        clickOnDonePopUpButton();
    }
}
