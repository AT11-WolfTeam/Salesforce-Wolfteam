/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Manages an OpportunitiesLightningPage page.
 *
 * @author Enrique Carrizales.
 * @version 1.0 19 March 2020.
 */
public class OpportunitiesLightningPage extends OpportunitiesPageAbstract {

    @FindBy(css = "div[class='triggerLinkTextAndIconWrapper slds-p-right--x-large']")
    private WebElement opportunityListButton;

    private static final String OPPORTUNITY_ORDERED_LIST_LOCATOR =
            "a[id = 'virtualAutoCompleteMenuOption_de3a36cf3ac78']";

    @Override
    public void displayAllOpportunities() {
        opportunityListButton.click();
        waitElementToBeClickable(webDriver.findElement(By.cssSelector(OPPORTUNITY_ORDERED_LIST_LOCATOR)));
        webDriver.findElement(By.cssSelector(OPPORTUNITY_ORDERED_LIST_LOCATOR)).click();
    }

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        waitElementToBeClickable(opportunityListButton);
    }

    /**
     * Waits for a clickable web element.
     * @param webElement contains a web element.
     */
    private void waitElementToBeClickable(final WebElement webElement) {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
