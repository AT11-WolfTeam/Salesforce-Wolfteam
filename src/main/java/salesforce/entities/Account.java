/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import salesforce.entities.constants.AccountConstant;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Manages account information.
 *
 * @author Juan Martinez.
 * @version 1.0 17 March 2020.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"accountInformation"})
public class Account {
    private String id;
    private String name;
    private String description;
    private String statusCode;

    private Set<String> modifiedAccountFields = new HashSet<>();

    /**
     * Gets Id of account.
     *
     * @return id value.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets name value.
     *
     * @return name value.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets account description value.
     *
     * @return account description value.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets status code.
     *
     * @return status code value.
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * Sets account Id.
     *
     * @param id value.
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * Sets account name value.
     *
     * @param name value.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Sets account description value.
     *
     * @param description value.
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * Sets status code.
     *
     * @param statusCode value.
     */
    public void setStatusCode(final String statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * Sets account information.
     *
     * @param accountInformation map.
     */
    public void setAccountInformation(final HashMap<String, String> accountInformation) {
        HashMap<String, Runnable> strategyMap = composeStrategyMap(accountInformation);
        accountInformation.keySet().forEach(key -> strategyMap.get(key).run());
        modifiedAccountFields.addAll(accountInformation.keySet());
    }

    /**
     * Visits all setter methods of task list.
     *
     * @param accountInformation hasmap.
     * @return map of visited setter methods.
     */
    private HashMap<String, Runnable> composeStrategyMap(final HashMap<String, String> accountInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();

        strategyMap.put(AccountConstant.NAME, () -> setName(accountInformation.get(AccountConstant.NAME)));
        strategyMap.put(AccountConstant.DESCRIPTION, () ->
            setDescription(accountInformation.get(AccountConstant.DESCRIPTION)));
        return strategyMap;
    }

    /**
     * Gets account information.
     *
     * @return task list values.
     */
    public HashMap<String, String> getAccountInformation() {
        HashMap<String, String> accountValues = new HashMap<>();
        HashMap<String, Supplier> strategyMap = composeStrategyMapGet();
        for (String field : modifiedAccountFields) {
            accountValues.put(field, strategyMap.get(field).get().toString());
        }
        return accountValues;
    }

    /**
     * Visits all getter methods of task list.
     *
     * @return map of visited get methods.
     */
    private HashMap<String, Supplier> composeStrategyMapGet() {
        HashMap<String, Supplier> strategyMap = new HashMap<>();
        strategyMap.put(AccountConstant.NAME, () -> getName());
        strategyMap.put(AccountConstant.DESCRIPTION, () -> getDescription());
        return strategyMap;
    }
}
