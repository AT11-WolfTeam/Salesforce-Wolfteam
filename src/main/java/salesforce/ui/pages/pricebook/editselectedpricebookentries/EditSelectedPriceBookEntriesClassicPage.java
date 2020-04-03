/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.pricebook.editselectedpricebookentries;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import salesforce.entities.Product;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Defines EditSelectedPriceBookEntriesClassicPage.
 *
 * @author Alan Escalera.
 * @version 1.0 1 April 2020.
 */
public class EditSelectedPriceBookEntriesClassicPage extends AbstractEditSelectedPriceBookEntriesPage {
    @FindBy(xpath = "//td[@class='numericalColumn dataCell'] //input[@type='checkbox']")
    private WebElement checkBoxPrice;

    @FindBy(css = "input[title='Save']")
    private WebElement saveButton;

    private static final String QUANTITY = "//tr/th[starts-with(text(),'%s')]/../td/input[starts-with(@id,'Quantity')]";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(saveButton));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(saveButton));
    }

    @Override
    public void clickOnSaveButton() {
        checkBoxPrice.click();
        saveButton.click();
    }

    /**
     * Gets web element.
     *
     * @param xpath value.
     * @param concatText value.
     * @return composed web element.
     */
    private WebElement getWebElement(final String xpath, final String concatText) {
        return webDriver.findElement(By.xpath(String.format(xpath, concatText)));
    }

    /**
     * Sets quantity value.
     *
     * @param productName value.
     * @param quantity value.
     */
    private void setQuantity(final String productName, final String quantity) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(getWebElement(QUANTITY, productName)));
        getWebElement(QUANTITY, productName).click();
        getWebElement(QUANTITY, productName).clear();
        getWebElement(QUANTITY, productName).sendKeys(quantity);
    }

    /**
     * Clicks on save button.
     */
    public void clickOnSave() {
        saveButton.click();
    }

    @Override
    public void completeProductValues(final Product product) {
        try {
            setQuantity(product.getName(), product.getQuantity());
            clickOnSave();
        } catch (StaleElementReferenceException StaleElement) {
            setQuantity(product.getName(), product.getQuantity());
            clickOnSave();
        }
    }
}
