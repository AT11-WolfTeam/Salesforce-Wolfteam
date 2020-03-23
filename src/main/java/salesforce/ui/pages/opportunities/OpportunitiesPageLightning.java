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
import salesforce.ui.pages.opportunity.OpportunityLightningPage;
import salesforce.ui.pages.opportunity.OpportunityPageAbstract;

/**
 * Manages opportunities page lightning.
 *
 * @author Juan Martinez.
 * @version 1.0 23 March 2020.
 */
public class OpportunitiesPageLightning extends OpportunitiesPageAbstract {

    private static final String OPPORTUNITY_NAME_LINK = "//a[@title='%s']";

    /**
     * Allows to get and web element.
     * @param xpathValue string.
     * @param textToConcat value.
     * @return a web element.
     */
    private WebElement getWebElement(final String xpathValue, final String textToConcat) {
        return webDriver.findElement(By.xpath(String.format(xpathValue, textToConcat)));
    }

    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public void displayOpportunityList(final String listName) {

    }

    /**
     * Clicks on opportunity link name.
     * @param opportunityName value.
     */
    private void clickOnOpportunityNameLink(final String opportunityName) {
        getWebElement(OPPORTUNITY_NAME_LINK, opportunityName).click();
    }

    @Override
    public OpportunityPageAbstract clickOnOpportunityName(final String opportunityName) {
        clickOnOpportunityNameLink(opportunityName);
        return new OpportunityLightningPage();
    }
}
