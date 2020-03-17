/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package com.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import salesforce.entities.Opportunity;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.opportunities.OpportunitiesPageAbstract;
import salesforce.ui.pages.opportunities.NewOpportunityPageAbstract;

import java.util.Map;

/**
 * Manages com.steps definition.
 *
 * @author Enrique Carrizales.
 * @version 1.0 16 March 2020.
 */
public class OpportunityStep {

    // Pages
    OpportunitiesPageAbstract opportunitiesPage;
    NewOpportunityPageAbstract opportunityPage;

    // Entities
    Opportunity opportunity;

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
     *
     * @param opportunityMap
     */
    @And("I create an Opportunity with")
    public void iCreateAnOpportunityWith(final Map<String, String> opportunityMap) {  // List<Opportunity>
        opportunity.setInformation(opportunityMap);

        // Create Opportunity by UI
        opportunitiesPage = AppPageFactory.getOpportunitiesPage();
        opportunityPage = opportunitiesPage.clickNewOpportunityBtn();
        opportunityPage.createOpportunity(opportunity);
    }
}
