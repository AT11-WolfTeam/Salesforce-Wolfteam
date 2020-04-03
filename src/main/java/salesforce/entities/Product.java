/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.entities;

import salesforce.entities.constants.ProductConstant;
import salesforce.utils.DateFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Manages product instance.
 *
 * @author Juan Martinez.
 * * @version 1.0 01 April 2020.
 */
public class Product {
    private String name;
    private String code;
    private String description;
    private String listPrice;
    private String quantity;
    private String date;

    private Set<String> modifiedProductFields = new HashSet<>();

    /**
     * Gets product name.
     *
     * @return name value.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets product code.
     *
     * @return code value.
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets product description.
     *
     * @return decription value.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets product list price.
     *
     * @return list price value.
     */
    public String getListPrice() {
        return listPrice;
    }

    /**
     * Gets product quantity.
     *
     * @return quantity value.
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * Gets expiration date.
     *
     * @return date value.
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets product name.
     *
     * @param name value.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Sets product code.
     *
     * @param code value.
     */
    public void setCode(final String code) {
        this.code = code;
    }

    /**
     * Sets product description.
     *
     * @param description value.
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * Sets product list price.
     *
     * @param listPrice value.
     */
    public void setListPrice(final String listPrice) {
        this.listPrice = listPrice;
    }

    /**
     * Sets product quantity.
     *
     * @param quantity value.
     */
    public void setQuantity(final String quantity) {
        this.quantity = quantity;
    }

    /**
     * Sets product expiration date.
     *
     * @param date value.
     */
    public void setDate(final String date) {
        this.date = DateFormatter.formatDate(date);
    }

    /**
     * Sets products information.
     *
     * @param productInformation values.
     */
    public void setProductInformation(final Map<String, String> productInformation) {
        HashMap<String, Runnable> strategyMap = composeStrategyMap(productInformation);
        productInformation.keySet().forEach(key -> strategyMap.get(key).run());
        modifiedProductFields.addAll(productInformation.keySet());
    }

    /**
     * Registers visits of all setter methods of product.
     *
     * @param productInformation map.
     * @return map of visited setter methods.
     */
    private HashMap<String, Runnable> composeStrategyMap(final Map<String, String> productInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();

        strategyMap.put(ProductConstant.NAME, () -> setName(productInformation.get(ProductConstant.NAME)));
        strategyMap.put(ProductConstant.CODE, () -> setCode(productInformation.get(ProductConstant.CODE)));
        strategyMap.put(ProductConstant.DESCRIPTION, () ->
                setDescription(productInformation.get(ProductConstant.DESCRIPTION)));
        strategyMap.put(ProductConstant.LIST_PRICE, () ->
                setListPrice(productInformation.get(ProductConstant.LIST_PRICE)));
        strategyMap.put(ProductConstant.QUANTITY, () -> setQuantity(productInformation.get(ProductConstant.QUANTITY)));
        strategyMap.put(ProductConstant.DATE, () -> setDate(productInformation.get(ProductConstant.DATE)));
        return strategyMap;
    }

    /**
     * Gets product information.
     *
     * @return product values.
     */
    public HashMap<String, String> getProductInformation() {
        HashMap<String, String> productValues = new HashMap<>();
        HashMap<String, Supplier> strategyMap = composeStrategyMapGet();
        for (String field : modifiedProductFields) {
            productValues.put(field, strategyMap.get(field).get().toString());
        }
        return productValues;
    }

    /**
     * Visits all getter methods of product.
     *
     * @return map of visited get methods.
     */
    private HashMap<String, Supplier> composeStrategyMapGet() {
        HashMap<String, Supplier> strategyMap = new HashMap<>();
        strategyMap.put(ProductConstant.NAME, () -> getName());
        strategyMap.put(ProductConstant.CODE, () -> getCode());
        strategyMap.put(ProductConstant.DESCRIPTION, () -> getDescription());
        strategyMap.put(ProductConstant.LIST_PRICE, () -> getListPrice());
        strategyMap.put(ProductConstant.QUANTITY, () -> getQuantity());
        strategyMap.put(ProductConstant.DATE, () -> getDate());
        return strategyMap;
    }
}
