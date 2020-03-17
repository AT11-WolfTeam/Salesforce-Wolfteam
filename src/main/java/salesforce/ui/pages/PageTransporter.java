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

import java.util.HashMap;

/**
 * Defines a page transporter.
 *
 * @author Alan Escalera.
 * @version 1.0 17 March 2020.
 */
public class PageTransporter {

    private HashMap<String, String> urlMap;

    /**
     * PageTransporter constructor.
     */
    public PageTransporter() {
        urlMap = new HashMap<>();
        urlMap.put("Login Page", GradleReader.getInstance().getLoginPage());
        urlMap.put("Sales Page", GradleReader.getInstance().getSalesPage());
        urlMap.put("Opportunities Page", GradleReader.getInstance().getOpportunitiesPage());

    }

    /**
     * This Navigate to the page sent.
     *
     * @param page contains the name of the page.
     */
    public void navigateToPage(final String page) {
        WebDriverManager.getInstance().getWebDriver().get(urlMap.get(page));
    }
}
