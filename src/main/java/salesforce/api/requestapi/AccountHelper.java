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
import salesforce.entities.Account;
import salesforce.restclient.RestApi;
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
    private Account account;

    /**
     * Sets accounts.
     *
     * @param accountMapList values.
     * @return account list.
     */
    public ArrayList<Account> setAccounts(final ArrayList<HashMap<String, String>> accountMapList) {
        ArrayList<Account> accountsList = new ArrayList<>();
        for (HashMap<String, String> accountItem : accountMapList) {
            account = new Account();
            account.setAccountInformation(accountItem);
            accountsList.add(account);
        }
        return accountsList;
    }

    /**
     * Creates account.
     *
     * @param accounts list.
     */
    public void postAccounts(final List<Account> accounts) {
        for (Account account : accounts) {
            try {
                String json = new ObjectMapper().writeValueAsString(account);
                Response response = RestApi.postEntity(json, EndPoint.ACCOUNT_ENDPOINT);
                JsonPath jsonPath = response.jsonPath();
                String id = jsonPath.get("id");
                account.setId(id);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Deletes accounts.
     *
     * @param accountList value.
     */
    public void deleteAccounts(final List<Account> accountList) {
        for (Account account : accountList) {
            Response response = RestApi.deleteEntity(account.getId(), EndPoint.ACCOUNT_ENDPOINT);
            int statusCode = response.getStatusCode();
            account.setStatusCode(Integer.toString(statusCode));
        }
    }
}
