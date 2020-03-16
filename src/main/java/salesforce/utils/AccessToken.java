/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.utils;

import io.restassured.response.Response;

import salesforce.Client;

import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * Generates access token.
 * @author Juan Martinez.
 * @version 1.0 16 March 2020.
 */
public final class AccessToken {
    private static AccessToken accessToken;
    private static Response response;
    private static Map<String, String> jsonResponse;
    private static Client client;

    /**
     * Constructor to initialize AccessToken.
     */
    private AccessToken() {
        initializeAccessToken();
    }

    /**
     * Gets instance of AccessToken.
     * @return AccessToken instance.
     */
    public static AccessToken getInstance() {
        if (accessToken == null) {
            client = new Client();
            accessToken = new AccessToken();
        }
        return accessToken;
    }

    /**
     * Initializes AccessToken.
     */
    private void initializeAccessToken()  {
        String userToken = PropertiesReader.getInstance().getUser().getToken();
        response = given()
            .param("username", PropertiesReader.getInstance().getUser().getUsername())
            .param("password", PropertiesReader.getInstance().getUser().getPassword()
            + userToken)
            .param("grant_type", PropertiesReader.getInstance().getUser().getGrantType())
            .param("client_id", PropertiesReader.getInstance().getUser().getClientId())
            .param("client_secret", PropertiesReader.getInstance().getUser().getClientSecret())
            .when().post(PropertiesReader.getInstance().getUser().getAuthUrl());
        jsonResponse = response.jsonPath().getMap("$");
        setClient(jsonResponse);
    }

    /**
     * Sets client values.
     */
    private void setClient(final Map<String, String> jsonResponse) {
        client.setAccessToken(jsonResponse.get("access_token"));
        client.setInstanceUrl(jsonResponse.get("instance_url"));
        client.setId(jsonResponse.get("id"));
        client.setTokenType(jsonResponse.get("token_type"));
        client.setIssuedAt(jsonResponse.get("issued_at"));
        client.setSignature(jsonResponse.get("signature"));
    }

    /**
     * Gets client instance.
     * @return
     */
    public Client getClient() {
        return client;
    }
}
