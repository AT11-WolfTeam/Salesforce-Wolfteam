/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.entities;

/**
 * Manages Lead information.
 *
 * @author Alan Escalera.
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
    public void setName(String name) {
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
    public void setSalutation(String salutation) {
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
    public void setFirstName(String firstName) {
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
    public void setLastName(String lastName) {
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
    public void setCompany(String company) {
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
    public void setTitle(String title) {
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
    public void setLeadSource(String leadSource) {
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
    public void setIndustry(String industry) {
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
    public void setPhone(String phone) {
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
    public void setMobile(String mobile) {
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
    public void setLeadStatus(String leadStatus) {
        this.leadStatus = leadStatus;
    }
}
