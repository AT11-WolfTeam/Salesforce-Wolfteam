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
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.lead.DeleteObjectLightningPopup;
import salesforce.ui.pages.opportunity.AbstractOpportunityPage;

/**
 * Defines OpportunitiesPopUpLightning.
 *
 * @author Alan Escalera.
 * @version 1.0 19 March 2020.
 */
public class TabObjectsLightningPage extends AbstractTabObjectsPage {
    @FindBy(css = "div[title='New']")
    private WebElement newButton;

    @FindBy(css = "div[class='triggerLinkTextAndIconWrapper slds-p-right--x-large']")
    private WebElement opportunityListButton;

    private static final String OBJECT_TAB_BASE_LOCATOR = "//a[@title='%s']//../../..//a[contains(@class,'"
            + "rowActions')]";
    private static final String DELETE_OPTION_LOCATOR = "//div[contains(@class,'branding-actions')]//a[contains(@title,"
            + "'Delete')]";
    protected static final String NAME_OBJECT = "a[title='%s']";
    private static final String OBJECT_ORDERED_LIST_PARTIAL_LOCATOR = "//li[contains(.,'%s')]";
    private WebElement nameOpportunityTable;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(newButton));
    }

    @Override
    public void displayList(final String listName) {
        String opportunityOrderedListLocator;
        opportunityListButton.click();
        opportunityOrderedListLocator = String.format(OBJECT_ORDERED_LIST_PARTIAL_LOCATOR, listName);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(
                By.xpath(opportunityOrderedListLocator))));
        webDriver.findElement(By.xpath(opportunityOrderedListLocator)).click();
    }

    @Override
    public AbstractOpportunityPage selectObjectByName(final String opportunityName) {
        String opportunityNameXpath = String.format(NAME_OBJECT, opportunityName);
        nameOpportunitySelected = WebDriverManager.getInstance().getWebDriver().findElement(By
                .cssSelector(opportunityNameXpath));
        nameOpportunitySelected.click();
        return AppPageFactory.getOpportunityPage();
    }

    @Override
    public void clickOnNewButton() {
        newButton.click();
    }

    @Override
    public void clickOnDeleteButton(final String nameObject) {
        String objectTabLocator = String.format(OBJECT_TAB_BASE_LOCATOR, nameObject);
        try {
            webDriver.findElement(By.xpath(objectTabLocator)).click();
            webDriver.findElement(By.xpath(DELETE_OPTION_LOCATOR)).click();
            DeleteObjectLightningPopup deleteObjectLightningPopup = new DeleteObjectLightningPopup();
            deleteObjectLightningPopup.clickOnDeleteButton();
        } catch (StaleElementReferenceException elementHasDisappeared) {
            webDriver.findElement(By.xpath(objectTabLocator)).click();
            webDriver.findElement(By.xpath(DELETE_OPTION_LOCATOR)).click();
            DeleteObjectLightningPopup deleteObjectLightningPopup = new DeleteObjectLightningPopup();
            deleteObjectLightningPopup.clickOnDeleteButton();
        }
    }
}
