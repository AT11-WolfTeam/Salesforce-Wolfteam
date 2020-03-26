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
import org.openqa.selenium.support.FindBy;
import java.util.HashMap;

/**
 * Manages campaign members of classic page.
 *
 * @author Juan Martinez.
 * @version 1.0 24 March 2020
 */
public class CampaignMembersClassicPage extends AbstractCampaignMembersPage {

    @FindBy(xpath = "//a[contains(text(), '%s')]")
    private WebElement rowName;

    private static final String ROW_NAME = "//span[contains(text(), '%s')]";

    private HashMap<String, String> contactsList;
    private String firstName;
    private String lastName;
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final String SPACE = " ";

    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Gets web element composed by xpath and name value.
     * @param fullNameValue string.
     * @return composed web element.
     */
    private WebElement getWebElement(final String fullNameValue) {
        return webDriver.findElement(By.xpath(String.format(ROW_NAME, fullNameValue)));
    }

    /**
     * Gets last name text.
     * @param fullNameValue string.
     * @return last name.
     */
    private String getFullNameText(final String fullNameValue) {
        return getWebElement(fullNameValue).getText();
    }

    @Override
    public HashMap<String, String> getContactsText(HashMap<String, String> contacts) {
        contactsList = new HashMap<>();
        String fullName;
        String [] splitName;
        for (String keyValue : contacts.keySet()) {
            fullName = getFullNameText(contacts.get(keyValue) + SPACE + keyValue);
            splitName = fullName.split(SPACE);
            lastName = splitName[ONE];
            firstName = splitName[ZERO];
            contactsList.put(lastName, firstName);
        }
        return contactsList;
    }
}
