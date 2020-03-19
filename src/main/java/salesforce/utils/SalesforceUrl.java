/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.utils;

/**
 * Contents salesforce urls values.
 *
 * @author Alan Escalera.
 * @version 1.0 18 March 2020.
 */
public class SalesforceUrl {
    private String loginPage;
    private String salesLightningPage;
    private String opportunitiesLightningPage;

    private String salesClassicPage;
    private String opportunitiesClassicPage;


    /**
     * Returns loginPage value.
     *
     * @return String value.
     */
    public String getLoginPage() {
        return loginPage;
    }

    /**
     * Returns salesPage value.
     *
     * @return String value.
     */
    public String getSalesLightningPage() {
        return salesLightningPage;
    }

    /**
     * Returns opportunitiesPage value.
     *
     * @return String value.
     */
    public String getOpportunitiesLightningPage() {
        return opportunitiesLightningPage;
    }

    /**
     * Sets loginPage value.
     *
     * @param loginPage value.
     */
    public void setLoginPage(final String loginPage) {
        this.loginPage = loginPage;
    }

    /**
     * Sets salesPage value.
     *
     * @param salesLightningPage value.
     */
    public void setSalesLightningPage(final String salesLightningPage) {
        this.salesLightningPage = salesLightningPage;
    }

    /**
     * Sets opportunitiesPage value.
     *
     * @param opportunitiesLightningPage value.
     */
    public void setOpportunitiesLightningPage(final String opportunitiesLightningPage) {
        this.opportunitiesLightningPage = opportunitiesLightningPage;
    }

    /**
     * Returns salesCalssicPage value.
     *
     * @return String value.
     */
    public String getSalesClassicPage() {
        return salesClassicPage;
    }

    /**
     * Sets SalesClassicPage value.
     *
     * @param salesClassicPage value.
     */
    public void setSalesClassicPage(final String salesClassicPage) {
        this.salesClassicPage = salesClassicPage;
    }

    /**
     * Returns opportunitiesClassicPage value.
     *
     * @return String value.
     */
    public String getOpportunitiesClassicPage() {
        return opportunitiesClassicPage;
    }

    /**
     * Sets opportunitiesClassicPage value.
     *
     * @param opportunitiesClassicPage value.
     */
    public void setOpportunitiesClassicPage(final String opportunitiesClassicPage) {
        this.opportunitiesClassicPage = opportunitiesClassicPage;
    }
}
