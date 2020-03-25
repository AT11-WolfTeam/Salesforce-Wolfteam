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
import salesforce.entities.Lead;
import salesforce.ui.helpers.LeadHelper;
import salesforce.ui.pages.PageTransporter;
import salesforce.utils.SheetManager;

import java.util.ArrayList;
import java.util.HashMap;

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
     * @param leadQuantity numbers of leads.
     * @param leadType type of lead.
     */
    @Given("I create {int} {string} leads")
    public void createLeads(final int leadQuantity, final String leadType) {
        String sheetName = "Leads";
        leadMapList = SheetManager.manageSheet(sheetName, leadQuantity, leadType);
        ArrayList<Lead> leads = leadHelper.loadLeads(leadMapList);
        context.setLeads(leads);
        leadHelper.createLeads(context.getLeads());
    }
}
