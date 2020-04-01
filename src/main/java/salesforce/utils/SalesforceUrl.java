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
    private String campaignsLightningUrl;
    private String leadsLightningUrl;
    private String salesClassicUrl;
    private String opportunitiesClassicUrl;
    private String campaignsClassicUrl;
    private String leadsClassicUrl;
    private String contractsLightningUrl;

    /**
     * Returns loginUrl value.
     *
     * @return String value.
     */
    public String getLoginUrl() {
        return loginUrl;
    }

    /**
     * Returns salesLightningUrl value.
     *
     * @return String value.
     */
    public String getSalesLightningUrl() {
        return salesLightningUrl;
    }

    /**
     * Returns opportunitiesLightningUrl value.
     *
     * @return String value.
     */
    public String getOpportunitiesLightningUrl() {
        return opportunitiesLightningUrl;
    }

    /**
     * Sets loginUrl value.
     *
     * @param loginUrl value.
     */
    public void setLoginUrl(final String loginUrl) {
        this.loginUrl = loginUrl;
    }

    /**
     * Sets salesLightningUrl value.
     *
     * @param salesLightningUrl value.
     */
    public void setSalesLightningUrl(final String salesLightningUrl) {
        this.salesLightningUrl = salesLightningUrl;
    }

    /**
     * Sets opportunitiesLightningUrl value.
     *
     * @param opportunitiesLightningUrl value.
     */
    public void setOpportunitiesLightningUrl(final String opportunitiesLightningUrl) {
        this.opportunitiesLightningUrl = opportunitiesLightningUrl;
    }

    /**
     * Returns salesClassicUrl value.
     *
     * @return String value.
     */
    public String getSalesClassicUrl() {
        return salesClassicUrl;
    }

    /**
     * Returns contractsLightningUrl value.
     *
     * @param contractsLightningUrl value.
     */
    public void setContractsLightningUrl(final String contractsLightningUrl) {
        this.contractsLightningUrl = contractsLightningUrl;
    }

    /**
     * Returns contractsLightningUrl value.
     *
     * @return string value.
     */
    public String getContractsLightningUrl() {
        return contractsLightningUrl;
    }

    /**
     * Sets salesClassicUrl value.
     *
     * @param salesClassicUrl value.
     */
    public void setSalesClassicUrl(final String salesClassicUrl) {
        this.salesClassicUrl = salesClassicUrl;
    }

    /**
     * Returns opportunitiesClassicUrl value.
     *
     * @return String value.
     */
    public String getOpportunitiesClassicUrl() {
        return opportunitiesClassicUrl;
    }

    /**
     * Sets opportunitiesClassicUrl value.
     *
     * @param opportunitiesClassicUrl value.
     */
    public void setOpportunitiesClassicUrl(final String opportunitiesClassicUrl) {
        this.opportunitiesClassicUrl = opportunitiesClassicUrl;
    }

    /**
     * Returns campaignsLightningUrl value.
     *
     * @return String value.
     */
    public String getCampaignsLightningUrl() {
        return campaignsLightningUrl;
    }

    /**
     * Sets campaignsLightningUrl value.
     *
     * @param campaignsLightningUrl value.
     */
    public void setCampaignsLightningUrl(final String campaignsLightningUrl) {
        this.campaignsLightningUrl = campaignsLightningUrl;
    }

    /**
     * Returns campaignsClassicUrl value.
     *
     * @return String value.
     */
    public String getCampaignsClassicUrl() {
        return campaignsClassicUrl;
    }

    /**
     * Sets campaignsClassicUrl value.
     *
     * @param campaignsClassicUrl value.
     */
    public void setCampaignsClassicUrl(final String campaignsClassicUrl) {
        this.campaignsClassicUrl = campaignsClassicUrl;
    }

    /**
     * Returns getLeadsLightningUrl value.
     *
     * @return String value.
     */
    public String getLeadsLightningUrl() {
        return leadsLightningUrl;
    }

    /**
     * Sets setLeadsLightningUrl value.
     *
     * @param leadsLightningUrl value.
     */
    public void setLeadsLightningUrl(final String leadsLightningUrl) {
        this.leadsLightningUrl = leadsLightningUrl;
    }

    /**
     * Returns getLeadsClassicUrl value.
     *
     * @return String value.
     */
    public String getLeadsClassicUrl() {
        return leadsClassicUrl;
    }

    /**
     * Sets setLeadsClassicUrl value.
     *
     * @param leadsClassicUrl value.
     */
    public void setLeadsClassicUrl(final String leadsClassicUrl) {
        this.leadsClassicUrl = leadsClassicUrl;
    }
}
