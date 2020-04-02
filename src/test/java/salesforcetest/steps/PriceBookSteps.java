/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforcetest.steps;

import core.utils.GradleReader;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import salesforce.entities.Context;
import salesforce.entities.PriceBook;
import salesforce.ui.components.span.ToastUpdateObjectMessage;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.genericTabs.AbstractTabObjectsPage;
import salesforce.ui.pages.pricebook.AbstractPriceBookPage;
import salesforce.ui.pages.pricebook.addproducts.AbstractAddProduct;
import salesforce.ui.pages.pricebook.editselectedpricebookentries.AbstractEditSelectedPriceBookEntriesPage;
import salesforce.ui.pages.pricebook.newpricebook.AbstractNewPriceBookPage;
import java.util.Map;

/**
 * Manages PriceBook instance.
 *
 * @author Alan Escalera.
 * * @version 1.0 02 April 2020.
 */
public class PriceBookSteps {
    private Context context;
    private AbstractTabObjectsPage abstractTabObjectsPage;
    private AbstractNewPriceBookPage abstractNewPriceBookPage;
    private AbstractPriceBookPage abstractPriceBookPage;
    private AbstractAddProduct abstractAddProduct;
    private AbstractEditSelectedPriceBookEntriesPage abstractEditSelectedPriceBookEntriesPage;
    private PriceBook priceBook;
    private ToastUpdateObjectMessage toastUpdateObjectMessage;
    private static String userExperience = GradleReader.getInstance().getUserExperience();
    private static final String USER_EXPERIENCE_LIGHTNING = "Lightning";

    /**
     * PriceBookSteps constructor.
     *
     * @param context instance.
     */
    public PriceBookSteps(final Context context) {
        this.context = context;
    }

    /**
     * Creates a new price book with map values.
     *
     * @param priceBookValues map values.
     */
    @And("I create a new PriceBook with")
    public void createANewPriceBookWith(final Map<String, String> priceBookValues) {
        abstractTabObjectsPage = AppPageFactory.getTabObjectsPage();
        abstractTabObjectsPage.clickOnNewButton();
        priceBook = context.getPriceBook();
        priceBook.setPriceBookInformation(priceBookValues);
        abstractNewPriceBookPage = AppPageFactory.getNewPriceBookPage();
        abstractPriceBookPage = abstractNewPriceBookPage.setPriceBookInformation(priceBook, priceBookValues.keySet());
    }

    /**
     * Adds the product.
     *
     * @param productName value.
     */
    @When("I add the product {string}")
    public void addTheProduct(final String productName) {
        abstractPriceBookPage.clickOnRelatedTab();
        abstractAddProduct = abstractPriceBookPage.clickOnAddProductsButton();
        abstractEditSelectedPriceBookEntriesPage = abstractAddProduct.checkProductToAdd(productName);
        abstractEditSelectedPriceBookEntriesPage.clickOnSaveButton();
    }

    /**
     * the application should display the message expected.
     *
     * @param messageExpected value.
     */
    @Then("the application should display {string}")
    public void theApplicationShouldDisplay(final String messageExpected) {
        if (userExperience.equals(USER_EXPERIENCE_LIGHTNING)) {
            toastUpdateObjectMessage = new ToastUpdateObjectMessage();
            String messageActual = toastUpdateObjectMessage.getMessage();
            Assert.assertEquals(messageExpected, messageActual);
        }
    }

    /**
     * the product should be displayed on the table.
     */
    @And("the product should be displayed on the table")
    public void theProductShouldBeDisplayedOnTheTable() {
        throw new PendingException();
    }
}
