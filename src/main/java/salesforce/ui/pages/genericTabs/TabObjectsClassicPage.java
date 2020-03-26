/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.genericTabs;

import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.opportunity.AbstractOpportunityPage;

/**
 * Defines OpportunitiesClassicPage.
 *
 * @author Alan Escalera.
 * @version 1.0 19 March 2020.
 */
public class TabObjectsClassicPage extends AbstractTabObjectsPage {
    @FindBy(xpath = "//input[@class='btn' and @name='new']")
    private WebElement newButton;

    @FindBy(css = "select[id='fcf']")
    private WebElement opportunityListSelect;

    @FindBy(css = "span[class='fBody'] input[class='btn']")
    private WebElement goButton;

    protected static final String NAME_OPPORTUNITY = "//th//a[contains(text(),'%s')]";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(newButton));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(newButton));
    }

    @Override
    public void displayList(final String listName) {
        Select select = new Select(opportunityListSelect);
        select.selectByVisibleText(listName);
        goButton.click();
    }

    @Override
    public AbstractOpportunityPage selectObjectByName(final String opportunityName) {
        String opportunityNameXpath = String.format(NAME_OPPORTUNITY, opportunityName);
        nameOpportunitySelected = WebDriverManager.getInstance().getWebDriver().findElement(By
                .xpath(opportunityNameXpath));
        nameOpportunitySelected.click();
        return AppPageFactory.getOpportunityPage();
    }

    @Override
    public void clickOnNewButton() {
        //Todo
    }

    @Override
    public void clickOnDeleteButton(final String nameObject) {
        //Todo
    }
}
