/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.entities;

import salesforce.entities.constants.AccountConstant;
import salesforce.entities.constants.ProductConstant;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Manages Product instance.
 *
 * @author Alan Escalera.
 * @version 1.0 1 April 2020.
 */
public class Product {
    private String productName;

    private Set<String> modifiedProductFields = new HashSet<>();

    /**
     * Gets Product Name.
     *
     * @return productName value.
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets Product Name.
     *
     * @param productName value.
     */
    public void setProductName(final String productName) {
        this.productName = productName;
    }

    /**
     * Sets product information.
     *
     * @param productInformation map.
     */
    public void setProductInformation(final HashMap<String, String> productInformation) {
        HashMap<String, Runnable> strategyMap = composeStrategyMap(productInformation);
        productInformation.keySet().forEach(key -> strategyMap.get(key).run());
        modifiedProductFields.addAll(productInformation.keySet());
    }

    /**
     * Visits all setter methods of product.
     *
     * @param productInformation hashMap.
     * @return map of setter methods visited.
     */
    private HashMap<String, Runnable> composeStrategyMap(final HashMap<String, String> productInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(ProductConstant.PRODUCT_NAME, () -> setProductName(productInformation.get(AccountConstant
                .NAME)));
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
     * @return map of get methods visited.
     */
    private HashMap<String, Supplier> composeStrategyMapGet() {
        HashMap<String, Supplier> strategyMap = new HashMap<>();
        strategyMap.put(ProductConstant.PRODUCT_NAME, () -> getProductName());
        return strategyMap;
    }
}
