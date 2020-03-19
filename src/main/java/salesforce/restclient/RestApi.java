/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.restclient;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import salesforce.utils.AccessToken;
import salesforce.utils.TokenConstant;

/**
 * Manages account api requests.
 *
 * @author Juan Martinez.
 * @version 1.0 16 March 2020.
 */
public final class RestApi {
    private static String token = Authentication.getAccessToken();

    /**
     * Private AccountApi constructor.
     */
    private RestApi() {

    }

    /**
     * Posts entity.
     * @param jsonEntity of json entity.
     * @return response value.
     */
    public static Response postEntity(final String jsonEntity, final String endpoint) {
        return RestAssured.given().headers(TokenConstant.AUTHORIZATION, token, TokenConstant.CONTENT_TYPE,
            ContentType.JSON).request().accept(ContentType.JSON).body(jsonEntity)
            .when().post(AccessToken.getInstance().getClient().getInstanceUrl() + endpoint)
            .then().extract().response();
    }

    /**
     * Deletes entity by Id.
     * @param entityId of entity.
     * @return response message.
     */
    public static Response deleteEntity(final String entityId, final String endpoint) {
        return RestAssured.given().headers(TokenConstant.AUTHORIZATION, token, TokenConstant.CONTENT_TYPE,
            ContentType.JSON).request().accept(ContentType.JSON)
            .when().delete(AccessToken.getInstance().getClient().getInstanceUrl() + endpoint
            + entityId).then().extract().response();
    }
}
