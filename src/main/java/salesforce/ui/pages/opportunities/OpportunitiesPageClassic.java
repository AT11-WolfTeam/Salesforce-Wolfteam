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
import salesforce.ui.pages.opportunities.opportunity.OpportunityClassicPage;
import salesforce.ui.pages.opportunities.opportunity.OpportunityPageAbstract;

/**
 * Defines OpportunitiesPageClassic.
 *
 * @author Alan Escalera.
 * @version 1.0 19 March 2020.
 */
public class OpportunitiesPageClassic extends OpportunitiesPageAbstract {
    private static final String OPPORTUNITY_NAME = "//a[text()='%s']";

    @FindBy(xpath = "//table[@class='list']")
    private WebElement opportunityTable;

    private WebElement getWebElement(final String xpathValue, final String textToConcat) {
        return webDriver.findElement(By.xpath(String.format(xpathValue, textToConcat)));
    }

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(opportunityTable));
    }

    @Override
    public void displayOpportunityList(final String listName) {

    }

    @Override
    public OpportunityPageAbstract clickOnOpportunityName(final String opportunityName) {
        getWebElement(OPPORTUNITY_NAME, opportunityName).click();
        return new OpportunityClassicPage();
    }
}
