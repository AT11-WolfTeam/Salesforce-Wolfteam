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
 * Defines an OpportunityListClassicPage.
 *
 * @author Enrique Carrizales.
 * @version 1.0 20 March 2020.
 */
public class OpportunityListClassicPage extends AbstractOpportunityListPage {

    @FindBy(css = "li[class='lastItem'] input")
    private WebElement refreshButton;

    private static final String OPPORTUNITY_CELL_PARTIAL_LOCATOR =
            "//div[@class='x-grid3-cell-inner x-grid3-col-Name']//a[span[contains(text(),'%s')]]";

    @Override
    public void clickOnOpportunity(final String opportunityName) {
        String opportunityCellLocator = String.format(OPPORTUNITY_CELL_PARTIAL_LOCATOR, opportunityName);
        webDriver.findElement(By.xpath(opportunityCellLocator)).click();
    }

    @Override
    public String getStageName(String opportunityName) {
        //To Do
        return null;
    }

    @Override
    public void deleteOpportunity(String name) {
        //To Do
    }

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(refreshButton));
    }
}
