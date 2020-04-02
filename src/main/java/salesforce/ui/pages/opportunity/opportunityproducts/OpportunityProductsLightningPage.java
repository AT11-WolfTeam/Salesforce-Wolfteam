/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunity.opportunityproducts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.opportunity.choosepricebook.AbstractChoosePriceBook;
import salesforce.ui.pages.opportunity.choosepricebook.ChoosePriceBookLightningPopup;

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

    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Clicks on price book button.
     */
    private void clickOnChoosePriceBookButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(choosePriceBookButton));
        choosePriceBookButton.click();
    }

    @Override
    public AbstractChoosePriceBook choosePriceBook() {
        clickOnChoosePriceBookButton();
        return new ChoosePriceBookLightningPopup();
    }
}
