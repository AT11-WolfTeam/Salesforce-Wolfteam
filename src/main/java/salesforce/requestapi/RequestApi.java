/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.requestapi;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

/**
 * Manages rest client requests.
 *
 * @author Juan Martinez.
 * @version 1.0 16 March 2020.
 */
public class RequestApi {
    private RequestSpecification request;
    private static RequestApi requestApi;

    /**
     * RestClientApi constructor.
     */
    private RequestApi() {

    }

    /**
     * Gets rest client api instance.
     * @return rest client api instance.
     */
    public static RequestApi getInstance() {
        if (requestApi == null) {
            requestApi = new RequestApi();
        }
        return requestApi;
    }

    /**
     * Gets request specification.
     * @return request specification value.
     */
    public RequestSpecification getRequest() {
        return request;
    }

    /**
     * Gets response api.
     * @param httpMethod value.
     * @param endpoint value.
     * @return response api.
     */
    public Response apiResponse(final String httpMethod, final String endpoint) {
        return given().spec(request).when().request(httpMethod, endpoint);
    }

    /**
     * Gets api response.
     * @param endpoint value.
     * @return api response.
     */
    public Response get(final String endpoint) {
        return apiResponse("GET", endpoint);
    }

    public Response post(final String endpoint) {
        return apiResponse("POST", endpoint);
    }
}
