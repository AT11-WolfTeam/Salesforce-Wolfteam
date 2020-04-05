/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.pricebook.pricebooklist;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.lead.DeleteObjectLightningPopup;

/**
 * Defines PriceBookListLightningPage.
 *
 * @author Alan Escalera.
 * @version 1.0 3 April 2020.
 */
public class PriceBookListLightningPage extends AbstractPriceBookListPage {
    @FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//div[@title='New']")
    private WebElement newButton;

    private static final String PRICE_BOOK_TAB_BASE_LOCATOR = "//a[@title='%s']//../../..//a[contains(@class,'"
            + "rowActions')]";
    private static final String DELETE_OPTION_LOCATOR = "//div[contains(@class,'branding-actions')]//a[contains(@title,"
            + "'Delete')]";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(newButton));
    }

    @Override
    public void deleteAPriceBook(final String priceBookName) {
        String objectTabLocator = String.format(PRICE_BOOK_TAB_BASE_LOCATOR, priceBookName);
        try {
            webDriver.findElement(By.xpath(objectTabLocator)).click();
            webDriver.findElement(By.xpath(DELETE_OPTION_LOCATOR)).click();
            DeleteObjectLightningPopup deleteObjectLightningPopup = new DeleteObjectLightningPopup();
            deleteObjectLightningPopup.clickOnDeleteButton();
        } catch (StaleElementReferenceException elementHasDisappeared) {
            webDriver.findElement(By.xpath(objectTabLocator)).click();
            webDriver.findElement(By.xpath(DELETE_OPTION_LOCATOR)).click();
            DeleteObjectLightningPopup deleteObjectLightningPopup = new DeleteObjectLightningPopup();
            deleteObjectLightningPopup.clickOnDeleteButton();
        }
    }
}
