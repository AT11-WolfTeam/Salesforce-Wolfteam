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
    private String salesPage;
    private String opportunitiesPage;

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
    public String getSalesPage() {
        return salesPage;
    }

    /**
     * Returns opportunitiesPage value.
     *
     * @return String value.
     */
    public String getOpportunitiesPage() {
        return opportunitiesPage;
    }

    /**
     * Sets loginPage value.
     * @param loginPage value.
     */
    public void setLoginPage(final String loginPage) {
        this.loginPage = loginPage;
    }

    /**
     * Sets salesPage value.
     * @param salesPage value.
     */
    public void setSalesPage(final String salesPage) {
        this.salesPage = salesPage;
    }

    /**
     * Sets opportunitiesPage value.
     * @param opportunitiesPage value.
     */
    public void setOpportunitiesPage(final String opportunitiesPage) {
        this.opportunitiesPage = opportunitiesPage;
    }
}
