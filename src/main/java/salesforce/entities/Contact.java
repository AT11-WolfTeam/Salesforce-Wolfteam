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
import salesforce.entities.constants.ContactConstant;
import salesforce.utils.DateFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Manages contact information.
 *
 * @author Juan Martinez.
 * @version 1.0 20 March 2020.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"contactInformation", "currentContactInformation"})
public class Contact {
    private String id;
    private String firstName;
    private String lastName;
    private String salutation;
    private String title;
    private String department;
    private String birthdate;
    private String leadSource;
    private String phone;
    private String homePhone;
    private String mobilePhone;
    private String email;
    private String assistantName;
    private String description;
    private String statusCode;

    private Set<String> modifiedContactFields = new HashSet<>();

    /**
     * Gets id value.
     * @return id value.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets first name value.
     * @return first name value.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets last name value.
     * @return last name value.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets salutation value.
     * @return salutation value.
     */
    public String getSalutation() {
        return salutation;
    }

    /**
     * Gets title value.
     * @return title value.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets department value.
     * @return department value.
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Gets birth date value.
     * @return birth date value.
     */
    public String getBirthdate() {
        return birthdate;
    }

    /**
     * Gets lead source value.
     * @return lead source value.
     */
    public String getLeadSource() {
        return leadSource;
    }

    /**
     * Gets phone value.
     * @return phone value.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Gets home phone value.
     * @return home phone value.
     */
    public String getHomePhone() {
        return homePhone;
    }

    /**
     * Gets mobile phone value.
     * @return mobile phone value.
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * Gets email value.
     * @return email value.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets assistant name.
     * @return assistant name.
     */
    public String getAssistantName() {
        return assistantName;
    }

    /**
     * Gets description value.
     * @return description value.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets status code value.
     * @return status code value.
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * Sets id data.
     * @param id value.
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * Sets first name data.
     * @param firstName value.
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets last name data.
     * @param lastName value.
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets salutation data.
     * @param salutation value.
     */
    public void setSalutation(final String salutation) {
        this.salutation = salutation;
    }

    /**
     * Sets title data.
     * @param title value.
     */
    public void setTitle(final String title) {
        this.title = title;
    }

    /**
     * Sets department data.
     * @param department value.
     */
    public void setDepartment(final String department) {
        this.department = department;
    }

