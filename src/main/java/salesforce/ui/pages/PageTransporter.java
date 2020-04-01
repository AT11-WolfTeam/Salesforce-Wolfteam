/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages;

import core.selenium.WebDriverManager;
import core.utils.GradleReader;
import salesforce.utils.PropertiesReader;
import java.util.HashMap;

/**
 * "Manages navigation in browser.
 *
 * @author Alan Escalera.
 * @version 1.0 17 March 2020.
 */
public class PageTransporter {
    private HashMap<String, String> urlLightningMap;
    private HashMap<String, String> urlClassicMap;
    private String userExperience = GradleReader.getInstance().getUserExperience();
    private static final String LIGHTNING = "Lightning";

    /**
     * Constructor initialize HashMap.
     */
    public PageTransporter() {
        urlLightningMap = new HashMap<>();
        urlLightningMap.put("Login Page", PropertiesReader.getInstance().getSalesforceUrl().getLoginUrl());
        urlLightningMap.put("Sales Page", PropertiesReader.getInstance().getSalesforceUrl().getSalesLightningUrl());
        urlLightningMap.put("Opportunities Page", PropertiesReader.getInstance().getSalesforceUrl()
                .getOpportunitiesLightningUrl());
        urlLightningMap.put("Campaigns Page", PropertiesReader.getInstance().getSalesforceUrl()
                .getCampaignsLightningUrl());
        urlLightningMap.put("Leads Page", PropertiesReader.getInstance().getSalesforceUrl().getLeadsLightningUrl());
        urlLightningMap.put("Contracts Page", PropertiesReader.getInstance().getSalesforceUrl()
                .getContractsLightningUrl());
        urlClassicMap = new HashMap<>();
        urlClassicMap.put("Login Page", PropertiesReader.getInstance().getSalesforceUrl().getLoginUrl());
        urlClassicMap.put("Sales Page", PropertiesReader.getInstance().getSalesforceUrl().getSalesClassicUrl());
        urlClassicMap.put("Opportunities Page", PropertiesReader.getInstance().getSalesforceUrl()
                .getOpportunitiesClassicUrl());
        urlClassicMap.put("Campaigns Page", PropertiesReader.getInstance().getSalesforceUrl().getCampaignsClassicUrl());
        urlClassicMap.put("Leads Page", PropertiesReader.getInstance().getSalesforceUrl().getLeadsClassicUrl());
    }

    /**
     * Navigates to a web page.
     *
     * @param page contains the name of the page.
     */
    public void navigateToPage(final String page) {
        if (userExperience.equals(LIGHTNING)) {
            WebDriverManager.getInstance().getWebDriver().get(urlLightningMap.get(page));
        } else {
            WebDriverManager.getInstance().getWebDriver().get(urlClassicMap.get(page));
        }
    }
}
