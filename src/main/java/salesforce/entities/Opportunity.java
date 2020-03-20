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
import salesforce.entities.constants.OpportunityConstant;
import salesforce.utils.DateFormatter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Manages opportunity information.
 *
 * @author Juan Martinez.
 * @version 1.0 19 March 2020.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"opportunityInformation", "currentOpportunityInformation"})
public class Opportunity {
    private String id;
    private String name;
    private String type;
    private String leadSource;
    private String amount;
    private String closeDate;
    private String stageName;
    private String probability;
    private String description;
    private String nextStep;
    private String statusCode;

    private Set<String> modifiedOpportunityFields = new HashSet<>();

    /**
     * Gets id value.
     * @return id value.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets name value.
     * @return name value.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets type value.
     * @return type value.
     */
    public String getType() {
        return type;
    }

    /**
     * Gets lead source value.
     * @return lead source value.
     */
    public String getLeadSource() {
        return leadSource;
    }

    /**
     * Gets amount value.
     * @return amount value.
     */
    public String getAmount() {
        return amount;
    }

    /**
     * Gets close date value.
     * @return close date value.
     */
    public String getCloseDate() {
        return closeDate;
    }

    /**
     * Gets stage name value.
     * @return stage name value.
     */
    public String getStageName() {
        return stageName;
    }

    /**
     * Gets probability value.
     * @return probability value.
     */
    public String getProbability() {
        return probability;
    }

    /**
     * Gets description value.
     * @return description value.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets next step value.
     * @return next step value.
     */
    public String getNextStep() {
        return nextStep;
    }

    /**
     * Gets status code value.
     * @return status code.
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * Sets is value.
     * @param id value.
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * Sets name value.
     * @param name value.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Sets type value.
     * @param type value.
     */
    public void setType(final String type) {
        this.type = type;
    }

    /**
     * Sets lead source value.
     * @param leadSource value.
     */
    public void setLeadSource(final String leadSource) {
        this.leadSource = leadSource;
    }

    /**
     * Sets amount value.
     * @param amount value.
     */
    public void setAmount(final String amount) {
        this.amount = amount;
    }

    /**
     * Sets close date value.
     * @param closeDate value.
     */
    public void setCloseDate(final String closeDate) {
        this.closeDate = closeDate;
    }

    /**
     * Sets stage name value.
     * @param stageName value.
     */
    public void setStageName(final String stageName) {
        this.stageName = stageName;
    }

    /**
     * Sets probability value.
     * @param probability value.
     */
    public void setProbability(final String probability) {
        this.probability = probability;
    }

    /**
     * Sets description value.
     * @param description value.
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * Sets next step value.
     * @param nextStep value.
     */
    public void setNextStep(final String nextStep) {
        this.nextStep = nextStep;
    }

    /**
     * Sets status code value.
     * @param statusCode value.
     */
    public void setStatusCode(final String statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * Sets opportunity information.
     *
     * @param opportunityInformation map.
     */
    public void setOpportunityInformation(final HashMap<String, String> opportunityInformation) {
        HashMap<String, String> currentOpportunityInformation = new HashMap<>(opportunityInformation);
        if (opportunityInformation.get(OpportunityConstant.CLOSE_DATE) != null) {
            currentOpportunityInformation.put(OpportunityConstant.CLOSE_DATE,
                DateFormatter.formatDate(opportunityInformation.get(OpportunityConstant.CLOSE_DATE)));
        }
        HashMap<String, Runnable> strategyMap = composeStrategyMap(currentOpportunityInformation);
        currentOpportunityInformation.keySet().forEach(key -> strategyMap.get(key).run());
        modifiedOpportunityFields.addAll(currentOpportunityInformation.keySet());
    }

    /**
     * Visits all setter methods of opportunity.
     *
     * @param opportunityInformation hasmap.
     * @return map of visited setter methods.
     */
    private HashMap<String, Runnable> composeStrategyMap(final HashMap<String, String> opportunityInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();

        strategyMap.put(OpportunityConstant.NAME, () -> setName(opportunityInformation.get(OpportunityConstant.NAME)));
        strategyMap.put(OpportunityConstant.TYPE, () -> setType(opportunityInformation.get(OpportunityConstant.TYPE)));
        strategyMap.put(OpportunityConstant.LEAD_SOURCE, () ->
                setLeadSource(opportunityInformation.get(OpportunityConstant.LEAD_SOURCE)));
        strategyMap.put(OpportunityConstant.AMOUNT, () ->
                setAmount(opportunityInformation.get(OpportunityConstant.AMOUNT)));
        strategyMap.put(OpportunityConstant.CLOSE_DATE, () ->
                setCloseDate(opportunityInformation.get(OpportunityConstant.CLOSE_DATE)));
        strategyMap.put(OpportunityConstant.STAGE_NAME, () ->
                setStageName(opportunityInformation.get(OpportunityConstant.STAGE_NAME)));
        strategyMap.put(OpportunityConstant.PROBABILITY, () ->
                setProbability(opportunityInformation.get(OpportunityConstant.PROBABILITY)));
        strategyMap.put(OpportunityConstant.DESCRIPTION, () ->
                setDescription(opportunityInformation.get(OpportunityConstant.DESCRIPTION)));
        strategyMap.put(OpportunityConstant.NEXT_STEP, () ->
                setNextStep(opportunityInformation.get(OpportunityConstant.NEXT_STEP)));
        return strategyMap;
    }

    /**
     * Gets opportunity information.
     *
     * @return opportunity values.
     */
    public HashMap<String, String> getOpportunityInformation() {
        HashMap<String, String> opportunityValues = new HashMap<>();
        HashMap<String, Supplier> strategyMap = composeStrategyMapGet();
        for (String field : modifiedOpportunityFields) {
            opportunityValues.put(field, strategyMap.get(field).get().toString());
        }
        return opportunityValues;
    }

    /**
     * Visits all getter methods of opportunity.
     *
     * @return map of visited get methods.
     */
    private HashMap<String, Supplier> composeStrategyMapGet() {
        HashMap<String, Supplier> strategyMap = new HashMap<>();
        strategyMap.put(OpportunityConstant.NAME, () -> getName());
        strategyMap.put(OpportunityConstant.TYPE, () -> getType());
        strategyMap.put(OpportunityConstant.LEAD_SOURCE, () -> getLeadSource());
        strategyMap.put(OpportunityConstant.AMOUNT, () -> getAmount());
        strategyMap.put(OpportunityConstant.CLOSE_DATE, () -> getCloseDate());
        strategyMap.put(OpportunityConstant.STAGE_NAME, () -> getStageName());
        strategyMap.put(OpportunityConstant.PROBABILITY, () -> getProbability());
        strategyMap.put(OpportunityConstant.DESCRIPTION, () -> getDescription());
        strategyMap.put(OpportunityConstant.NEXT_STEP, () -> getNextStep());
        return strategyMap;
    }
}
