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
    private String loginUrl;
    private String salesLightningUrl;
    private String opportunitiesLightningUrl;

    private String salesClassicUrl;
    private String opportunitiesClassicUrl;

    /**
     * Returns loginPage value.
     *
     * @return String value.
     */
    public String getLoginUrl() {
        return loginUrl;
    }

    /**
     * Returns salesPage value.
     *
     * @return String value.
     */
    public String getSalesLightningUrl() {
        return salesLightningUrl;
    }

    /**
     * Returns opportunitiesPage value.
     *
     * @return String value.
     */
    public String getOpportunitiesLightningUrl() {
        return opportunitiesLightningUrl;
    }

    /**
     * Sets loginPage value.
     *
     * @param loginUrl value.
     */
    public void setLoginUrl(final String loginUrl) {
        this.loginUrl = loginUrl;
    }

    /**
     * Sets salesPage value.
     *
     * @param salesLightningUrl value.
     */
    public void setSalesLightningUrl(final String salesLightningUrl) {
        this.salesLightningUrl = salesLightningUrl;
    }

    /**
     * Sets opportunitiesPage value.
     *
     * @param opportunitiesLightningUrl value.
     */
    public void setOpportunitiesLightningUrl(final String opportunitiesLightningUrl) {
        this.opportunitiesLightningUrl = opportunitiesLightningUrl;
    }

    /**
     * Returns salesCalssicPage value.
     *
     * @return String value.
     */
    public String getSalesClassicUrl() {
        return salesClassicUrl;
    }

    /**
     * Sets SalesClassicPage value.
     *
     * @param salesClassicUrl value.
     */
    public void setSalesClassicUrl(final String salesClassicUrl) {
        this.salesClassicUrl = salesClassicUrl;
    }

    /**
     * Returns opportunitiesClassicPage value.
     *
     * @return String value.
     */
    public String getOpportunitiesClassicUrl() {
        return opportunitiesClassicUrl;
    }

    /**
     * Sets opportunitiesClassicPage value.
     *
     * @param opportunitiesClassicUrl value.
     */
    public void setOpportunitiesClassicUrl(final String opportunitiesClassicUrl) {
        this.opportunitiesClassicUrl = opportunitiesClassicUrl;
    }
}
