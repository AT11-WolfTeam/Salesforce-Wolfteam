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
import org.testng.Assert;
import salesforce.entities.Context;
import salesforce.entities.Opportunity;
import salesforce.entities.Product;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.genericTabs.AbstractTabObjectsPage;
import salesforce.ui.pages.opportunity.AbstractOpportunityPage;
import salesforce.ui.pages.opportunity.opportunityproducts.AbstractOpportunityProductsPage;
import salesforce.ui.pages.pricebook.addproducts.AbstractAddProduct;
import salesforce.ui.pages.pricebook.editselectedpricebookentries.AbstractEditSelectedPriceBookEntriesPage;
import salesforce.ui.pages.product.AbstractProductPage;
import salesforce.ui.pages.product.newpricebookentry.AbstractNewPriceBookEntryPage;
import salesforce.ui.pages.product.newproduct.AbstractNewProductPage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    private List<Opportunity> opportunities;

    // Pages
    private AbstractTabObjectsPage tabObjectsPage;
    private AbstractNewProductPage newProductPage;
    private AbstractProductPage productPage;
    private AbstractNewPriceBookEntryPage newPriceBookEntryPage;
    private AbstractOpportunityPage opportunityPage;
    private AbstractOpportunityProductsPage opportunityProductsPage;
    private AbstractAddProduct addProduct;
    private AbstractEditSelectedPriceBookEntriesPage editSelectedPriceBookEntriesPage;

    // Constants
    private static final int NAME = 0;
    private static final int CODE = 1;
    private static final int DESCRIPTION = 2;
    private static final int FIRST = 0;
    private static String priceBook;

    private Set<String> productKeys;
    private ArrayList<String> actual;

    /**
     * Manages products steps.
     *
     * @param context instance.
     */
    public ProductSteps(final Context context) {
        this.context = context;
        product = context.getProduct();
        opportunities = context.getOpportunities();
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
        priceBook = priceBookName;
        newPriceBookEntryPage.saveNewPriceBookEntity(product.getListPrice(), priceBook);
    }

    /**
     * Adds the product to opportunity.
     */
    @And("I add the product to opportunity")
    public void addProductToOpportunity() {
        opportunityPage = AppPageFactory.getOpportunityPage();
        opportunityProductsPage = opportunityPage.clickOnProducts();
        addProduct = opportunityProductsPage.choosePriceBook(priceBook);
        addProduct.checkProductToAdd(product.getName());
        editSelectedPriceBookEntriesPage = AppPageFactory.getEditSelectedPriceBookEntriesPage();
        opportunityProductsPage = editSelectedPriceBookEntriesPage.completeProductValues(product);
    }

    /**
     * Allows to verify the added products to opportunity.
     */
    @Then("The product should be displayed on Products page")
    public void displayProducts() {
        String opportunityName = context.getOpportunities().get(FIRST).getName();
        ArrayList<String> expected = new ArrayList<>();
        expected.add(opportunityName);
        expected.add(product.getName());
        expected.add(product.getQuantity());
        expected.add(product.getListPrice());
        actual = opportunityProductsPage.validateProductInformation(opportunityName, product.getName());
        Assert.assertEquals(actual, expected);
    }
}
