/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Manages entities instance.
 *
 * @author Juan Martinez.
 * @version 1.0 17 March 2020.
 */
public class Context {
    private Account account;
    private List<Account> accounts;

    private HashMap<String, String> idsMap;
    private HashMap<String, Integer> deleteEntity;

    /**
     * Context constructor.
     */
    public Context() {
        this.account = new Account();
        this.accounts = new ArrayList<>();
    }

    /**
     * Gets account instance.
     * @return
     */
    public Account getAccount() {
        return account;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccount(Account account) {
        this.accounts.add(account);
    }

    /**
     * Gets created entities ids.
     * @return map ids.
     */
    public HashMap<String, String> getIdsMap() {
        return idsMap;
    }

    /**
     * Sets created entities ids.
     * @param idsMap value.
     */
    public void setIdsMap(HashMap<String, String> idsMap) {
        this.idsMap = idsMap;
    }

    /**
     * Gets deleted entities.
     * @return deleted entities map.
     */
    public HashMap<String, Integer> getDeleteEntity() {
        return deleteEntity;
    }

    /**
     * Sets deleted entities.
     * @param deleteEntity values.
     */
    public void setDeleteEntity(HashMap<String, Integer> deleteEntity) {
        this.deleteEntity = deleteEntity;
    }
}
