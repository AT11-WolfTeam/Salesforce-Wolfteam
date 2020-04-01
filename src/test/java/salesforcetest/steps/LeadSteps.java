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
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import salesforce.entities.Context;
import salesforce.entities.Lead;
import salesforce.ui.components.span.ToastUpdateObjectMessage;
import salesforce.ui.helpers.LeadHelper;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.PageTransporter;
import salesforce.utils.ReplacerMessages;
import salesforce.utils.SheetManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Manages LeadSteps.
 *
 * @author Enrique Carrizales.
 * @version 1.0 25 March 2020.
 */
public class LeadSteps {
    private Context context;
    private PageTransporter pageTransporter;
    private LeadHelper leadHelper;
    private ArrayList<HashMap<String, String>> leadMapList;
    private static final int ARRAY_POSITION_FIRST = 0;
    private String leadStatus;

    /**
     * LeadSteps constructor.
     *
     * @param context value.
     */
    public LeadSteps(final Context context) {
        this.context = context;
        leadHelper = new LeadHelper();
        pageTransporter = new PageTransporter();
    }

    /**
     * Creates leads objects.
     *
     * @param leadQuantity numbers of leads.
     * @param leadType     type of lead.
     */
    @Given("I create {int} {string} leads")
    public void createLeads(final int leadQuantity, final String leadType) {
        String sheetName = "Leads";
        leadMapList = SheetManager.manageSheet(sheetName, leadQuantity, leadType);
        ArrayList<Lead> leads = leadHelper.loadLeads(leadMapList);
        context.setLeads(leads);
        leadHelper.createLeads(context.getLeads());
    }

    /**
     * Changes lead status.
     *
     * @param leadStatus contains a String value.
     * @param listName   contains a String value.
     */
    @When("I change Lead Status to {string} of the leads in list {string}")
    public void changesLeadStatusToOfTheLeads(final String leadStatus, final String listName) {
        this.leadStatus = leadStatus;
        AppPageFactory.getTabObjectsPage().displayList(listName);
        AppPageFactory.getLeadListPage().changeLeadStatus(context.getLeads());
        AppPageFactory.getChangeStatusLeads().selectStatusLeads(leadStatus);
        for (int index = 0; index < context.getLeads().size(); index++) {
            context.getLeads().get(index).setLeadStatus(leadStatus);
        }
    }

    /**
     * Validates a operation.
     *
     * @param message contains a list value.
     */
    @Then("the application should display this message in Leads Page only for Lightning Experience")
    public void theApplicationShouldDisplayThisMessageInLeadsPageOnlyForLightningExperience(
            final List<String> message) {
        ToastUpdateObjectMessage toastUpdateObjectMessageSpan = new ToastUpdateObjectMessage();
        String actualResult = toastUpdateObjectMessageSpan.getMessage();
        String expectedResult = ReplacerMessages.replaceTransactionMessage(message.get(ARRAY_POSITION_FIRST),
                String.valueOf(context.getLeads().size()));
        Assert.assertEquals(actualResult, expectedResult);
    }

    /**
     * Validates leads.
     */
    @Then("Leads Page should display the leads modified")
    public void leadsPageShouldDisplayTheLeadsModified() {
        List<Lead> actualLeads = AppPageFactory.getLeadListPage().getLeadsUpdated(context.getLeads());
        List<Lead> expectedLeads = context.getLeads();
        for (int index = 0; index < expectedLeads.size(); index++) {
            Assert.assertEquals(actualLeads.get(index).getLastName(), expectedLeads.get(index).getLastName());
            Assert.assertEquals(actualLeads.get(index).getCompany(), expectedLeads.get(index).getCompany());
            Assert.assertEquals(actualLeads.get(index).getLeadStatus(), expectedLeads.get(index).getLeadStatus());
        }
    }
}
