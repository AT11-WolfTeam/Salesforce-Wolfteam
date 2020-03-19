/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import salesforce.restclient.RestApi;
import salesforce.entities.Account;
import salesforce.entities.Context;
import salesforce.utils.EndPoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Manages account information.
 *
 * @author Juan Martinez.
 * @version 1.0 17 March 2020.
 */
public class AccountHelper {
    private Context context;
    private Account account;

    /**
     * Helps to manage account information to send request.
     * @param context object.
     */
    public AccountHelper(final Context context) {
        this.context = context;
    }

    /**
     * Creates entities.
     * @param accountMapList value.
     */
    public void createEntity(final ArrayList<HashMap<String, String>> accountMapList) {
        for (HashMap<String, String> accountItem: accountMapList) {
            account = new Account();
            account.setAccountInformation(accountItem);
            context.setAccount(account);
        }
        convertEntityToJson(context.getAccounts());
    }

    /**
     * Creates account.
     * @param accounts list.
     */
    public void convertEntityToJson(final List<Account> accounts) {
        HashMap<String, String> entityIds = new HashMap<>();
        for (Account account: accounts) {
            try {
                String json = new ObjectMapper().writeValueAsString(account);
                Response response = RestApi.postEntity(json, EndPoint.ACCOUNT_ENDPOINT);

                JsonPath jsonPath = response.jsonPath();
                String id = jsonPath.get("id");
                entityIds.put(id, account.getName());
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        context.setIdsMap(entityIds);
    }

    /**
     * Deletes account.
     * @param accountList value.
     */
    public void deleteAccount(final HashMap<String, String> accountList) {
        HashMap<String, Integer> entityResponse = new HashMap<>();
        for (String accountId: accountList.keySet()) {

            Response response = RestApi.deleteEntity(accountId, EndPoint.ACCOUNT_ENDPOINT);
            int statusCode = response.getStatusCode();
            entityResponse.put(accountId, statusCode);
        }
        context.setDeleteEntity(entityResponse);
    }
}
