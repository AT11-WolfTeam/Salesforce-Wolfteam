/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package core.salesforce;

import core.utils.AccessToken;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

/**
 * Allows to authenticate on salesforce.
 *
 * @author Juan Martinez.
 * @version 1.0 16 March 2020.
 */
public class Authentication {

    /**
     * Authentication constructor
     */
    private Authentication() {

    }

    /**
     * Allows to Builds, then Sends authentication request.
     * @return request specification.
     */
    public static RequestSpecification authenticationRequest() {
        return new RequestSpecBuilder().setBaseUri(AccessToken.getInstance().getClient().getInstanceUrl())
                .addHeader("Authorization", AccessToken.getInstance().getClient().getTokenType()
                + " " + AccessToken.getInstance().getClient().getAccessToken()).build();
    }
}
