/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.entities;

/**
 * Manages SalesforceUser class.
 *
 * @author Enrique Carrizales.
 * @version 1.0 19 March 2020.
 */
public class SalesforceUser {

    private String username;
    private String password;

    /**
     * Return a Username value.
     * @return a String value.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets a Username value.
     * @param username receives a String value.
     */
    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     * Return a Password.
     * @return a String value.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets a Password value.
     * @param password receives a String value.
     */
    public void setPassword(final String password) {
        this.password = password;
    }
}
