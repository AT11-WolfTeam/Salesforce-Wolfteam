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
import salesforce.ui.pages.opportunities.opportunity.OpportunityPageAbstract;

public class OpportunitiesPageLightning extends OpportunitiesPageAbstract {

    private static final String OPPORTUNITY_NAME_LINK = "//a[@title='%s']";

    private WebElement getWebElement(final String xpathValue, final String textToConcat) {
        return webDriver.findElement(By.xpath(String.format(xpathValue, textToConcat)));
    }

    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public void displayOpportunityList(String listName) {

    }

    @Override
    public OpportunityPageAbstract clickOnOpportunityName(String opportunityName) {
        return null;
    }


    private void clickOnOpportunityNameLink(final String opportunityName) {
        getWebElement(OPPORTUNITY_NAME_LINK, opportunityName).click();
    }

    public void selectOnOpportunityNameLink(final String opportunityName) {
        clickOnOpportunityNameLink(opportunityName);
    }
}
