/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforcetest.steps;

import io.cucumber.java.en.When;
import salesforce.entities.Context;
import salesforce.ui.helpers.LeadHelper;
import salesforce.ui.pages.PageTransporter;

/**
 * Manages Lead information.
 *
 * @author Enrique Carrizales.
 * @version 1.0 24 March 2020.
 */
public class CampaignSteps {
    private Context context;
    private PageTransporter pageTransporter;
    private LeadHelper leadHelper;

    /**
     * OpportunityStep constructor.
     *
     * @param context value.
     */
    public CampaignSteps(final Context context) {
        this.context = context;
        pageTransporter = new PageTransporter();
    }

    /**
     * Adds leads to a campaign.
     */
    @When("I add the leads to the campaign")
    public void addLeads() {
        //Todo
    }
}
