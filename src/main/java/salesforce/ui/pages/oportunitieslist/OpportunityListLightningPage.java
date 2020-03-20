/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.oportunitieslist;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Defines an OpportunityListLightningPage.
 *
 * @author Enrique Carrizales.
 * @version 1.0 20 March 2020.
 */
public class OpportunityListLightningPage extends OpportunityListPageAbstract {

    @FindBy(css = "table[role='grid']")
    private WebElement opportunityTable;

    private static final String OPPORTUNITY_PARTIAL_LOCATOR = "a[title='%s']";
    private static final String CELL_ATTRIBUTE = "href";

    @Override
    public void clickOnOpportunity(final String opportunityName) {

        String opportunityLocator = String.format(OPPORTUNITY_PARTIAL_LOCATOR, opportunityName);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(opportunityLocator)));
        String opportunityLink = webDriver.findElement(By.cssSelector(opportunityLocator)).getAttribute(CELL_ATTRIBUTE);
        webDriver.get(opportunityLink);
    }

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(opportunityTable));
    }
}
