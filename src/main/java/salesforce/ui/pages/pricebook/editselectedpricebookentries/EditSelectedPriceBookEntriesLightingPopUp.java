/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.pricebook.editselectedpricebookentries;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Defines EditSelectedPriceBookEntriesLightingPopUp.
 *
 * @author Alan Escalera.
 * @version 1.0 1 April 2020.
 */
public class EditSelectedPriceBookEntriesLightingPopUp extends AbstractEditSelectedPriceBookEntriesPage {
    @FindBy(xpath = "//div[@class='modal-container slds-modal__container']//button[@title='Save']")
    private WebElement saveButton;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(saveButton));
    }

    @Override
    public void clickOnSaveButton() {
        saveButton.click();
    }
}
