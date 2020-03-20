/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforcetest.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;
import salesforce.api.requestapi.ContactApiHelper;
import salesforce.entities.Context;
import salesforce.entities.Contact;
import salesforce.utils.SheetManager;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Manages contact steps.
 *
 * @author Juan Martinez.
 * @version 1.0 20 March 2020.
 */
public class ContactSteps {

    // Entities
    private Context context;

    private ContactApiHelper contactApiHelper;
    private ArrayList<HashMap<String, String>> contactMapList;

    /**
     * Account steps constructor.
     *
     * @param context object.
     */
    public ContactSteps(final Context context) {
        this.context = context;
        contactApiHelper = new ContactApiHelper();
    }

    /**
     * Allows to create contacts.
     *
     * @param quantity number of accounts.
     * @param accountType value.
     */
    @Given("I create {int} {string} contacts")
    public void createContacts(final int quantity, final String accountType) {
        String sheetName = "Contacts";
        contactMapList = SheetManager.manageSheet(sheetName, quantity, accountType);
        ArrayList<Contact> contacts = contactApiHelper.setContacts(contactMapList);
        context.setContacts(contacts);
        contactApiHelper.postContacts(context.getContacts());
    }

    /**
     * Deletes contacts.
     */
    @When("I delete created contacts")
    public void deleteContacts() {
        contactApiHelper.deleteContacts(context.getContacts());
        final String expected = "204";
        for (Contact contact : context.getContacts()) {
            Assert.assertEquals(contact.getStatusCode(), expected);
        }
    }
}
