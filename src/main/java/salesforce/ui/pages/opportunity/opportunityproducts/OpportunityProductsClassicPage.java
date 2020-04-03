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
import salesforce.ui.pages.opportunity.choosepricebook.ChoosePriceBookClassicPage;
import salesforce.ui.pages.pricebook.addproducts.AbstractAddProduct;
import salesforce.ui.pages.pricebook.addproducts.AddProductClassicPage;
import java.util.ArrayList;

/**
 * Manages opportunities products classic page.
 *
 * @author Juan Martinez.
 * @version 1.0 02 april 2020.
 */
public class OpportunityProductsClassicPage extends AbstractOpportunityProductsPage {
    @FindBy(css = "input[value=' Save ']")
    private WebElement saveButton;

    @FindBy(css = "input[value='Choose Price Book']")
    private WebElement choosePriceButton;

    @FindBy(css = "input[value='Add Product']")
    private WebElement addProductButton;

    private static final String PRICE_BOOK_COMBOBOX = "//select[@id='p1']";
    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Clicks on choose price book button.
     */
    private void clickOnChoosePriceBookButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(choosePriceButton));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(choosePriceButton));
        choosePriceButton.click();
}

    /**
     * Clicks on add product button.
     */
    private void clickOnAddProductsButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(addProductButton));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addProductButton));
        addProductButton.click();
    }

    @Override
    public AbstractAddProduct choosePriceBook(final String priceBookName) {
        clickOnChoosePriceBookButton();
        ChoosePriceBookClassicPage priceBookClassicPage = new ChoosePriceBookClassicPage();
        priceBookClassicPage.selectPriceBookByName(priceBookName);
        try {
            clickOnAddProductsButton();
        } catch (StaleElementReferenceException StaleElement) {
            clickOnAddProductsButton();
        }
        return new AddProductClassicPage();
    }

    @Override
    public ArrayList<String> validateProductInformation(final String opportunityName, final String  product) {
        return null;
    }
}
