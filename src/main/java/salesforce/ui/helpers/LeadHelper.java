/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.helpers;

import core.selenium.WebDriverManager;
import salesforce.entities.Lead;
import salesforce.ui.pages.AppPageFactory;
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
    private static final String LEADS_LIGHTNING_PAGE_URL = "https://na111.lightning.force.com/lightning/o/Lead/list"
            + "?filterName=Recent";

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

        goToLeadPage();

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
        goToLeadPage();

        AppPageFactory.getTabObjectsPage().displayList("All Open Leads");
        for (Lead lead : leads) {
            AppPageFactory.getTabObjectsPage().clickOnDeleteButton(lead.getLastName());
        }
    }

    /**
     * Navigates to a page.
     */
    private void goToLeadPage() {
        WebDriverManager.getInstance().getWebDriver().get(LEADS_LIGHTNING_PAGE_URL);
    }
}
