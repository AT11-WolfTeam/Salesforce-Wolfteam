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
 * Manages salesforce.entities instance.
 *
 * @author Juan Martinez.
 * @version 1.0 17 March 2020.
 */
public class Context {
    private Account account;
    private Opportunity opportunity;
    private List<Account> accounts;
    private List<Opportunity> opportunities;

    /**
     * Context constructor.
     */
    public Context() {
        this.account = new Account();
        this.opportunity = new Opportunity();
        this.accounts = new ArrayList<>();
        this.opportunities = new ArrayList<>();
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
     * Sets an account list.
     *
     * @param accountList object.
     */
    public void setAccounts(final ArrayList<Account> accountList) {
        this.accounts.addAll(accountList);
    }

    /**
     * gets list of opportunities.
     *
     * @return list of opportunities.
     */
    public List<Opportunity> getOpportunities() {
        return opportunities;
    }

    /**
     * Sets a list of opportunities.
     *
     * @param opportunities list value..
     */
    public void setOpportunities(final List<Opportunity> opportunities) {
        this.opportunities = opportunities;
    }
}
