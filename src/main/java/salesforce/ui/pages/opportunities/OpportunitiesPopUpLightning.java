/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunities;

import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.AppPageFactory;

/**
 * Defines OpportunitiesPopUpLightning.
 *
 * @author Alan Escalera.
 * @version 1.0 19 March 2020.
 */
public class OpportunitiesPopUpLightning extends OpportunitiesPageAbstract {
    @FindBy(css = "div[title='New']")
    private WebElement newButton;

    private WebElement nameOpportunityTable;
    private static final String NAME_OPPORTUNITY = "a[title='%s']";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(newButton));
    }

    @Override
    public OpportunityPageAbstract selectOpportunityName(final String opportunityName) {
        String opportunityNameXpath = String.format(NAME_OPPORTUNITY, opportunityName);
        nameOpportunityTable = WebDriverManager.getInstance().getWebDriver().findElement(By
                .cssSelector(opportunityNameXpath));
        nameOpportunityTable.click();
        return AppPageFactory.getOpportinityPage();
    }
}
