/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.contractlist;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Defines ContractListLightningPage.
 *
 * @author Alan Escalera.
 * @version 1.0 29 March 2020.
 */
public class ContractListLightningPage extends AbstractContractListPage {
    @FindBy(css = "table[role='grid']")
    private WebElement contractTable;

    @FindBy(xpath = "//div[@class='branding-actions actionMenu']//a[@title='Delete']")
    private WebElement deleteButton;

    @FindBy(xpath = "//div[@class='modal-container slds-modal__container']//button[@title='Delete']")
    private WebElement deleteConfirmButton;

    private static final String MORE_ACTIONS = "//table//tbody//tr//th//a[@title='%s']/../../..//td"
            + "//div[@class='forceVirtualActionMarker forceVirtualAction']";
    private Actions actions = new Actions(webDriver);

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(contractTable));
    }

    @Override
    public void deleteContract(final String contractNumber) {
        clickOnMoreActions(contractNumber);
        clickOnDeleteButton();
        clickOnDeleteConfirmation();
    }

    /**
     * Clicks on deleteConfirmButton.
     */
    private void clickOnDeleteConfirmation() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(deleteConfirmButton));
        deleteConfirmButton.click();
    }

    /**
     * Clicks on deleteButton.
     */
    private void clickOnDeleteButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        actions.click(deleteButton).build().perform();
    }

    /**
     * Clicks on moreActions button.
     *
     * @param contractNumber value.
     */
    private void clickOnMoreActions(final String contractNumber) {
        webDriver.findElement(By.xpath(String.format(MORE_ACTIONS, contractNumber))).click();
    }

}
