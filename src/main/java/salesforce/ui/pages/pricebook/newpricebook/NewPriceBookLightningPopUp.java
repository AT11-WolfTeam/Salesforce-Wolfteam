/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.pricebook.newpricebook;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Defines NewPriceBookLightningPopUp.
 *
 * @author Alan Escalera.
 * @version 1.0 1 April 2020.
 */
public class NewPriceBookLightningPopUp extends AbstractNewPriceBookPage {
    @FindBy(xpath = "//div[@class='windowViewMode-normal oneRecordActionWrapper isModal active lafPageHost']"
             + "//span[text()='Price Book Name']/../..//input")
    private WebElement priceBookNameField;

    @FindBy(xpath = "//div[@class='windowViewMode-normal oneRecordActionWrapper isModal active lafPageHost']"
             + "//button[@title='Save']")
    private WebElement saveButton;

    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }
}
