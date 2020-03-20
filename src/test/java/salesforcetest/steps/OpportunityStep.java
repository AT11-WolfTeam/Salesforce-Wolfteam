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
import salesforce.api.requestapi.OpportunityApiHelper;
import salesforce.entities.Context;
import salesforce.entities.Opportunity;
import salesforce.utils.SheetManager;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Manages com.steps definition.
 *
 * @author Enrique Carrizales.
 * @version 1.0 16 March 2020.
 */
public class OpportunityStep {

    // Entities
    private Context context;

    private OpportunityApiHelper opportunityApiHelper;
    private ArrayList<HashMap<String, String>> opportunityMapList;

    /**
     * OpportunityStep constructor.
     * @param context value.
     */
    public OpportunityStep(final Context context) {
        this.context = context;
        opportunityApiHelper = new OpportunityApiHelper();
    }

    /**
     * Creates Opportunity.
     * @param opportunity contains name Opportunity object.
     */
    @Given("^I create opportunity as (.*)")
    public void createsOpportunity(final String opportunity) {
        System.out.println("com.steps.Opportunity: Given");
    }

    /**
     * Changes an opportunity's Owner.
     * @param owner contains name Owner object.
     */
    @When("^I change an opportunity's owner with \"([^\"]*)\"$")
    public void changesAnOpportunitySOwnerWith(final String owner) {
        System.out.println("com.steps.Opportunity: When");
    }

    /**
     * Validates a message.
     * @param message contains a String message.
     */
    @Then("^the application should display an information message in Opportunity page with the format \"([^\"]*)\"$")
    public void displaysAnInformationMessageInOpportunityPageWithTheFormat(final String message) {
        System.out.println("com.steps.Opportunity: Then");
    }

    /**
     * Allows to create many opportunities.
     * @param quantity number of opportunities.
     * @param opportunityType value.
     */
    @Given("I create {int} {string} opportunities")
    public void createsOpportunities(final int quantity, final String opportunityType) {
        String sheetName = "Opportunities";
        opportunityMapList = SheetManager.manageSheet(sheetName, quantity, opportunityType);
        ArrayList<Opportunity> opportunities = opportunityApiHelper.setOpportunities(opportunityMapList);
        context.setOpportunities(opportunities);
        opportunityApiHelper.postOpportunities(context.getOpportunities());
    }

    /**
     * Deletes created opportunities.
     */
    @When("I delete created opportunities")
    public void deletedOpportunities() {
        opportunityApiHelper.deleteOpportunities(context.getOpportunities());
        final String expected = "204";
        for (Opportunity opportunity : context.getOpportunities()) {
            Assert.assertEquals(opportunity.getStatusCode(), expected);
        }
    }
}
