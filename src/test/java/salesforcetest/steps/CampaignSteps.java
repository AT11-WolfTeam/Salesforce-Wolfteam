/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforcetest.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 *
 * @author Juan Martinez.
 * @version 1.0 24 March 2020.
 */
public class CampaignSteps {

    /**
     * Allows to add contacts to campaigns.
     * @param campaignName value.
     */
    @When("I add the contacts to {string}")
    public void addContactsToCampaign(final String campaignName) {

    }

    /**
     * Allows to add verify added contacts.
     * @param pageName value.
     */
    @Then("The added contacts should be displayed on {string} page")
    public void verifyContacts(final String pageName) {

    }
}
