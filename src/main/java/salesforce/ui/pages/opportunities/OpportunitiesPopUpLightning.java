/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.opportunity.OpportunityPageAbstract;

/**
 * Defines OpportunitiesPopUpLightning.
 *
 * @author Alan Escalera.
 * @version 1.0 19 March 2020.
 */
public class OpportunitiesPopUpLightning extends OpportunitiesPageAbstract {
    @FindBy(css = "div[title='New']")
    private WebElement newButton;

    @FindBy(css = "div[class='triggerLinkTextAndIconWrapper slds-p-right--x-large']")
    private WebElement opportunityListButton;

    private static final String OPPORTUNITY_ORDERED_LIST_PARTIAL_LOCATOR = "//li[contains(.,'%s')]";
    private static final String NAME_OPPORTUNITY = "a[title='%s']";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(newButton));
    }

    @Override
    public void displayOpportunityList(final String listName) {
        String opportunityOrderedListLocator;

        opportunityListButton.click();
        opportunityOrderedListLocator = String.format(OPPORTUNITY_ORDERED_LIST_PARTIAL_LOCATOR, listName);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(
                By.xpath(opportunityOrderedListLocator))));
        webDriver.findElement(By.xpath(opportunityOrderedListLocator)).click();
    }

    @Override
    public OpportunityPageAbstract clickOnOpportunityName(final String opportunityName) {
        return null;
    }
}
