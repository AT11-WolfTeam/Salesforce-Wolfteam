/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package utils;

/**
 * Content salesforce endpoints URI.
 *
 * @author Juan Martinez.
 * @version 1.0 17 March 2020.
 */
public final class EndPoint {
    public static final String ACCOUNT_ENDPOINT = "/services/data/v48.0/sobjects/Account/";
    public static final String OPPORTUNITY_ENDPOINT = "/services/data/v48.0/sobjects/Opportunity";
    public static final String TASK_ENDPOINT = "/services/data/v48.0/sobjects/Task";
    public static final String CONTACT_ENDPOINT = "/services/data/v48.0/sobjects/Contact";
    public static final String LEAD_ENDPOINT = "/services/data/v48.0/sobjects/lead";

    /**
     * Endpoint constructor.
     */
    private EndPoint() {
    }
}
