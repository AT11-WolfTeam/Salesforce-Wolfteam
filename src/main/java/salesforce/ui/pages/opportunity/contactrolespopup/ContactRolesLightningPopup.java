/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunity.contactrolespopup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.opportunity.AbstractOpportunityPage;
import salesforce.ui.pages.opportunity.opportunitycontactroles.AbstractContactRolesPage;
import salesforce.ui.pages.opportunity.opportunitycontactroles.ContactRolesLightningPage;

import java.util.HashMap;

/**
 * Manages lightning contact roles popup.
 *
 * @author Juan Martinez.
 * @version 1.0 26 March 2020.
 */
public class ContactRolesLightningPopup extends AbstractContactRolesPopup {

    @FindBy(css = "h2[id='modal-title']")
    private WebElement contactRolesPopupTitle;

    @FindBy(css = "input[title='Search Contacts']")
    private WebElement searchContactsTextBox;

    @FindBy(xpath = "//span[text()='Next']")
    private WebElement nextButton;

    @FindBy(css = "button[title='Save']")
    private WebElement saveButton;

    private static final String CONTACT_ITEM = "//div[@title='%s']";
    private static final String ROW_ROLE_CONTACT = "//a[@title='%s']/../../..//td[@data-aura-class="
        +"'forceInlineEditCell']";
    private static final String ROW_ITEM = "//a[@title='%s']";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(contactRolesPopupTitle));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(contactRolesPopupTitle));
    }

    /**
     * Gets composed web element.
     * @param xpath value.
     * @param concatText value.
     * @return web element.
     */
    private WebElement getWebElement(final String xpath, final String concatText) {
        return webDriver.findElement(By.xpath(String.format(xpath, concatText)));
    }

    /**
     * Clicks on contact roles title.
     */
    private void clickOnContactRolesPopupTitle() {
        webDriverWait.until(ExpectedConditions.visibilityOf(contactRolesPopupTitle));
        contactRolesPopupTitle.click();
    }

    /**
     * Clicks on search textbox.
     */
    private void clickOnSearchContactsTextBox() {
        webDriverWait.until(ExpectedConditions.visibilityOf(searchContactsTextBox));
        searchContactsTextBox.click();
    }

    /**
     * Selects a contact.
     * @param contactName value.
     */
    private void selectContact(final String contactName) {
        webDriverWait.until(ExpectedConditions.visibilityOf(contactRolesPopupTitle));
        clickOnContactRolesPopupTitle();
        clickOnSearchContactsTextBox();
        getWebElement(CONTACT_ITEM, contactName).click();
    }

    /**
     * Clicks on next button.
     */
    private void clickOnNextButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(nextButton));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();
    }

    /**
     * Iterates the contacts.
     * @param contacts list.
     */
    private void iterateContacts(final HashMap<String, String> contacts) {
        for (String contactName : contacts.keySet()) {
            selectContact(contactName);
        }
    }

    /**
     * Assigns a rol to contact.
     * @param contactName value.
     * @param rolName value.
     */
    private void assignRolContact(final String contactName, final String rolName) {
        webDriverWait.until(ExpectedConditions.visibilityOf(getWebElement(ROW_ROLE_CONTACT, contactName)));
        getWebElement(ROW_ROLE_CONTACT, contactName).click();
        getWebElement(ROW_ROLE_CONTACT, contactName).click();
        webDriverWait.until(ExpectedConditions.visibilityOf(getWebElement(ROW_ITEM, rolName)));
        getWebElement(ROW_ITEM, rolName).click();
    }

    /**
     * Iterates to assigns roles to contacts.
     * @param contacts list.
     */
    private void assignRolesToContacts(final HashMap<String, String> contacts) {
        for (String contactName : contacts.keySet()) {
            assignRolContact(contactName, contacts.get(contactName));
        }
    }

    /**
     * Clicks on save button.
     */
    private void clickOnSaveButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(saveButton));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButton.click();
    }

    @Override
    public AbstractContactRolesPage selectContacts(final HashMap<String, String> contactsList) {
        iterateContacts(contactsList);
        clickOnNextButton();
        assignRolesToContacts(contactsList);
        clickOnSaveButton();
        return new ContactRolesLightningPage();
    }
}
