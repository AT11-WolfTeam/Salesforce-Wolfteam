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
}
