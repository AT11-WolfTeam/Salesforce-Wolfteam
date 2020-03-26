/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.lead;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.entities.Lead;
import salesforce.ui.pages.AbstractBasePage;

/**
 * Defines a NewLeadLightningPopup.
 *
 * @author Enrique Carrizales.
 * @version 1.0 24 March 2020.
 */
public class NewLeadLightningPopup extends AbstractBasePage {
    @FindBy(css = "div[class*='slds-form-element slds-f'] span span")
    private WebElement leadOwnerLabel;

    @FindBy(css = "input[class*='firstName']")
    private WebElement firstNameTextBox;

    @FindBy(css = "input[class*='lastName']")
    private WebElement lastNameTextBox;

    @FindBy(xpath = "//span[contains(.,'Last Name')]")
    private WebElement lastNameLabel;

    @FindBy(xpath = "//span[contains(text(),'Company')]/..//..//input[@class=' input']")
    private WebElement companyTextBox;

    @FindBy(css = "button[class*='slds-button slds-button--neutral uiButton--b']")
    private WebElement saveButton;

    @FindBy(css = "button[class*='slds-button slds-button--neutral uiButton--n'][title='Save & New']")
    private WebElement saveAndNewButton;

    private static final String LIST_BOX_PARTIAL_LOCATOR = "//span[contains(text(),'%s')]/..//..//a[@class='select']";
    private Actions actions;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(leadOwnerLabel));
    }

    /**
     * Selects an Item of a ListBox.
     *
     * @param listBoxLabel    contains String value.
     * @param listBoxNameItem contains String value.
     */
    private void selectItemInSelect(final String listBoxLabel, final String listBoxNameItem) {
        String baseOptionToSelectLocator = "//div[@class='select-options']//a[contains(.,'%s')]";

        String listBoxLocator = String.format(LIST_BOX_PARTIAL_LOCATOR, listBoxLabel);
        webDriver.findElement(By.xpath(listBoxLocator)).click();

        String optionToSelectLocator = String.format(baseOptionToSelectLocator, listBoxNameItem);
        webDriver.findElement(By.xpath(optionToSelectLocator)).click();
    }

    /**
     * Sets a tex box.
     *
     * @param firstName contains a String value.
     */
    private void setFirstNameTextBox(final String firstName) {
        firstNameTextBox.sendKeys(firstName);
    }

    /**
     * Sets a tex box.
     *
     * @param lastName contains a String value.
     */
    private void setLastNameTextBox(final String lastName) {
        lastNameTextBox.sendKeys(lastName);
    }

    /**
     * Sets a tex box.
     *
     * @param company contains a String value.
     */
    private void setCompanyTextBox(final String company) {
        companyTextBox.sendKeys(company);
    }

    /**
     * Clicks on a button.
     */
    public void clickOnSaveButton() {
        saveButton.click();
    }

    /**
     * Clicks on a button.
     */
    public void clickOnSaveAndNew() {
        saveAndNewButton.click();
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By
                .cssSelector("div[class*='toastContainer']")));
    }

    /**
     * Loads fields of this page.
     *
     * @param lead contains an instance.
     */
    public void loadNewLeadFields(final Lead lead) {
        webDriverWait.until(ExpectedConditions.visibilityOf(lastNameLabel));
        setLastNameTextBox(lead.getLastName());
        setCompanyTextBox(lead.getCompany());
        selectItemInSelect("Lead Status", lead.getLeadStatus());
    }
}
