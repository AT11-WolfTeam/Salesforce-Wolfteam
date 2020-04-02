/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.pricebook;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Defines PriceBookLightningPage.
 *
 * @author Alan Escalera.
 * @version 1.0 1 April 2020.
 */
public class PriceBookLightningPage extends AbstractPriceBookPage {
    @FindBy(xpath = "//span[text()='Related']")
    private WebElement relatedTab;

    @FindBy(xpath = "//a[@title='Add Products']")
    private WebElement addProductsButton;

    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }
}
