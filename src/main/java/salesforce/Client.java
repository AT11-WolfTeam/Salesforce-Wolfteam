/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce;

/**
 * Salesforce Client values.
 *
 * @author Juan Martinez.
 * @version 1.0 15 March 2020.
 */
public class Client {

    private String accessToken;
    private String instanceUrl;
    private String id;
    private String tokenType;
    private String issuedAt;
    private String signature;
    private String authUrl;

    /**
     * Gets access token generated.
     * @return accessToken value.
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * Gets instance url generated.
     * @return instance url value.
     */
    public String getInstanceUrl() {
        return instanceUrl;
    }

    /**
     * Gets id generated.
     * @return id value.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets token type generated.
     * @return token type value.
     */
    public String getTokenType() {
        return tokenType;
    }

    /**
     * Gets issued at generated.
     * @return issued at value.
     */
    public String getIssuedAt() {
        return issuedAt;
    }

    /**
     * Gets signature generated.
     * @return signature value.
     */
    public String getSignature() {
        return signature;
    }

    /**
     * Gets auth url.
     * @return auth url value.
     */
    public String getAuthUrl() {
        return authUrl;
    }

    /**
     * Sets access token value.
     * @param accessToken value.
     */
    public void setAccessToken(final String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * Sets instance url value.
     * @param instanceUrl value.
     */
    public void setInstanceUrl(final String instanceUrl) {
        this.instanceUrl = instanceUrl;
    }

    /**
     * Sets is value.
     * @param id value.
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * Sets token type value.
     * @param tokenType value.
     */
    public void setTokenType(final String tokenType) {
        this.tokenType = tokenType;
    }

    /**
     * Sets issuedAt value.
     * @param issuedAt value.
     */
    public void setIssuedAt(final String issuedAt) {
        this.issuedAt = issuedAt;
    }

    /**
     * Sets signature value.
     * @param signature value.
     */
    public void setSignature(final String signature) {
        this.signature = signature;
    }

    /**
     * Sets auth url.
     * @param authUrl value.
     */
    public void setAuthUrl(final String authUrl) {
        this.authUrl = authUrl;
    }
}
