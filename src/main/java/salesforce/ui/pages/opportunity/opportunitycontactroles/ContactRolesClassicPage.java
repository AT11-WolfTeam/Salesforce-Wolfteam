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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import salesforce.ui.pages.opportunity.AbstractOpportunityPage;
import salesforce.ui.pages.opportunity.OpportunityClassicPage;
import salesforce.ui.pages.opportunity.contactrolespopup.AbstractContactRolesPopup;
import java.util.HashMap;

/**
 * Manages classic contact roles of an opportunity.
 *
 * @author Juan Martinez.
 * @version 1.0 26 March 2020.
 */
public class ContactRolesClassicPage extends AbstractContactRolesPage {

    @FindBy(css = "h1[class='noSecondHeader pageType']")
    private WebElement contactRolesTitle;

    @FindBy(xpath = "//td[@id='bottomButtonRow']/input[@name='save']")
    private WebElement saveButton;

    private static final String CONTACT_TEXTBOX = "//input[@id='contact%s']";
    private static final String ROLE_COMBOBOX = "//select[@id='role%s']";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(contactRolesTitle));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(contactRolesTitle));
    }

    @Override
    public AbstractContactRolesPopup addContactRoles() {
        return null;
    }

    @Override
    public HashMap<String, String> verifyContactRoles(final HashMap<String, String> contactRolList) {

        return null;
    }

    /**
     * Gets selector of role combobox.
     *
     * @param xpathCombobox value.
     * @return selector.
     */
    private Select getSelect(final String xpathCombobox) {
        return new Select(webDriver.findElement(By.xpath(xpathCombobox)));
    }

    /**
     * Sets contact name.
     *
     * @param position value.
     * @param contactName value.
     */
    private void setContactTextBox(final int position, final String contactName) {
        webDriverWait.until(ExpectedConditions.visibilityOf(getWebElement(CONTACT_TEXTBOX,
                Integer.toString(position))));
        getWebElement(CONTACT_TEXTBOX, Integer.toString(position)).sendKeys(contactName);
    }

    /**
     * Iterates contacts to set values.
     *
     * @param contactsList values.
     */
    private void contactsIterator(final HashMap<String, String> contactsList) {
        int iterator = 0;
        for (String contactName : contactsList.keySet()) {
            setContactTextBox(iterator, contactName);
            iterator++;
        }
    }

    /**
     * Sets contact name.
     *
     * @param position value.
     * @param roleName value.
     */
    private void setContactRol(final int position, final String roleName) {
        webDriverWait.until(ExpectedConditions.visibilityOf(getWebElement(ROLE_COMBOBOX, Integer.toString(position))));
        getSelect(String.format(ROLE_COMBOBOX, position)).selectByVisibleText(roleName);
    }

    /**
     * Iterates contacts roles to select value.
     *
     * @param contactRolesList values.
     */
    private void rolesIterator(final HashMap<String, String> contactRolesList) {
        int iterator = 0;
        for (String keyName : contactRolesList.keySet()) {
            setContactRol(iterator, contactRolesList.get(keyName));
            iterator++;
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
    public AbstractOpportunityPage setContacts(final HashMap<String, String> contactsList) {
        contactsIterator(contactsList);
        rolesIterator(contactsList);
        clickOnSaveButton();
        clickOnSaveButton();
        return new OpportunityClassicPage();
    }
}
