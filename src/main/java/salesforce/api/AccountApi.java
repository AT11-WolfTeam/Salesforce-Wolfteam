/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import salesforce.restclient.Authentication;
import salesforce.utils.AccessToken;
import salesforce.utils.EndPoint;
import salesforce.utils.TokenConstant;

/**
 * Manages account api requests.
 *
 * @author Juan Martinez.
 * @version 1.0 16 March 2020.
 */
public class AccountApi {
    private static String token = Authentication.getAccessToken();

    /**
     * Posts entity.
     * @param jsonEntity of json entity.
     * @return response value.
     */
    public static Response postEntity(final String jsonEntity) {
        return RestAssured.given().headers(TokenConstant.AUTHORIZATION, token, TokenConstant.CONTENT_TYPE,
            ContentType.JSON).request().accept(ContentType.JSON).body(jsonEntity)
            .when().post(AccessToken.getInstance().getClient().getInstanceUrl() + EndPoint.ACCOUNT_ENDPOINT)
            .then().extract().response();
    }
}
