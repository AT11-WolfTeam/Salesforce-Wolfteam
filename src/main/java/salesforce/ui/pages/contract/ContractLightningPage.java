/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.contract;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.newopportunity.AbstractNewOpportunityPage;

/**
 * Defines ContractLightningPage.
 *
 * @author Alan Escalera.
 * @version 1.0 28 March 2020.
 */
public class ContractLightningPage extends AbstractContractPage {
    private static final String WINDOW_ACTIVE_LOCATOR = "//div[@class='windowViewMode-normal oneContent active "
            + "lafPageHost']";

    @FindBy(xpath = WINDOW_ACTIVE_LOCATOR + "//div[@title='New Opportunity']")
    private WebElement newOpportunityButton;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(newOpportunityButton));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(newOpportunityButton));
    }

    @Override
    public AbstractNewOpportunityPage clickOnNewOpportunity() {
        newOpportunityButton.click();
        return AppPageFactory.getNewOpportunityPage();
    }
}
