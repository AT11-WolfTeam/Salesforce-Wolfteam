/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Manages steps definition.
 *
 * @author Enrique Carrizales.
 * @version 1.0 16 March 2020.
 */
public class Opportunity {

    @Given("^Create opportunity as \"([^\"]*)\"$")
    public void createABoardWithName(String opportunity) {
        System.out.println("steps.Opportunity: Given");
    }

    @When("^I change a opportunity's owner with \"([^\"]*)\"$")
    public void iChangeAOpportunitySOwnerWith(String owner) {
        System.out.println("steps.Opportunity: When");
    }


    @Then("^The application should display information message \"([^\"]*)\"$")
    public void theApplicationShouldDisplayInformationMessage(String message) {
        System.out.println("steps.Opportunity: Then");
    }
}
