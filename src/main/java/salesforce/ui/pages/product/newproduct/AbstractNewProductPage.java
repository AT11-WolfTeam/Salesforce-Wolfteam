/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.product.newproduct;

import salesforce.entities.Product;
import salesforce.entities.constants.ProductConstant;
import salesforce.ui.pages.AbstractBasePage;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.product.AbstractProductPage;
import java.util.HashMap;
import java.util.Set;

/**
 * Defines AbstractNewProductPage.
 *
 * @author Alan Escalera.
 * @version 1.0 1 April 2020.
 */
public abstract class AbstractNewProductPage extends AbstractBasePage {

    /**
     * Sets product name.
     *
     * @param productName value.
     */
    protected abstract void setProductName(String productName);

    /**
     * Clicks on save button.
     */
    protected abstract void clickOnSaveButton();

    /**
     * Sets the form of product information.
     *
     * @param product entity.
     * @param fields map.
     * @return ProductPage instance.
     */
    public AbstractProductPage setProductInformation(final Product product, final Set<String> fields) {
        HashMap<String, Runnable> strategtyMap = composeStrategyMap(product);
        fields.forEach(field -> strategtyMap.get(field).run());
        clickOnSaveButton();
        return AppPageFactory.getProductPage();
    }

    /**
     * Sets the information of new product.
     *
     * @param product entity.
     * @return HashMap value.
     */
    protected HashMap<String, Runnable> composeStrategyMap(final Product product) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(ProductConstant.NAME, () -> setProductName(product.getName()));
        return strategyMap;
    }
}
