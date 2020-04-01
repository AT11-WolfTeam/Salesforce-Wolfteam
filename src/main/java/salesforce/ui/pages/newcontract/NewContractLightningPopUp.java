/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.newcontract;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.contract.AbstractContractPage;

/**
 * Defines NewContractLightningPopUp.
 *
 * @author Alan Escalera.
 * @version 1.0 28 March 2020.
 */
public class NewContractLightningPopUp extends AbstractNewContractPage {
    private static final String WINDOW_ACTIVE_LOCATOR = "//div[@class='windowViewMode-normal oneRecordActionWrapper"
            + " isModal active lafPageHost']";

    @FindBy(xpath = WINDOW_ACTIVE_LOCATOR + "//input[@title='Search Accounts']")
    private WebElement searchAccountsField;

    @FindBy(xpath = WINDOW_ACTIVE_LOCATOR + "//span[text()='Status']/../..//div[@class='uiMenu']")
    private WebElement statusComboBox;

    @FindBy(xpath = WINDOW_ACTIVE_LOCATOR + "//span[text()='Contract Start Date']/../..//input")
    private WebElement contractStartDateField;

    @FindBy(xpath = WINDOW_ACTIVE_LOCATOR + "//span[text()='Contract Term (months)']/../..//input")
    private WebElement contractTermField;

    @FindBy(xpath = WINDOW_ACTIVE_LOCATOR + "//button[@class='slds-button slds-button--neutral uiButton--brand"
            + " uiButton forceActionButton']")
    private WebElement saveContractButton;

    private WebElement statusSelected;
    private static final String ACCOUNT_NAME = WINDOW_ACTIVE_LOCATOR + "//div[text()='%s']";
    private static final String STATUS_TO_SELECT = "//div[@class='select-options']//a[@title='%s']";

    private Actions actions = new Actions(webDriver);

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(searchAccountsField));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(searchAccountsField));
    }

    @Override
    protected void setAccount(final String accountName) {
        clickOnAccountField();
        selectAccount(accountName);
    }

    /**
     * Selects account.
     *
     * @param accountName value.
     */
    private void selectAccount(final String accountName) {
        webDriver.findElement(By.xpath(String.format(ACCOUNT_NAME, accountName))).click();
    }

    /**
     * Clicks con accountField.
     */
    private void clickOnAccountField() {
        searchAccountsField.click();
    }

    @Override
    protected void setStatus(final String status) {
        clickStatusComboBox();
        selectStatus(status);
    }

    /**
     * Selects Status.
     *
     * @param status value.
     */
    private void selectStatus(final String status) {
        statusSelected = webDriver.findElement(By.xpath(String.format(STATUS_TO_SELECT, status)));
        actions.click(statusSelected).build().perform();
    }

    /**
     * Clicks on Status ComboBox.
     */
    private void clickStatusComboBox() {
        statusComboBox.click();
    }

    @Override
    protected void setContractStartDate(final String startDate) {
        contractStartDateField.sendKeys(startDate);
    }

    @Override
    protected void setContractTerm(final String contractTerm) {
        contractTermField.sendKeys(contractTerm);
    }

    @Override
    public AbstractContractPage clickSaveContract() {
        saveContractButton.click();
        return AppPageFactory.getContractPage();
    }
}
