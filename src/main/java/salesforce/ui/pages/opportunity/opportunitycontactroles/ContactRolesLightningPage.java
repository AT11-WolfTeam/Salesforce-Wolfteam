/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunity.opportunitycontactroles;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.opportunity.AbstractOpportunityPage;
import salesforce.ui.pages.opportunity.contactrolespopup.AbstractContactRolesPopup;
import salesforce.ui.pages.opportunity.contactrolespopup.ContactRolesLightningPopup;

import java.util.HashMap;

/**
 * Manages lightning contact roles of an opportunity.
 *
 * @author Juan Martinez.
 * @version 1.0 26 March 2020.
 */
public class ContactRolesLightningPage extends AbstractContactRolesPage {

    @FindBy(css = "h1[class='slds-page-header__title listViewTitle slds-truncate']")
    private WebElement contactRolesTitle;

    @FindBy(xpath = "//div[@class='slds-truncate' and @title='Add Contact Roles']")
    private WebElement addContactsRolesButton;

    private static final String CONTACT_NAME = "//a[@title='%s']";
    private static final String CONTACT_ROLE = "//a[@title='%s']/../../..//td//span[contains(text(), '%s')]";

    private HashMap<String, String> contactValues;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(contactRolesTitle));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(contactRolesTitle));
    }

    /**
     * Clicks on add contact roles button.
     */
    private void clickOnAddContactRoles() {
        webDriverWait.until(ExpectedConditions.visibilityOf(addContactsRolesButton));
        addContactsRolesButton.click();
    }

    @Override
    public AbstractContactRolesPopup addContactRoles() {
        clickOnAddContactRoles();
        return new ContactRolesLightningPopup();
    }

    /**
     * Gets composed web element.
     *
     * @param xpath value.
     * @param concatText value.
     * @return web element.
     */
    private WebElement getWebElement(final String xpath, final String concatText) {
        return webDriver.findElement(By.xpath(String.format(xpath, concatText)));
    }

    /**
     * Gets composed web element.
     *
     * @param xpath value.
     * @param contactName value.
     * @param rolName value.
     * @return web element.
     */
    private WebElement getWebElementRol(final String xpath, final String contactName, final String rolName) {
        return webDriver.findElement(By.xpath(String.format(xpath, contactName, rolName)));
    }

    /**
     * Gets contact name.
     *
     * @param contactName value.
     * @return contact name.
     */
    private String getContactName(final String contactName) {
        webDriverWait.until(ExpectedConditions.visibilityOf(getWebElement(CONTACT_NAME, contactName)));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(getWebElement(CONTACT_NAME, contactName)));
        return getWebElement(CONTACT_NAME, contactName).getText();
    }

    /**
     * Gets contact rol name.
     *
     * @param contactName value.
     * @param rolName value.
     * @return contact name.
     */
    private String getContactRole(final String contactName, final String rolName) {
        webDriverWait.until(ExpectedConditions.visibilityOf(getWebElementRol(CONTACT_ROLE, contactName, rolName)));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(getWebElementRol(
                CONTACT_ROLE, contactName, rolName)));
        return getWebElementRol(CONTACT_ROLE, contactName, rolName).getText();
    }

    /**
     * Iterates the contacts.
     *
     * @param contacts value.
     * @return contact values.
     */
    public HashMap<String, String> iterateContacts(final HashMap<String, String> contacts) {
        contactValues = new HashMap<>();
        String name;
        String rol;
        for (String contactName : contacts.keySet()) {
            name = getContactName(contactName);
            rol = getContactRole(contactName, contacts.get(contactName));
            contactValues.put(name, rol);
        }
        return contactValues;
    }

    @Override
    public HashMap<String, String> verifyContactRoles(final HashMap<String, String> contactRolList) {
        HashMap<String, String> contactValues;
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(contactRolesTitle));
            webDriverWait.until(ExpectedConditions.elementToBeClickable(contactRolesTitle));
            contactValues = iterateContacts(contactRolList);
        } catch (StaleElementReferenceException elementHasDisappeared) {
            webDriverWait.until(ExpectedConditions.visibilityOf(contactRolesTitle));
            webDriverWait.until(ExpectedConditions.elementToBeClickable(contactRolesTitle));
            contactValues = this.iterateContacts(contactRolList);
        }
        return contactValues;
    }

    @Override
    public AbstractOpportunityPage setContacts(final HashMap<String, String> contactsList) {
        return null;
    }
}
