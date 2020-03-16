/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.restclient;

import io.restassured.specification.RequestSpecification;

/**
 * Manages rest client requests.
 *
 * @author Juan Martinez.
 * @version 1.0 16 March 2020.
 */
public class RestClientApi {
    private RequestSpecification request;
    private static RestClientApi restClientApi;

    /**
     * RestClientApi constructor.
     */
    private RestClientApi() {

    }

    /**
     * Gets rest client api instance.
     * @return rest client api instance.
     */
    public static RestClientApi getInstance() {
        if (restClientApi == null) {
            restClientApi = new RestClientApi();
        }
        return restClientApi;
    }
}
