/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.restclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import salesforce.api.AccountApi;
import salesforce.entities.Account;

import java.util.HashMap;
import java.util.List;

/**
 * Manages account information.
 *
 * @author Juan Martinez.
 * @version 1.0 17 March 2020.
 */
public class AccountHelper {

    /**
     * Creates account.
     * @param accounts list.
     */
    public void convertToJson(final List<Account> accounts) {
        HashMap<String, String> entities = new HashMap<>();
        for (Account account: accounts) {
            try {
                String json = new ObjectMapper().writeValueAsString(account);

                Response response = AccountApi.postEntity(json);

                JsonPath jsonPath = response.jsonPath();
                String id = jsonPath.get("id");
                entities.put(id, account.getName());
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Deletes account.
     * @param account value.
     */
    public void deleteAccount(final Account account) {

    }
}
