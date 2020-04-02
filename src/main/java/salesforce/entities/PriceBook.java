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
import salesforce.entities.constants.PriceBookConstant;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Manages PriceBook instance.
 *
 * @author Alan Escalera.
 * @version 1.0 1 April 2020.
 */
public class PriceBook {
    private String priceBookName;

    private Set<String> modifiedPriceBookFields = new HashSet<>();

    /**
     * Gets price Book Name.
     *
     * @return priceBookName value.
     */
    public String getPriceBookName() {
        return priceBookName;
    }

    /**
     * Sets price Book Name.
     *
     * @param priceBookName value.
     */
    public void setPriceBookName(final String priceBookName) {
        this.priceBookName = priceBookName;
    }

    /**
     * Sets price book information.
     *
     * @param priceBookInformation map.
     */
    public void setPriceBookInformation(final HashMap<String, String> priceBookInformation) {
        HashMap<String, Runnable> strategyMap = composeStrategyMap(priceBookInformation);
        priceBookInformation.keySet().forEach(key -> strategyMap.get(key).run());
        modifiedPriceBookFields.addAll(priceBookInformation.keySet());
    }

    /**
     * Visits all setter methods of price book.
     *
     * @param priceBookInformation hashMap.
     * @return map of setter methods visited.
     */
    private HashMap<String, Runnable> composeStrategyMap(final HashMap<String, String> priceBookInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(PriceBookConstant.PRICE_BOOK_NAME, () -> setPriceBookName(priceBookInformation
                .get(AccountConstant.NAME)));
        return strategyMap;
    }

    /**
     * Gets price book information.
     *
     * @return product values.
     */
    public HashMap<String, String> getPriceBookInformation() {
        HashMap<String, String> priceBookValues = new HashMap<>();
        HashMap<String, Supplier> strategyMap = composeStrategyMapGet();
        for (String field : modifiedPriceBookFields) {
            priceBookValues.put(field, strategyMap.get(field).get().toString());
        }
        return priceBookValues;
    }

    /**
     * Visits all getter methods of price book.
     *
     * @return map of get methods visited.
     */
    private HashMap<String, Supplier> composeStrategyMapGet() {
        HashMap<String, Supplier> strategyMap = new HashMap<>();
        strategyMap.put(PriceBookConstant.PRICE_BOOK_NAME, () -> getPriceBookName());
        return strategyMap;
    }
}
