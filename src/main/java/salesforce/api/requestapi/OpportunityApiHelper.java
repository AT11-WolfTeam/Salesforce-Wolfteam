/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.api.requestapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import salesforce.entities.Opportunity;
import salesforce.restclient.RestApi;
import salesforce.utils.EndPoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Manages opportunity information.
 *
 * @author Juan Martinez.
 * @version 1.0 20 March 2020.
 */
public class OpportunityApiHelper {
    private Opportunity opportunity;

    /**
     * Sets opportunities.
     *
     * @param opportunityMapList values.
     * @return opportunity list.
     */
    public ArrayList<Opportunity> setOpportunities(final ArrayList<HashMap<String, String>> opportunityMapList) {
        ArrayList<Opportunity> opportunitiesList = new ArrayList<>();
        for (HashMap<String, String> opportunityItem : opportunityMapList) {
            opportunity = new Opportunity();
            opportunity.setOpportunityInformation(opportunityItem);
            opportunitiesList.add(opportunity);
        }
        return opportunitiesList;
    }

    /**
     * Creates opportunities.
     *
     * @param opportunities list.
     */
    public void postOpportunities(final List<Opportunity> opportunities) {
        for (Opportunity opportunity : opportunities) {
            try {
                String json = new ObjectMapper().writeValueAsString(opportunity);
                Response response = RestApi.postEntity(json, EndPoint.OPPORTUNITY_ENDPOINT);
                JsonPath jsonPath = response.jsonPath();
                String id = jsonPath.get("id");
                opportunity.setId(id);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Deletes opportunities.
     *
     * @param opportunityList value.
     */
    public void deleteOpportunities(final List<Opportunity> opportunityList) {
        for (Opportunity opportunity : opportunityList) {
            Response response = RestApi.deleteEntity(opportunity.getId(), EndPoint.OPPORTUNITY_ENDPOINT);
            int statusCode = response.getStatusCode();
            opportunity.setStatusCode(Integer.toString(statusCode));
        }
    }
}
