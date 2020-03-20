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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.PageTransporter;

/**
 * Manages a Opportunity steps definition.
 *
 * @author Enrique Carrizales.
 * @version 1.0 16 March 2020.
 */
public class OpportunityStep {
    private static final String OPPORTUNITY_PAGE = "Opportunities Page";

    /**
     * Creates Opportunity.
     *
     * @param opportunity contains name Opportunity object.
     */
    @Given("^I create opportunity as (.*)")
    public void createsOpportunity(final String opportunity) {
        System.out.println(opportunity);
    }

    /**
     * Changes an opportunity's Owner.
     *
     * @param owner contains name Owner object.
     */
    @When("^I change an opportunity's owner with \"([^\"]*)\"$")
    public void changesAnOpportunitySOwnerWith(final String owner) {
        System.out.println(owner);
    }

    /**
     * Validates a message.
     *
     * @param message contains a String message.
     */
    @Then("^the application should display an information message in Opportunity page with the format \"([^\"]*)\"$")
    public void displaysAnInformationMessageInOpportunityPageWithTheFormat(final String message) {
        System.out.println("com.steps.Opportunity: Then");
    }

    /**
     * Navigates to an opportunity.
     */
    @And("I navigate to Opportunities Page")
    public void navigatesToOpportunitiesPage() {
        PageTransporter pageTransporter = new PageTransporter();
        pageTransporter.navigateToPage(OPPORTUNITY_PAGE);
    }

    /**
     * Search an opportunity.
     * @param opportunityName contains a String value.
     * @param listName contains a String value.
     */
    @And("I search an opportunity {string} in list {string}")
    public void searchOpportunity(final String opportunityName, final String listName) {
        AppPageFactory.getOpportunitiesPage().displayOpportunityList(listName);
        AppPageFactory.getOpportunityList().clickOnOpportunity(opportunityName);
    }
}
