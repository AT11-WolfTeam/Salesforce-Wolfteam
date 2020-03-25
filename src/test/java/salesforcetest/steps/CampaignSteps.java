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
import salesforce.entities.Context;
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
    private static final int ARRAY_POSITION_FIRST = 0;

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
     * Creates leads objects.
     *
     * @param leadsQuantity contains quantity.
     * @param leadType      a Lead type.
     */
    @Given("I create {int} {string} leads")
    public void createsLeads(final int leadsQuantity, final String leadType) {
    }
}
