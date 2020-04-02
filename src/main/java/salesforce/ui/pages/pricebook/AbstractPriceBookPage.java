/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.pricebook;

import salesforce.entities.PriceBook;
import salesforce.entities.Product;
import salesforce.entities.constants.ContactConstant;
import salesforce.entities.constants.ProductConstant;
import salesforce.ui.pages.AbstractBasePage;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.pricebook.addproducts.AbstractAddProduct;
import salesforce.ui.pages.product.AbstractProductPage;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Defines AbstractPriceBookPage.
 *
 * @author Alan Escalera.
 * @version 1.0 1 April 2020.
 */
public abstract class AbstractPriceBookPage extends AbstractBasePage {
    /**
     * Clicks on related tab.
     */
    public abstract void clickOnRelatedTab();

    /**
     * CLicks on add products button.
     * @return AddProduct instance.
     */
    public abstract AbstractAddProduct clickOnAddProductsButton();

    /**
     * Gets product name.
     * @param productName value.
     * @return product name value.
     */
    public abstract String getProductName(String productName);

    /**
     * Gets list price.
     * @return price of a product.
     */
    public abstract String getListPrice();

    /**
     * Gets contact information.
     *
     * @return contact values.
     */
    public HashMap<String, String> getContactInformation(Product product,Map<String,String> fieldsProduct) {
        HashMap<String, String> contactValues = new HashMap<>();
        HashMap<String, Supplier> strategyMap = composeStrategyMapGet(product);
        for (String field : fieldsProduct.keySet()) {
            contactValues.put(field, strategyMap.get(field).get().toString());
        }
        return contactValues;
    }

    /**
     * Visits all getter methods of contact.
     *
     * @return map of visited get methods.
     */
    private HashMap<String, Supplier> composeStrategyMapGet(Product product) {
        HashMap<String, Supplier> strategyMap = new HashMap<>();
        strategyMap.put(ProductConstant.NAME, () -> getProductName(product.getName()));
        strategyMap.put(ProductConstant.SALES_PRICE, () -> getListPrice());
        return strategyMap;
    }
}
