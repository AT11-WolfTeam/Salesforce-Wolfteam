/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.entities;

import salesforce.entities.constants.LeadConstant;
import java.util.HashMap;
import java.util.Map;

/**
 * Manages Lead information.
 *
 * @author Enrique Carrizales.
 * @version 1.0 24 March 2020.
 */
public class Lead {
    private String name;
    private String salutation;
    private String firstName;
    private String lastName;
    private String company;
    private String title;
    private String leadSource;
    private String industry;
    private String phone;
    private String mobile;
    private String leadStatus;

    /**
     * Visits all getter methods of lead.
     *
     * @param leadAttributes contains a map value.
     * @return map of visited get methods.
     */
    private HashMap<String, Runnable> composeStrategyMap(final Map<String, String> leadAttributes) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(LeadConstant.FIRST_NAME, () -> setName(leadAttributes.get(LeadConstant.FIRST_NAME)));
        strategyMap.put(LeadConstant.LAST_NAME, () -> setLastName(leadAttributes.get(LeadConstant.LAST_NAME)));
        strategyMap.put(LeadConstant.COMPANY, () -> setCompany(leadAttributes.get(LeadConstant.COMPANY)));
        strategyMap.put(LeadConstant.LEAD_STATUS, () -> setLeadStatus(leadAttributes.get(LeadConstant.LEAD_STATUS)));
        return strategyMap;
    }

    /**
     * Gets lead information.
     *
     * @param leadAttributes contains a list value.
     */
    public void setLeadInformation(final Map<String, String> leadAttributes) {
        HashMap<String, Runnable> strategyMap = composeStrategyMap(leadAttributes);
        leadAttributes.keySet().forEach(key -> strategyMap.get(key).run());
    }

    /**
     * Gets Name.
     *
     * @return String value.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name String value.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets Salutation.
     *
     * @return String value.
     */
    public String getSalutation() {
        return salutation;
    }

    /**
     * Sets Salutation.
     *
     * @param salutation String value.
     */
    public void setSalutation(final String salutation) {
        this.salutation = salutation;
    }

    /**
     * Gets FirstName.
     *
     * @return String value.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets FirstName.
     *
     * @param firstName String value.
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets LastName.
     *
     * @return String value.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets LastName.
     *
     * @param lastName String value.
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets Company.
     *
     * @return String value.
     */
    public String getCompany() {
        return company;
    }

    /**
     * Sets Company.
     *
     * @param company String value.
     */
    public void setCompany(final String company) {
        this.company = company;
    }

    /**
     * Gets Title.
     *
     * @return String value.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets Title.
     *
     * @param title String value.
     */
    public void setTitle(final String title) {
        this.title = title;
    }

    /**
     * Gets LeadSource.
     *
     * @return String value.
     */
    public String getLeadSource() {
        return leadSource;
    }

    /**
     * Sets LeadSource.
     *
     * @param leadSource String value.
     */
    public void setLeadSource(final String leadSource) {
        this.leadSource = leadSource;
    }

    /**
     * Gets Industry.
     *
     * @return String value.
     */
    public String getIndustry() {
        return industry;
    }

    /**
     * Sets Industry.
     *
     * @param industry String value.
     */
    public void setIndustry(final String industry) {
        this.industry = industry;
    }

    /**
     * Gets Phone.
     *
     * @return String value.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets Phone.
     *
     * @param phone String value.
     */
    public void setPhone(final String phone) {
        this.phone = phone;
    }

    /**
     * Gets Mobile.
     *
     * @return String value.
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Sets Mobile.
     *
     * @param mobile String value.
     */
    public void setMobile(final String mobile) {
        this.mobile = mobile;
    }

    /**
     * Gets LeadStatus.
     *
     * @return String value.
     */
    public String getLeadStatus() {
        return leadStatus;
    }

    /**
     * Sets LeadStatus.
     *
     * @param leadStatus String value.
     */
    public void setLeadStatus(final String leadStatus) {
        this.leadStatus = leadStatus;
    }
}
