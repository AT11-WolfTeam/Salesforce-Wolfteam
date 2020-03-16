/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package com.steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Manages com.steps definition.
 *
 * @author Enrique Carrizales.
 * @version 1.0 16 March 2020.
 */
public class OpportunitySteps {

    @Given("^I create opportunity as (.*)")
    public void createABoardWithName(String opportunity) {
        System.out.println("com.steps.Opportunity: Given");
    }

    @When("^I change a opportunity's owner with \"([^\"]*)\"$")
    public void iChangeAOpportunitySOwnerWith(String owner) {
        System.out.println("com.steps.Opportunity: When");
    }

    @Then("^the application should display an information message in Opportunity page with the format \"([^\"]*)\"$")
    public void theApplicationShouldDisplayAnInformationMessageInOpportunityPageWithTheFormat(String message) {
        System.out.println("com.steps.Opportunity: Then");
    }
}
