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
import java.util.HashMap;

/**
 * Manages campaign contacts in lightning user experience.
 *
 * @author Juan Martinez.
 * @version 1.0 25 March 2020.
 */
public class CampaignContactPopupLightningPage extends AbstractCampaignContactPage {
    @FindBy(xpath = "//h2[starts-with(@id, 'title_')]")
    private WebElement addContactsPopupTitle;

    @FindBy(xpath = "//button/span[text()='Next']")
    private WebElement nextButton;

    @FindBy(xpath = "//button/span[text()='Submit']")
    private WebElement submitButton;

    private static final String CONTACT_LINK_NAME = "//a[text()='%s']/../../../td//label";

    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Clicks on add contacts popup.
     */
    private void clickOnAddContactsPopupTitle() {
        webDriverWait.until(ExpectedConditions.visibilityOf(addContactsPopupTitle));
        addContactsPopupTitle.click();
    }

    /**
     * Gets web element.
     * @param contactName value.
     * @return web element.
     */
    private WebElement getWebElement(final String contactName) {
        return webDriver.findElement(By.xpath(String.format(CONTACT_LINK_NAME, contactName)));
    }

    /**
     * Checks contact.
     * @param contactName value.
     */
    private void checkContact(final String contactName) {
        webDriverWait.until(ExpectedConditions.visibilityOf(getWebElement(contactName)));
        if (!getWebElement(contactName).isSelected()) {
            getWebElement(contactName).click();
        }
    }

    /**
     * Clicks on popup title.
     */
    private void clickOnContactsPopup() {
        webDriverWait.until(ExpectedConditions.visibilityOf(addContactsPopupTitle));
        addContactsPopupTitle.click();
    }

    /**
     * Allows to iterate the contacts names to check them.
     * @param contactsNames list.
     */
    private void iterateContacts(final HashMap<String, String> contactsNames) {
        clickOnContactsPopup();
        String fullName;
        for (String contactKey : contactsNames.keySet()) {
            fullName = contactsNames.get(contactKey) + " " + contactKey;
            checkContact(fullName);
        }
    }

    /**
     * Clicks on next button.
     */
    private void clickOnNextButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(nextButton));
        nextButton.click();
    }

    /**
     * Clicks on submit button.
     */
    private void clickOnSubmitButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(submitButton));
        submitButton.click();
    }

    @Override
    public void checkContacts(final HashMap<String, String> namesOfContacts) {
        clickOnAddContactsPopupTitle();
        iterateContacts(namesOfContacts);
        clickOnNextButton();
        clickOnSubmitButton();
    }
}
