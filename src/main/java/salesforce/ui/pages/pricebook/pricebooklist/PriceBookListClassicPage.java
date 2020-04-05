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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.pricebook.PriceBookClassicPage;

/**
 * Defines PriceBookListClassicPage.
 *
 * @author Alan Escalera.
 * @version 1.0 3 April 2020.
 */
public class PriceBookListClassicPage extends AbstractPriceBookListPage {
    @FindBy(css = "input[title='New']")
    private WebElement newButton;

    private static final String PRICE_BOOK_CELL_PARTIAL_LOCATOR = "//div[@class='hotListElement']//th//a[text()='%s']";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(newButton));
    }

    @Override
    public void deleteAPriceBook(final String priceBookName) {
        webDriver.findElement(By.xpath(String.format(PRICE_BOOK_CELL_PARTIAL_LOCATOR, priceBookName))).click();
        PriceBookClassicPage priceBookClassicPage = new PriceBookClassicPage();
        priceBookClassicPage.clickOnDeleteButton();
    }
}
