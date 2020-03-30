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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Defines an OpportunityListLightningPage.
 *
 * @author Enrique Carrizales.
 * @version 1.0 20 March 2020.
 */
public class OpportunityListLightningPage extends AbstractOpportunityListPage {

    @FindBy(css = "table[role='grid']")
    private WebElement opportunityTable;

    @FindBy(xpath = "//div[@class='branding-actions actionMenu']//a[@title='Delete']")
    private WebElement deleteButton;

    @FindBy(xpath = "//div[@class='modal-container slds-modal__container']//button[@title='Delete']")
    private WebElement deleteConfirmButton;

    private static final String OPPORTUNITY_PARTIAL_LOCATOR = "//div[@class='windowViewMode-normal oneContent active"
            + " lafPageHost']//a[@title='%s']";
    private static final String CELL_ATTRIBUTE = "href";

    private static final String STAGE_NAME = "//div[@class='windowViewMode-normal oneContent active"
            + " lafPageHost']//table//tbody//th//a[@title='%s']/../../..//td[5]//span[@class='slds-truncate']";

    private static final String MORE_ACTIONS = "//table//tbody//tr//th//a[@title='%s']/../../..//td"
            + "//div[@class='forceVirtualActionMarker forceVirtualAction']";
    private Actions actions = new Actions(webDriver);

    @Override
    public void clickOnOpportunity(final String opportunityName) {
        String opportunityLocator = String.format(OPPORTUNITY_PARTIAL_LOCATOR, opportunityName);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(opportunityLocator)));
        String opportunityLink = webDriver.findElement(By.xpath(opportunityLocator)).getAttribute(CELL_ATTRIBUTE);
        webDriver.get(opportunityLink);
    }

    @Override
    public String getStageName(final String opportunityName) {
        return webDriver.findElement(By.xpath(String.format(STAGE_NAME, opportunityName))).getText();
    }

    @Override
    public void deleteOpportunity(final String name) {
        clickOnMoreActions(name);
        clickOnDeleteButton();
        clickOnDeleteConfirmation();
    }

    /**
     * Clicks on Delete confirmation button.
     */
    private void clickOnDeleteConfirmation() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(deleteConfirmButton));
        deleteConfirmButton.click();
    }

    /**
     * Clicks on delete button.
     */
    private void clickOnDeleteButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        actions.click(deleteButton).build().perform();
    }

    /**
     * Clicks on More Actions button.
     *
     * @param name value.
     */
    private void clickOnMoreActions(final String name) {
        webDriver.findElement(By.xpath(String.format(MORE_ACTIONS, name))).click();
    }

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(opportunityTable));
    }

}
