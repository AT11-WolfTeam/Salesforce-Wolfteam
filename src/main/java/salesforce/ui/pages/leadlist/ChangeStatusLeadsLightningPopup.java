/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.leadlist;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Manages ChangeStatusLeadsLightningPopup.
 *
 * @author Enrique Carrizales.
 * @version 1.0 29 March 2020.
 */
public class ChangeStatusLeadsLightningPopup extends AbstractChangeStatusLeads {

    @FindBy(css = "a[class='select']")
    private WebElement changeStatusListBox;

    @FindBy(css = "button[class*='slds-button slds-button--neutral button-br']")
    private WebElement saveButton;

    private static final String OPTION_CHANGE_STATUS_LIST_BOX_PARTIAL_LOCATOR = "//a[text()='%s']";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(saveButton));
    }

    @Override
    public void selectStatusLeads(final String statusLeads) {
        clickOnChangeStatusListBox();
        String tabOption = String.format(OPTION_CHANGE_STATUS_LIST_BOX_PARTIAL_LOCATOR, statusLeads);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(tabOption))).click();
        clickOnSaveButton();
    }

    /**
     * Clicks on a button.
     */
    private void clickOnSaveButton() {
        saveButton.click();
    }

    /**
     * Clicks on a listBox.
     */
    private void clickOnChangeStatusListBox() {
        changeStatusListBox.click();
    }
}
