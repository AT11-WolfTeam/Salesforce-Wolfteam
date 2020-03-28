/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.campaignLeads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.entities.Lead;
import salesforce.ui.pages.AbstractBasePage;
import java.util.List;

/**
 * Defines AddLeadsCampaignClassicPopup.
 *
 * @author Enrique Carrizales.
 * @version 1.0 27 March 2020.
 */
public class AddLeadsCampaignClassicPage extends AbstractBasePage {

    @FindBy(css = "input[id='filterTypel']")
    private WebElement leadCheckButton;

    @FindBy(css = "input[class='btn'][type='submit']")
    private WebElement goButton;

    @FindBy(css = "div[id='addButton']")
    private WebElement addWithStatusButton;

    @FindBy(css = "div[class='x-grid3-header-offset'] table")
    private WebElement searchTable;

    private static final String ROW_CHECK_BUTTON = "//tr[td[div[a[span[text()='%1$s']]]] and td[div[a[span[text()="
            + "'%2$s']]]] ]//../../tbody//input";
    private static final String SEND_OPTION_ADD_WITH_STATUS_BUTTON = "a[class*='menuButtonMenuLink first'][onclick]";
    private static final String PREVIOUS_LABEL = "//span[text()='Previous']";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(searchTable));
    }

    /**
     * Adds leads to a campaign.
     *
     * @param leads contains a list value.
     */
    public void addLead(final List<Lead> leads) {
        findLeads();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PREVIOUS_LABEL)));
        for (Lead lead : leads) {
            String rowCheckLocator = String.format(ROW_CHECK_BUTTON, lead.getLastName(), lead.getCompany());
            webDriver.findElement(By.xpath(rowCheckLocator)).click();
        }
        clickOnAddWithStatusButton();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(SEND_OPTION_ADD_WITH_STATUS_BUTTON)))
                .click();
    }

    /**
     * Checks a button.
     */
    private void checkLeadCheckButton() {
        if (!leadCheckButton.isSelected()) {
            leadCheckButton.click();
        }
    }

    /**
     * Click on a button.
     */
    private void clickOnGoButton() {
        goButton.click();
    }

    /**
     * Clicks on a button.
     */
    private void clickOnAddWithStatusButton() {
        addWithStatusButton.click();
    }

    /**
     * Finds leads.
     */
    private void findLeads() {
        checkLeadCheckButton();
        clickOnGoButton();
    }
}
