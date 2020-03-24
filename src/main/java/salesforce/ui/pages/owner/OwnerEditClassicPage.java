/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.owner;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.AbstractBasePage;
import salesforce.utils.JsonFileReader;

/**
 * Defines an OwnerEditClassicPage.
 *
 * @author Enrique Carrizales.
 * @version 1.0 23 March 2020.
 */
public class OwnerEditClassicPage extends AbstractBasePage {
    @FindBy(css = "input[id='newOwn']")
    private WebElement ownerNameTexBox;

    @FindBy(css = "input[class='btn'][name='save']")
    private WebElement saveButton;

    private static final String JSON_CONFIG_FILE = "config.json";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(saveButton));
    }

    /**
     * Sends tex to ownerNameTexBox.
     * @param ownerType contains a String value.
     */
    public void setOwnerNameTexBox(final String ownerType) {
        String userName;
        JsonFileReader jsonFileReader = new JsonFileReader(JSON_CONFIG_FILE);
        userName = jsonFileReader.getUser(ownerType).getUsername();
        ownerNameTexBox.sendKeys(userName);
    }

    /**
     * Clicks on Save button.
     */
    public void clickOnSaveButton() {
        saveButton.click();
    }
}
