/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package core.salesforce;

/**
 * Content salesforce user values.
 *
 * @author Juan Martinez.
 * @version 1.0 15 March 2020.
 */
public class SalesforceUser {
    private String username;
    private String password;
    private String grantType;
    private String clientId;
    private String clientSecret;
    private String token;
    private String authUrl;

    /**
     * Gets username value.
     * @return username value.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets password value.
     * @return password value.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets grant type value.
     * @return grant type value.
     */
    public String getGrantType() {
        return grantType;
    }

    /**
     * Gets client id value.
     * @return client id value.
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * Gets client secret value.
     * @return client secret value.
     */
    public String getClientSecret() {
        return clientSecret;
    }

    /**
     * Gets token value.
     * @return token value.
     */
    public String getToken() {
        return token;
    }

    /**
     * Gets auth url value.
     * @return auth url value.
     */
    public String getAuthUrl() {
        return authUrl;
    }

    /**
     * Sets username value.
     * @param username value.
     */
    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     * Sets password value.
     * @param password value.
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Sets grant type value.
     * @param grantType value.
     */
    public void setGrantType(final String grantType) {
        this.grantType = grantType;
    }

    /**
     * Sets client id value.
     * @param clientId value.
     */
    public void setClientId(final String clientId) {
        this.clientId = clientId;
    }

    /**
     * Sets client secret value.
     * @param clientSecret value.
     */
    public void setClientSecret(final String clientSecret) {
        this.clientSecret = clientSecret;
    }

    /**
     * Sets token value.
     * @param token value.
     */
    public void setToken(final String token) {
        this.token = token;
    }

    /**
     * Sets auth url value.
     * @param authUrl value.
     */
    public void setAuthUrl(final String authUrl) {
        this.authUrl = authUrl;
    }
}
