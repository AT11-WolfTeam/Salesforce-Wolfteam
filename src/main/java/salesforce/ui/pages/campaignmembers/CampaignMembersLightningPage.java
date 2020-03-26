/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.campaignmembers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.HashMap;

/**
 * Manages campaign members of lightning page.
 *
 * @author Juan Martinez.
 * @version 1.0 24 March 2020
 */
public class CampaignMembersLightningPage extends AbstractCampaignMembersPage {
    private static final String ROW_NAME = "//a[contains(text(), '%s')]";
    private HashMap<String, String> contactsList;
    private String firstName;
    private String lastName;

    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Gets web element composed by xpath and name value.
     * @param nameValue string.
     * @return composed web element.
     */
    private WebElement getWebElement(final String nameValue) {
        return webDriver.findElement(By.xpath(String.format(ROW_NAME, nameValue)));
    }

    /**
     * Gets first name text.
     * @param nameValue string.
     * @return first name.
     */
    private String getFirstNameText(final String nameValue) {
        return getWebElement(nameValue).getText();
    }

    /**
     * Gets last name text.
     * @param lastNameValue string.
     * @return last name.
     */
    private String getLastNameText(final String lastNameValue) {
        return getWebElement(lastNameValue).getText();
    }

    @Override
    public HashMap<String, String> getContactsText(final HashMap<String, String> contacts) {
        contactsList = new HashMap<>();
        for (String keyValue : contacts.keySet()) {
            lastName = getFirstNameText(keyValue);
            firstName = getLastNameText(contacts.get(keyValue));
            contactsList.put(lastName, firstName);
        }
        return contactsList;
    }
}
