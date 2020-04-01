/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunity.newopportunity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import salesforce.entities.Opportunity;
import salesforce.entities.constants.OpportunityConstant;
import salesforce.ui.pages.AbstractBasePage;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.opportunity.AbstractOpportunityPage;
import java.util.HashMap;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Manages new opportunity.
 *
 * @author Juan Martinez.
 * * @version 1.0 29 March 2020.
 */
public abstract class AbstractNewOpportunity extends AbstractBasePage {
    private HashMap<String, String> newOpportunityInformation;

    /**
     * Gets composed web element.
     *
     * @param xpath      value.
     * @param concatText value.
     * @return web element.
     */
    public WebElement getWebElement(final String xpath, final String concatText) {
        return webDriver.findElement(By.xpath(String.format(xpath, concatText)));
    }

    /**
     * Sets opportunity name.
     *
     * @param opportunityName value.
     */
    public abstract void setOpportunityName(String opportunityName);

    /**
     * Sets account name value.
     *
     * @param accountName value.
     */
    public abstract void setAccountNameTextBox(String accountName);

    /**
     * Selects type value.
     *
     * @param typeName value.
     */
    public abstract void selectTypeCombobox(String typeName);

    /**
     * Selects lead value.
     *
     * @param leadName value.
     */
    public abstract void selectLeadSourceCombobox(String leadName);

    /**
     * Sets amount value.
     *
     * @param amountValue value.
     */
    public abstract void setAmountTextBox(String amountValue);

    /**
     * Sets close date value.
     *
     * @param dateValue string.
     */
    public abstract void setCloseDateCalendar(String dateValue);

    /**
     * Sets next step value.
     *
     * @param nextStep string.
     */
    public abstract void setNextStepTextBox(String nextStep);

    /**
     * Selects stage value.
     *
     * @param stageName value.
     */
    public abstract void selectStageCombobox(String stageName);

    /**
     * Sets probability value.
     *
     * @param probabilityName string.
     */
    public abstract void setProbabilityTextBox(String probabilityName);

    /**
     * Selects campaign value.
     *
     * @param campaignName value.
     */
    public abstract void selectCampaignItem(String campaignName);

    /**
     * Sets order number value.
     *
     * @param orderNumber string.
     */
    public abstract void setOrderNumberTextBox(String orderNumber);

    /**
     * Sets current generator value.
     *
     * @param currentGenerator string.
     */
    public abstract void setCurrentGeneratorTextBox(String currentGenerator);

    /**
     * Sets tracking number value.
     *
     * @param trackingNumber string.
     */
    public abstract void setTrackingNumberTextBox(String trackingNumber);

    /**
     * Sets main competitors value.
     *
     * @param mainCompetitor string.
     */
    public abstract void setMainCompetitorTextBox(String mainCompetitor);

    /**
     * Selects delivery status value.
     *
     * @param deliveryStatus value.
     */
    public abstract void selectDeliveryStatus(String deliveryStatus);

    /**
     * Sets description value.
     *
     * @param description string.
     */
    public abstract void setDescriptionTextarea(String description);

    /**
     * Clicks on save button to create the opportunity.
     */
    public abstract void clickOnSaveButton();

    /**
     * Clicks on cancel button to create the opportunity.
     */
    public abstract void clickOnCancelButton();

    /**
     * Gets opportunity name.
     *
     * @return opportunity name value.
     */
    public abstract String getOpportunityName();

    /**
     * Gets account name.
     *
     * @return account name value.
     */
    public abstract String geAccountName();

    /**
     * Gets type.
     *
     * @return type value.
     */
    public abstract String getType();

    /**
     * Gets lead.
     *
     * @return lead value.
     */
    public abstract String getLead();

    /**
     * Gets amount.
     *
     * @return amount value.
     */
    public abstract String getAmount();

    /**
     * Gets close date.
     *
     * @return close data value.
     */
    public abstract String getCloseDate();

    /**
     * Gets next step value.
     *
     * @return next step.
     */
    public abstract String getNextStep();

    /**
     * Gets stage.
     *
     * @return stage value.
     */
    public abstract String getStage();

    /**
     * Gets probability.
     *
     * @return probability value.
     */
    public abstract String getProbability();

    /**
     * Gets campaign value.
     *
     * @return campaign name;
     */
    public abstract String getCampaign();

    /**
     * Gets order number value.
     *
     * @return order number;
     */
    public abstract String getOrderNumber();

    /**
     * Gets current generator value.
     *
     * @return generator value.
     */
    public abstract String getCurrentGenerator();

    /**
     * Gets tracking number.
     *
     * @return tracking number value.
     */
    public abstract String getTrackingNumber();

    /**
     * Gets main competitor value.
     *
     * @return main competitor text.
     */
    public abstract String getMainCompetitor();

    /**
     * Gets delivery status value.
     *
     * @return status text.
     */
    public abstract String getDeliveryStatus();

    /**
     * Gets description value.
     *
     * @return description text.
     */
    public abstract String getDescription();

    /**
     * Adds opportunity values.
     *
     * @param opportunity object.
     * @param fields list.
     * @return a new instance of opportunity page.
     */
    public AbstractOpportunityPage setOpportunityInformation(final Opportunity opportunity, final Set<String> fields) {
        HashMap<String, Runnable> strategyMap = composeStrategyMap(opportunity);
        fields.forEach(field -> strategyMap.get(field).run());
        clickOnSaveButton();
        return AppPageFactory.getOpportunityPage();
    }

