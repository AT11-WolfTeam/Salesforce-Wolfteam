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
     * @param leads contains a list value.
     */
    public void createLeads(final List<Lead> leads) {
        final int oneItem = 1;
        final String pageToGo = "Leads Page";
        PageTransporter pageTransporter = new PageTransporter();
        pageTransporter.navigateToPage(pageToGo);

        AppPageFactory.getTabObjectsPage().clickOnNewButton();
        NewLeadLightningPopup newLeadLightningPopup = new NewLeadLightningPopup();
        for (int i = 0; i < leads.size(); i++) {
            newLeadLightningPopup.loadNewLeadFields(leads.get(i));
            if (leads.size() == oneItem || i == leads.size() - 1) {
                newLeadLightningPopup.clickOnSaveButton();
            }
            newLeadLightningPopup.clickOnSaveAndNew();
        }
    }
}
