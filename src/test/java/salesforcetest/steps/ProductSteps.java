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
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.genericTabs.AbstractTabObjectsPage;
import salesforce.ui.pages.opportunity.AbstractOpportunityPage;
import salesforce.ui.pages.product.AbstractProductPage;
import salesforce.ui.pages.product.newpricebookentry.AbstractNewPriceBookEntryPage;
import salesforce.ui.pages.product.newproduct.AbstractNewProductPage;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
    private AbstractTabObjectsPage tabObjectsPage;
    private AbstractNewProductPage newProductPage;
    private AbstractProductPage productPage;
    private AbstractNewPriceBookEntryPage newPriceBookEntryPage;
    private AbstractOpportunityPage opportunityPage;
    private Set<String> productKeys;

    // Constants
    private static final int NAME = 0;
    private static final int CODE = 1;
    private static final int DESCRIPTION = 2;

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
        productKeys = new HashSet<>();
        productKeys.add(productValues.keySet().toArray()[NAME].toString());
        productKeys.add(productValues.keySet().toArray()[CODE].toString());
        productKeys.add(productValues.keySet().toArray()[DESCRIPTION].toString());
        tabObjectsPage = AppPageFactory.getTabObjectsPage();
        tabObjectsPage.clickOnNewButton();
        newProductPage = AppPageFactory.getNewProductPage();
        newProductPage.setProductInformation(product, productKeys);
    }

    /**
     * Selects the created product by its name.
     */
    @And("I select the product")
    public void selectProduct() {
        String productName = context.getProduct().getName();
        AppPageFactory.getTabObjectsPage().selectObjectByName(productName);
        productPage = AppPageFactory.getProductPage();
        newPriceBookEntryPage = productPage.clickOnAddStandardPriceButton();
    }

    /**
     * Adds the product to price book.
     *
     * @param priceBookName value.
     */
    @And("I add the product to {string}")
    public void addProductToPriceBook(final String priceBookName) {
        newPriceBookEntryPage.saveNewPriceBookEntity(product.getListPrice(), priceBookName);
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
