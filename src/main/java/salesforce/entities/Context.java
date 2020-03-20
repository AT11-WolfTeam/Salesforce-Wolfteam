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
 * Manages salesforce.entities instance.
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
     *
     * @return account instance.
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Gets account list.
     *
     * @return list.
     */
    public List<Account> getAccounts() {
        return accounts;
    }

    /**
     * Sets an account to account list.
     *
     * @param account object.
     */
    public void setAccount(final Account account) {
        this.accounts.add(account);
    }

    /**
     * Sets an account list.
     *
     * @param accountList object.
     */
    public void setAccounts(final ArrayList<Account> accountList) {
        this.accounts.addAll(accountList);
    }
}
