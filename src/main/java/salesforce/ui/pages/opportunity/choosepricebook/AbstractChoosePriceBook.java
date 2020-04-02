/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunity.choosepricebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import salesforce.ui.pages.AbstractBasePage;

/**
 * Defines opportunities choose price books.
 *
 * @author Juan Martinez.
 * @version 1.0 02 april 2020.
 */
public abstract class AbstractChoosePriceBook extends AbstractBasePage {

    /**
     * Selects price book by name.
     *
     * @param priceBookName value.
     */
    public abstract void selectPriceBookByName(String priceBookName);

    /**
     * Gets a web element.
     *
     * @param xpath value.
     * @param concatText value.
     * @return composed web element.
     */
    public WebElement getWebElement(final String xpath, final String concatText) {
        return webDriver.findElement(By.xpath(String.format(xpath, concatText)));
    }
}
