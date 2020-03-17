/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package core.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import salesforce.requestapi.Authentication;
import salesforce.utils.AccessToken;
import salesforce.utils.EndPoint;
import salesforce.utils.JsonFileReader;

/**
 * Manages account api requests.
 *
 * @author Juan Martinez.
 * @version 1.0 16 March 2020.
 */
public class AccountApi {
    private static final String AUTHORIZATION = "Authorization";
    private static final String CONTENT_TYPE = "Content-Type";
    private static String token = Authentication.getAccessToken();

    /**
     * Creates a new account.
     * @param fileName of json file.
     * @return response value.
     */
    public static Response postAccount(final String fileName) {
            JSONObject json = JsonFileReader.JsonReader(fileName);
        return RestAssured.given().headers(AUTHORIZATION, token, CONTENT_TYPE, ContentType.JSON)
            .request().accept(ContentType.JSON).body(json.toJSONString())
            .when().post(AccessToken.getInstance().getClient().getInstanceUrl() + EndPoint.ACCOUNT_ENDPOINT)
            .then().extract().response();
    }
}