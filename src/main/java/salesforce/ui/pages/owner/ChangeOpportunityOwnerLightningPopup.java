/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.owner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.AbstractBasePage;
import salesforce.utils.JsonFileReader;

/**
 * Defines an OpportunityListLightningPage.
 *
 * @author Enrique Carrizales.
 * @version 1.0 22 March 2020.
 */
public class ChangeOpportunityOwnerLightningPopup extends AbstractBasePage {
    @FindBy(css = "div[class = 'autocompleteWrapper slds-grow'] input")
    private WebElement ownerNameTextBox;

    @FindBy(xpath = "//button[span[@class=' label bBody']] [@title='Change Owner']")
    private WebElement changeOwnerButton;

    private static final String OWNER_ITEM_LIST_LOCATOR_PARTIAL = "//li[a[div[div[@title='%s']]]]";
    private static final String JSON_CONFIG_FILE = "config.json";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(ownerNameTextBox));
    }

    /**
     * Clicks a TextBox.
     */
    public void clickOnOwnerNameTextBox() {
        ownerNameTextBox.click();
    }

    /**
     * Change an owner of an opportunity.
     * @param ownerType contains String value.
     */
    public void selectOwner(final String ownerType) {
        String ownerItemListLocator;
        String userName;

        JsonFileReader jsonFileReader = new JsonFileReader(JSON_CONFIG_FILE);
        userName = jsonFileReader.getUser(ownerType).getUsername();

        ownerNameTextBox.sendKeys(userName);

        ownerItemListLocator = String.format(OWNER_ITEM_LIST_LOCATOR_PARTIAL, userName);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(ownerItemListLocator)));
        webDriver.findElement(By.xpath(ownerItemListLocator)).click();
    }

    /**
     * Clicks on a button.
     */
    public void clickOnChangeOwnerButton() {
        changeOwnerButton.click();
    }
}
