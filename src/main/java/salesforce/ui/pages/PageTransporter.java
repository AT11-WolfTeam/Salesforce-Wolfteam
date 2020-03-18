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

import salesforce.utils.PropertiesReader;

import java.util.HashMap;

/**
 * "Manages navigation in browser.
 *
 * @author Alan Escalera.
 * @version 1.0 17 March 2020.
 */
public class PageTransporter {
    private HashMap<String, String> urlMap;

    /**
     * Constructor initialize HasMap.
     */
    public PageTransporter() {
        urlMap = new HashMap<>();
        urlMap.put("Login Page", PropertiesReader.getInstance().getSalesforceUrl().getLoginPage());
        urlMap.put("Sales Page", PropertiesReader.getInstance().getSalesforceUrl().getSalesPage());
        urlMap.put("Opportunities Page", PropertiesReader.getInstance().getSalesforceUrl().getOpportunitiesPage());
    }

    /**
     * Navigates to a web page.
     *
     * @param page contains the name of the page.
     */
    public void navigateToPage(final String page) {
        WebDriverManager.getInstance().getWebDriver().get(urlMap.get(page));
    }
}
