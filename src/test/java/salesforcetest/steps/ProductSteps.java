/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforcetest.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import salesforce.entities.Context;
import salesforce.entities.Product;
import java.util.Map;

/**
 * Manages product instance.
 *
 * @author Juan Martinez.
 * * @version 1.0 01 April 2020.
 */
public class ProductSteps {

    // Entities
    private Context context;
    private Product product;

    // Pages

    /**
     * Manages products steps.
     *
     * @param context instance.
     */
    public ProductSteps(final Context context) {
        this.context = context;
        product = context.getProduct();
    }

    /**
     * Creates a product.
     *
     * @param productValues map.
     */
    @And("I create a new product with the following values")
    public void createNewProduct(final Map<String, String> productValues) {
        product.setProductInformation(productValues);
        // implement pages.
    }

    /**
     * Selects the created product by its name.
     */
    @And("I select the product")
    public void selectProduct() {
        String productName = context.getProduct().getName();
        // implement pages.
    }

    /**
     * Adds the product to price book.
     *
     * @param priceBookName value.
     */
    @And("I add the product to {string}")
    public void addProductToPriceBook(final String priceBookName) {

    }

    /**
     * Adds the product to opportunity.
     */
    @And("I add the product to opportunity")
    public void addProductToOpportunity() {

    }

    /**
     * Allows to verify the added products to opportunity.
     */
    @Then("The product should be displayed on Products page")
    public void displayProducts() {

    }
}