    /**
     * Composes a strategy map of visited opportunity methods.
     *
     * @param opportunity object.
     * @return a map.
     */
    private HashMap<String, Runnable> composeStrategyMap(final Opportunity opportunity) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();

        strategyMap.put(OpportunityConstant.NAME, () -> setOpportunityName(opportunity.getName()));
        strategyMap.put(OpportunityConstant.ACCOUNT_NAME, () ->
                setAccountNameTextBox(opportunity.getAccountName()));
        strategyMap.put(OpportunityConstant.TYPE, () -> selectTypeCombobox(opportunity.getType()));
        strategyMap.put(OpportunityConstant.LEAD_SOURCE, () -> selectLeadSourceCombobox(opportunity.getLeadSource()));
        strategyMap.put(OpportunityConstant.AMOUNT, () -> setAmountTextBox(opportunity.getAmount()));
        strategyMap.put(OpportunityConstant.CLOSE_DATE, () -> setCloseDateCalendar(opportunity.getCloseDate()));
        strategyMap.put(OpportunityConstant.STAGE_NAME, () -> selectStageCombobox(opportunity.getStageName()));
        strategyMap.put(OpportunityConstant.PROBABILITY, () -> setProbabilityTextBox(opportunity.getProbability()));
        strategyMap.put(OpportunityConstant.PRIMARY_CAMPAIGN_SOURCE, () ->
                selectCampaignItem(opportunity.getPrimaryCampaignSource()));
        strategyMap.put(OpportunityConstant.DESCRIPTION, () -> setDescriptionTextarea(opportunity.getDescription()));
        strategyMap.put(OpportunityConstant.NEXT_STEP, () -> setNextStepTextBox(opportunity.getNextStep()));
        strategyMap.put(OpportunityConstant.ORDER_NUMBER, () -> setOrderNumberTextBox(opportunity.getOrderNumber()));
        strategyMap.put(OpportunityConstant.CURRENT_GENERATOR, () ->
                setCurrentGeneratorTextBox(opportunity.getCurrentGenerator()));
        strategyMap.put(OpportunityConstant.TRACKING_NUMBER, () ->
                setTrackingNumberTextBox(opportunity.getTrackingNumber()));
        strategyMap.put(OpportunityConstant.MAIN_COMPETITOR, () ->
                setMainCompetitorTextBox(opportunity.getMainCompetitor()));
        strategyMap.put(OpportunityConstant.DELIVERY_STATUS, () ->
                selectDeliveryStatus(opportunity.getDeliveryStatus()));
        return strategyMap;
    }

    /**
     * Gets opportunity information.
     *
     * @param opportunityInformation map.
     * @return map of opportunity information.
     */
    public HashMap<String, String> getOpportunityInformation(final HashMap<String, String> opportunityInformation) {
        newOpportunityInformation = new HashMap<>();
        HashMap<String, Supplier> strategyMapGet = composeStrategyMapGet();

        for (String field : opportunityInformation.keySet()) {
            newOpportunityInformation.put(field, strategyMapGet.get(field).get().toString());
        }
        clickOnCancelButton();
        return newOpportunityInformation;
    }

    /**
     * Visits get methods of opportunity.
     *
     * @return a map of visits.
     */
    private HashMap<String, Supplier> composeStrategyMapGet() {
        HashMap<String, Supplier> strategyMapGet = new HashMap<>();
        strategyMapGet.put(OpportunityConstant.NAME, () -> getOpportunityName());
        strategyMapGet.put(OpportunityConstant.ACCOUNT_NAME, () -> geAccountName());
        strategyMapGet.put(OpportunityConstant.TYPE, () -> getType());
        strategyMapGet.put(OpportunityConstant.LEAD_SOURCE, () -> getLead());
        strategyMapGet.put(OpportunityConstant.AMOUNT, () -> getAmount());
        strategyMapGet.put(OpportunityConstant.CLOSE_DATE, () -> getCloseDate());
        strategyMapGet.put(OpportunityConstant.STAGE_NAME, () -> getStage());
        strategyMapGet.put(OpportunityConstant.PROBABILITY, () -> getProbability());
        strategyMapGet.put(OpportunityConstant.PRIMARY_CAMPAIGN_SOURCE, () -> getCampaign());
        strategyMapGet.put(OpportunityConstant.DESCRIPTION, () -> getDescription());
        strategyMapGet.put(OpportunityConstant.NEXT_STEP, () -> getNextStep());
        strategyMapGet.put(OpportunityConstant.ORDER_NUMBER, () -> getOrderNumber());
        strategyMapGet.put(OpportunityConstant.CURRENT_GENERATOR, () -> getCurrentGenerator());
        strategyMapGet.put(OpportunityConstant.TRACKING_NUMBER, () -> getTrackingNumber());
        strategyMapGet.put(OpportunityConstant.MAIN_COMPETITOR, () -> getMainCompetitor());
        strategyMapGet.put(OpportunityConstant.DELIVERY_STATUS, () -> getDeliveryStatus());
        return strategyMapGet;
    }
}
