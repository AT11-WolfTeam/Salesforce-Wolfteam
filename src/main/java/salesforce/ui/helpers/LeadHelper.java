/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.helpers;

import salesforce.entities.Lead;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.PageTransporter;
import salesforce.ui.pages.lead.NewLeadLightningPopup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Manages Lead helper.
 *
 * @author Enrique Carrizales.
 * @version 1.0 25 March 2020.
 */
public class LeadHelper {
    private Lead lead;
    private PageTransporter pageTransporter;
    private static final String LEADS_PAGE = "Leads Page";

    /**
     * Builds a LeadHelper.
     */
    public LeadHelper() {
        pageTransporter = new PageTransporter();
    }

    /**
     * Sets leads.
     *
     * @param leadMapList values.
     * @return lead list.
     */
    public ArrayList<Lead> loadLeads(final ArrayList<HashMap<String, String>> leadMapList) {
        ArrayList<Lead> leadList = new ArrayList<>();
        for (HashMap<String, String> leadItem : leadMapList) {
            lead = new Lead();
            lead.setLeadInformation(leadItem);
            leadList.add(lead);
        }
        return leadList;
    }

    /**
     * Creates leads.
     *
     * @param leads contains a list value.
     */
    public void createLeads(final List<Lead> leads) {
        final int oneItem = 1;
        final int zero = 0;
        pageTransporter.navigateToPage(LEADS_PAGE);

        AppPageFactory.getTabObjectsPage().clickOnNewButton();
        NewLeadLightningPopup newLeadLightningPopup = new NewLeadLightningPopup();
        for (int index = zero; index < leads.size(); index++) {
            newLeadLightningPopup.loadNewLeadFields(leads.get(index));
            if (leads.size() == oneItem || index == leads.size() - oneItem) {
                newLeadLightningPopup.clickOnSaveButton();
            } else {
                newLeadLightningPopup.clickOnSaveAndNew();
            }
        }
    }

    /**
     * Manages deletion of leads.
     *
     * @param leads contains a list of leads.
     */
    public void deleteLeads(final List<Lead> leads) {
        pageTransporter.navigateToPage(LEADS_PAGE);
        AppPageFactory.getTabObjectsPage().displayList("All Open Leads");
        for (Lead lead : leads) {
            AppPageFactory.getTabObjectsPage().clickOnDeleteButton(lead.getLastName());
        }
    }
}
