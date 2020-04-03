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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.entities.Product;
import salesforce.ui.pages.opportunity.opportunityproducts.AbstractOpportunityProductsPage;
import salesforce.ui.pages.opportunity.opportunityproducts.OpportunityProductsLightningPage;

/**
 * Defines EditSelectedPriceBookEntriesLightingPopUp.
 *
 * @author Alan Escalera.
 * @version 1.0 1 April 2020.
 */
public class EditSelectedPriceBookEntriesLightingPopUp extends AbstractEditSelectedPriceBookEntriesPage {
    @FindBy(xpath = "//div[@class='modal-container slds-modal__container']//button[@title='Save']")
    private WebElement saveButton;

    @FindBy(xpath = "//table//button[@class='slds-button trigger slds-button_icon-border']")
    private WebElement table;

    @FindBy(css = "div[class='forceModalActionContainer--footerAction forceModalActionContainer']")
    private WebElement editPopupFooter;

    @FindBy(css = "h2[id='modal-title']")
    private WebElement editPopupTitle;

    private static final String QUANTITY = "//th//a[contains(text(),'%s')]/../../..//td[@role='gridcell'][2]";
    private static final String QUANTITY_FIELD = "//th//a[contains(text(),'%s')]/../../..//td//input";
    private static final String DATE = "//th//a[contains(text(),'%s')]/../../..//td[@role='gridcell'][2]"
            + "//span[@class='triggerContainer']";
    private static final String DATE_FIELD = "//th//a[contains(text(),'%s')]/../../..//td[@role='gridcell'][4]//input";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(editPopupTitle));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(editPopupTitle));
        editPopupTitle.click();
    }

    /**
     * Gets web element.
     * @param xpath value.
     * @param concatText value.
     * @return composed web element.
     */
    private WebElement getWebElement(final String xpath, final String concatText) {
        return webDriver.findElement(By.xpath(String.format(xpath, concatText)));
    }

    /**
     * Sets quantity value.
     * @param productName value.
     * @param quantity value.
     */
    private void setQuantity(final String productName, final String quantity) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(getWebElement(QUANTITY, productName)));
        getWebElement(QUANTITY, productName).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(getWebElement(QUANTITY_FIELD, productName)));
        getWebElement(QUANTITY_FIELD, productName).clear();
        getWebElement(QUANTITY_FIELD, productName).sendKeys(quantity);
    }

    /**
     * Sets date value.
     * @param productName value.
     * @param date value.
     */
    private void setDate(final String productName, final String date) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(getWebElement(DATE, productName)));
        getWebElement(DATE, productName).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(getWebElement(DATE_FIELD, productName)));
        getWebElement(DATE_FIELD, productName).clear();
        getWebElement(DATE_FIELD, productName).sendKeys(date);
    }

    @Override
    public void clickOnSaveButton() {
        saveButton.click();
    }

    @Override
    public AbstractOpportunityProductsPage completeProductValues(final Product product) {
        editPopupTitle.click();
        try {
            setQuantity(product.getName(), product.getQuantity());
            clickOnSaveButton();
        } catch (StaleElementReferenceException StaleElement) {
            setQuantity(product.getName(), product.getQuantity());
            clickOnSaveButton();
        }
        return new OpportunityProductsLightningPage();
    }
}
