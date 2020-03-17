/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package utils;

import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * Generates access token.
 *
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
                .param(TokenConstant.USER_NAME, PropertiesReader.getInstance().getUser().getUsername())
                .param(TokenConstant.PASSWORD, PropertiesReader.getInstance().getUser().getPassword()
                        + userToken)
                .param(TokenConstant.GRANT_TYPE, PropertiesReader.getInstance().getUser().getGrantType())
                .param(TokenConstant.CLIENT_ID, PropertiesReader.getInstance().getUser().getClientId())
                .param(TokenConstant.CLIENT_SECRET, PropertiesReader.getInstance().getUser().getClientSecret())
                .when().post(PropertiesReader.getInstance().getUser().getAuthUrl());
        jsonResponse = response.jsonPath().getMap("$");
        setClient(jsonResponse);
    }

    /**
     * Sets json response values.
     * @param jsonResponse value.
     */
    private void setClient(final Map<String, String> jsonResponse) {
        client.setAccessToken(jsonResponse.get(TokenConstant.ACCESS_TOKEN));
        client.setInstanceUrl(jsonResponse.get(TokenConstant.INSTANCE_URL));
        client.setId(jsonResponse.get(TokenConstant.ID));
        client.setTokenType(jsonResponse.get(TokenConstant.TOKEN_TYPE));
        client.setIssuedAt(jsonResponse.get(TokenConstant.ISSUED_AT));
        client.setSignature(jsonResponse.get(TokenConstant.SIGNATURE));
    }

    /**
     * Gets client instance.
     * @return client object.
     */
    public Client getClient() {
        return client;
    }
}
