/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunity.opportunityproducts;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.opportunity.choosepricebook.ChoosePriceBookLightningPopup;
import salesforce.ui.pages.pricebook.addproducts.AbstractAddProduct;
import salesforce.ui.pages.pricebook.addproducts.AddProductLightningPopUp;
import java.util.ArrayList;

/**
 * Manages opportunities products lightning page.
 *
 * @author Juan Martinez.
 * @version 1.0 02 april 2020.
 */
public class OpportunityProductsLightningPage extends AbstractOpportunityProductsPage {
    @FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active "
            + "lafPageHost']//div[@title='Choose Price Book']")
    private WebElement choosePriceBookButton;

    @FindBy(css = "div[title='Add Products']")
    private WebElement addProductsButton;

    private static final String OPPORTUNITY_NAME = "//li//a[@title= '%s']";
    private static final String PRODUCT_NAME = "//span//a[@title='%s']";
    private static final String QUANTITY = "//a[@title='%s']/../../..//td[@role='gridcell'][2]//span//span";
    private static final String SALES_PRICE = "//a[@title='%s']/../../..//td[@role='gridcell'][3]//span//span";
    private static final String DATE = "//a[@title='%s']/../../..//td[@role='gridcell'][4]//span//span";
    private static final String POINT_CHARACTER = ".";
    private static final String COMMA_CHARACTER = ",";

    private ArrayList<String> productValues;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(choosePriceBookButton));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(choosePriceBookButton));
    }

    /**
     * Clicks on price book button.
     */
    private void clickOnChoosePriceBookButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(choosePriceBookButton));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(choosePriceBookButton));
        choosePriceBookButton.click();
    }

    /**
     * Clicks on add product button.
     */
    private void clickOnAddProductsButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(addProductsButton));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addProductsButton));
        addProductsButton.click();
    }

    @Override
    public AbstractAddProduct choosePriceBook(final String priceBookName) {
        clickOnChoosePriceBookButton();
        ChoosePriceBookLightningPopup priceBookLightningPopup = new ChoosePriceBookLightningPopup();
        priceBookLightningPopup.selectPriceBookByName(priceBookName);
        try {
            clickOnAddProductsButton();
        } catch (StaleElementReferenceException StaleElement) {
            clickOnAddProductsButton();
        }
        return new AddProductLightningPopUp();
    }

    /**
     * Gets opportunity name.
     *
     * @param opportunityName value.
     * @return opportunity name text.
     */
    private String getOpportunityName(final String opportunityName) {
        return getWebElement(OPPORTUNITY_NAME, opportunityName).getText();
    }

    /**
     * Gets product name.
     *
     * @param productName value.
     * @return product name text.
     */
    private String getProductName(final String productName) {
        return getWebElement(PRODUCT_NAME, productName).getText();
    }

    /**
     * Gets substring value.
     *
     * @param string value.
     * @param position value.
     * @return substring.
     */
    private String getSubstring(final String string, final int position) {
        String data = string;
        return data.substring(0, position);
    }

    /**
     * Gets product quantity.
     *
     * @param productName value.
     * @return product quantity text.
     */
    private String getQuantity(final String productName) {
        String quantity = getWebElement(QUANTITY, productName).getText();
        int position = quantity.indexOf(POINT_CHARACTER);
        return getSubstring(quantity, position);
    }

    /**
     * Gets product sales price.
     *
     * @param productName value.
     * @return product sales price text.
     */
    private String getSalesPrice(final String productName) {
        String salesPrice = getWebElement(SALES_PRICE, productName).getText();
        int position = salesPrice.indexOf(COMMA_CHARACTER);
        return getSubstring(salesPrice, position);
    }

    /**
     * Gets product date.
     *
     * @param productName value.
     * @return product date text.
     */
    private String getDate(final String productName) {
        return getWebElement(DATE, productName).getText();
    }

    @Override
    public ArrayList<String> validateProductInformation(final String opportunityName, final String productName) {
        productValues = new ArrayList<>();
        productValues.add(getOpportunityName(opportunityName));
        productValues.add(getProductName(productName));
        productValues.add(getQuantity(productName));
        productValues.add(getSalesPrice(productName));
        return productValues;
    }
}