    /**
     * Sets birth date data.
     * @param birthdate value.
     */
    public void setBirthdate(final String birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * Sets lead source data.
     * @param leadSource value.
     */
    public void setLeadSource(final String leadSource) {
        this.leadSource = leadSource;
    }

    /**
     * Sets phone data.
     * @param phone value.
     */
    public void setPhone(final String phone) {
        this.phone = phone;
    }

    /**
     * Sets home phone data.
     * @param homePhone value.
     */
    public void setHomePhone(final String homePhone) {
        this.homePhone = homePhone;
    }

    /**
     * Sets mobile phone data.
     * @param mobilePhone value.
     */
    public void setMobilePhone(final String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     * Sets email data.
     * @param email value.
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * Sets assistant name data.
     * @param assistantName value.
     */
    public void setAssistantName(final String assistantName) {
        this.assistantName = assistantName;
    }

    /**
     * Sets description data.
     * @param description value.
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * Sets status code data.
     * @param statusCode value.
     */
    public void setStatusCode(final String statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * Sets contact information.
     *
     * @param contactInformation hashmap.
     */
    public void setContactInformation(final HashMap<String, String> contactInformation) {
        HashMap<String, String> currentContactInformation = new HashMap<>(contactInformation);
        if (contactInformation.get(ContactConstant.BIRTH_DATE) != null) {
            currentContactInformation.put(ContactConstant.BIRTH_DATE,
                 DateFormatter.formatDate(contactInformation.get(ContactConstant.BIRTH_DATE)));
        }
        HashMap<String, Runnable> strategyMap = composeStrategyMap(currentContactInformation);
        currentContactInformation.keySet().forEach(key -> strategyMap.get(key).run());
        modifiedContactFields.addAll(currentContactInformation.keySet());
    }

    /**
     * Visits all setter methods of contact.
     *
     * @param contactInformation hashmap.
     * @return map of visited setter methods.
     */
    private HashMap<String, Runnable> composeStrategyMap(final HashMap<String, String> contactInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();

        strategyMap.put(ContactConstant.FIRST_NAME, () ->
                setFirstName(contactInformation.get(ContactConstant.FIRST_NAME)));
        strategyMap.put(ContactConstant.LAST_NAME, () ->
                setLastName(contactInformation.get(ContactConstant.LAST_NAME)));
        strategyMap.put(ContactConstant.SALUTATION, () ->
                setSalutation(contactInformation.get(ContactConstant.SALUTATION)));
        strategyMap.put(ContactConstant.TITLE, () ->
                setTitle(contactInformation.get(ContactConstant.TITLE)));
        strategyMap.put(ContactConstant.DEPARTMENT, () ->
                setDepartment(contactInformation.get(ContactConstant.DEPARTMENT)));
        strategyMap.put(ContactConstant.BIRTH_DATE, () ->
                setBirthdate(contactInformation.get(ContactConstant.BIRTH_DATE)));
        strategyMap.put(ContactConstant.LEAD_SOURCE, () ->
                setLeadSource(contactInformation.get(ContactConstant.LEAD_SOURCE)));
        strategyMap.put(ContactConstant.PHONE, () ->
                setPhone(contactInformation.get(ContactConstant.PHONE)));
        strategyMap.put(ContactConstant.HOME_PHONE, () ->
                setHomePhone(contactInformation.get(ContactConstant.HOME_PHONE)));
        strategyMap.put(ContactConstant.MOBILE_PHONE, () ->
                setMobilePhone(contactInformation.get(ContactConstant.MOBILE_PHONE)));
        strategyMap.put(ContactConstant.EMAIL, () ->
                setEmail(contactInformation.get(ContactConstant.EMAIL)));
        strategyMap.put(ContactConstant.ASSISTANT_NAME, () ->
                setAssistantName(contactInformation.get(ContactConstant.ASSISTANT_NAME)));
        strategyMap.put(ContactConstant.DESCRIPTION, () ->
                setDescription(contactInformation.get(ContactConstant.DESCRIPTION)));
        return strategyMap;
    }

    /**
     * Gets contact information.
     *
     * @return contact values.
     */
    public HashMap<String, String> getContactInformation() {
        HashMap<String, String> contactValues = new HashMap<>();
        HashMap<String, Supplier> strategyMap = composeStrategyMapGet();
        for (String field : modifiedContactFields) {
            contactValues.put(field, strategyMap.get(field).get().toString());
        }
        return contactValues;
    }

    /**
     * Visits all getter methods of contact.
     *
     * @return map of visited get methods.
     */
    private HashMap<String, Supplier> composeStrategyMapGet() {
        HashMap<String, Supplier> strategyMap = new HashMap<>();
        strategyMap.put(ContactConstant.FIRST_NAME, () -> getFirstName());
        strategyMap.put(ContactConstant.LAST_NAME, () -> getLastName());
        strategyMap.put(ContactConstant.SALUTATION, () -> getSalutation());
        strategyMap.put(ContactConstant.TITLE, () -> getTitle());
        strategyMap.put(ContactConstant.DEPARTMENT, () -> getDepartment());
        strategyMap.put(ContactConstant.BIRTH_DATE, () -> getBirthdate());
        strategyMap.put(ContactConstant.LEAD_SOURCE, () -> getLeadSource());
        strategyMap.put(ContactConstant.PHONE, () -> getPhone());
        strategyMap.put(ContactConstant.HOME_PHONE, () -> getHomePhone());
        strategyMap.put(ContactConstant.MOBILE_PHONE, () -> getMobilePhone());
        strategyMap.put(ContactConstant.EMAIL, () -> getEmail());
        strategyMap.put(ContactConstant.ASSISTANT_NAME, () -> getAssistantName());
        strategyMap.put(ContactConstant.DESCRIPTION, () -> getDescription());
        return strategyMap;
    }
}
