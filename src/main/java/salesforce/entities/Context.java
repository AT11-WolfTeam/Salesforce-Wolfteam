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
    private Lead lead;
    private List<Account> accounts;
    private List<Opportunity> opportunities;
    private List<Lead> leads;
    private NewCampaign newCampaign;
    private List<Contact> contacts;
    private TaskOpportunity taskOpportunity;
    private Contract contract;
    private Product product;
    private PriceBook priceBook;

    /**
     * Context constructor.
     */
    public Context() {
        this.account = new Account();
        this.opportunity = new Opportunity();
        this.lead = new Lead();
        this.accounts = new ArrayList<>();
        this.opportunities = new ArrayList<>();
        this.leads = new ArrayList<>();
        this.newCampaign = new NewCampaign();
        this.contacts = new ArrayList<>();
        this.taskOpportunity = new TaskOpportunity();
        this.contract = new Contract();
        this.product = new Product();
        this.priceBook = new PriceBook();
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
     * @param opportunities list value.
     */
    public void setOpportunities(final List<Opportunity> opportunities) {
        this.opportunities = opportunities;
    }

    /**
     * Returns new campaign instance.
     *
     * @return NewCampaign object.
     */
    public NewCampaign getNewCampaign() {
        return newCampaign;
    }

    /**
     * Returns opportunity instance.
     *
     * @return opportunity object.
     */
    public Opportunity getOpportunity() {
        return opportunity;
    }

    /**
     * Gets contacts.
     *
     * @return a list of contacts.
     */
    public List<Contact> getContacts() {
        return contacts;
    }

    /**
     * Sets a list of contacts.
     *
     * @param contacts list value.
     */
    public void setContacts(final List<Contact> contacts) {
        this.contacts = contacts;
    }

    /**
     * Gets an object instance.
     *
     * @return an instance.
     */
    public Lead getLead() {
        return lead;
    }

    /**
     * Sets an object instance.
     *
     * @param lead contains an instance.
     */
    public void setLead(final Lead lead) {
        this.lead = lead;
    }

    /**
     * Gets a list of leads.
     *
     * @return a list value.
     */
    public List<Lead> getLeads() {
        return leads;
    }

    /**
     * Sets a list of leads.
     *
     * @param leads contains a list value.
     */
    public void setLeads(final List<Lead> leads) {
        this.leads = leads;
    }

    /**
     * Gets TaskOpportunity.
     *
     * @return taskOpportunity instance.
     */
    public TaskOpportunity getTaskOpportunity() {
        return taskOpportunity;
    }

    /**
     * Gets Contract.
     *
     * @return contract instance.
     */
    public Contract getContract() {
        return contract;
    }

    /**
     * Gets product instance.
     * @return an instance.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets product instance.
     * @param product object.
     */
    public void setProduct(final Product product) {
        this.product = product;
    }

    /**
     * Gets PriceBook instance.
     * @return an instance.
     */
    public PriceBook getPriceBook() {
        return priceBook;
    }

}
