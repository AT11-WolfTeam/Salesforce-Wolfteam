/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.campaigncontact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Manages campaign contacts in classic user experience.
 *
 * @author Juan Martinez.
 * @version 1.0 25 March 2020.
 */
public class CampaignContactClassicPage extends AbstractCampaignContactPage {

    @FindBy(css = "input[id='filterTypec']")
    private WebElement contactsRadioButton;

    @FindBy(css = "select[id='c_fcf']")
    private WebElement viewCombobox;

    @FindBy(css = "span[id='addLabel']")
    private WebElement addStatus;

    @FindBy(xpath = "//a[contains(text(),'Sent')]")
    private WebElement sentItem;

    @FindBy(xpath = "//a[starts-with(text(),'Back to Campaign:')]")
    private WebElement backToCampaignLink;

    private static final String VIEW_COMBOBOX = "//select[@id='c_fcf']";
    private static final String CONTACT_NAME = "//span[contains(text(),'%s')]/../../../..//input[@class='checkbox']";
    private ArrayList<String> contactsNames;
    private static final String MY_CONTACTS = "My Contacts";

    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Clicks on contacts radio button.
     */
    private void clickOnContactsRadioButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(contactsRadioButton));
        contactsRadioButton.click();
    }

    /**
     * Clicks on view combobox.
     */
    private void clickOnViewCombobox() {
        webDriverWait.until(ExpectedConditions.visibilityOf(viewCombobox));
        viewCombobox.click();
    }

    /**
     * Gets combobox selector.
     *
     * @param xpathLocator value.
     * @return selector composed.
     */
    private Select getSelect(final String xpathLocator) {
        return new Select(webDriver.findElement(By.xpath(xpathLocator)));
    }

    /**
     * Selects item in combobox.
     *
     * @param xpathCombobox value.
     * @param viewName      value.
     */
    private void selectComboBox(final String xpathCombobox, final String viewName) {
        getSelect(xpathCombobox).selectByVisibleText(viewName);
    }

    /**
     * Gets web element.
     *
     * @param contactName value.
     * @return web element.
     */
    private WebElement getWebElement(final String contactName) {
        return webDriver.findElement(By.xpath(String.format(CONTACT_NAME, contactName)));
    }

    /**
     * Checks contact.
     *
     * @param contactName value.
     */
    private void checkContact(final String contactName) {
        webDriverWait.until(ExpectedConditions.visibilityOf(getWebElement(contactName)));
        if (!getWebElement(contactName).isSelected()) {
            getWebElement(contactName).click();
        }
    }

    /**
     * Allows to iterate the contacts names to check them.
     *
     * @param contactsNames list.
     */
    private void iterateContacts(final ArrayList<String> contactsNames) {
        for (String contactName : contactsNames) {
            checkContact(contactName);
        }
    }

    /**
     * Generates a list of contacts.
     *
     * @param namesContacts list.
     * @return contacts names list.
     */
    private ArrayList<String> generateContacts(final HashMap<String, String> namesContacts) {
        contactsNames = new ArrayList<>();
        for (String keyValue : namesContacts.keySet()) {
            contactsNames.add(keyValue + ", " + namesContacts.get(keyValue));
        }
        return contactsNames;
    }

    /**
     * Clicks on add status.
     */
    private void clickOnAddStatus() {
        webDriverWait.until(ExpectedConditions.visibilityOf(addStatus));
        addStatus.click();
    }

    /**
     * Clicks on sent item.
     */
    private void clicksOnSentItem() {
        webDriverWait.until(ExpectedConditions.visibilityOf(sentItem));
        sentItem.click();
    }

    @Override
    public void checkContacts(final HashMap<String, String> namesOfContacts) {
        contactsNames = new ArrayList<>();
        clickOnContactsRadioButton();
        clickOnViewCombobox();
        selectComboBox(VIEW_COMBOBOX, MY_CONTACTS);
        contactsNames = generateContacts(namesOfContacts);
        iterateContacts(contactsNames);
        clickOnAddStatus();
        clicksOnSentItem();
    }
}
