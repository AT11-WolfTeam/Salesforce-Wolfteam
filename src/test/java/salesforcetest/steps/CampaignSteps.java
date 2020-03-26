/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforcetest.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import salesforce.entities.Contact;
import salesforce.entities.Context;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.campaign.AbstractCampaignPage;
import salesforce.ui.pages.campaigncontact.AbstractCampaignContactPage;
import salesforce.ui.pages.campaignmembers.AbstractCampaignMembersPage;
import salesforce.ui.pages.newcampaign.AbstractNewCampaignPage;
import java.util.HashMap;
import java.util.List;

/**
 * Manages campaigns steps.
 *
 * @author Juan Martinez.
 * @version 1.0 24 March 2020.
 */
public class CampaignSteps {
    private Context context;
    private List<Contact> contacts;
    private HashMap<String, String> contactsNames = new HashMap<>();
    private final static String SPACE = " ";
    private HashMap<String, String> contactList;

    private AbstractCampaignPage abstractCampaignPage;
    private AbstractNewCampaignPage newCampaignPage;
    private AbstractCampaignMembersPage campaignMembersPage;
    private AbstractCampaignContactPage campaignContact;

    /**
     * Constructor of campaigns steps.
     * @param context instance.
     */
    public CampaignSteps(final Context context) {
        this.context = context;
        contacts = context.getContacts();
    }

    /**
     * Selects a campaign by name.
     * @param campaignName value.
     */
    @And("I select {string} campaign")
    public void selectCampaign(final String campaignName) {
        AppPageFactory.getCampaignsPage().selectCampaignName(campaignName);
    }

    /**
     * Allows to add contacts to campaigns.
     */
    @And("I add the contacts the campaign")
    public void addContactsTheCampaign() {
        abstractCampaignPage = AppPageFactory.getCampaignPage();
        for (Contact contact: contacts) {
            contactsNames.put(contact.getLastName(), contact.getFirstName());
        }
        campaignContact = abstractCampaignPage.addCampaignMembers();
        campaignContact.checkContacts(contactsNames);
    }

    /**
     * Allows to add verify added contacts.
     */
    @Then("The added contacts should be displayed on Campaign Members page")
    public void verifyContacts() {
        campaignMembersPage = abstractCampaignPage.viewMembers();
        contactList = new HashMap<>();
        for (Contact contact : contacts) {
            contactList.put(contact.getLastName(), contact.getFirstName());
        }
        HashMap<String, String> actual = campaignMembersPage.getContactsText(contactList);
        Assert.assertEquals(actual, contactList, "message: " + actual + SPACE + contactList);
    }

    /**
     * Selects the campaign.
     */
    @And("I select the campaign")
    public void selectTheCampaign() {
        AppPageFactory.getCampaignsPage().selectCampaignName(context.getNewCampaign().getCampaignName());
    }
}
