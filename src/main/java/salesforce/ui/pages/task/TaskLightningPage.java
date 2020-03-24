/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class TaskLightningPage extends AbstractTask {
    @FindBy(xpath = "//button[@title='Edit Name']")
    private WebElement editButton;

    @FindBy(xpath = "//div[@class='active']//span[text()='Status']/../..//a")
    private WebElement statusField;

    private static final String STATUS = "//a[@title='%s']";

    Actions actions;

    public TaskLightningPage () {
        actions = new Actions(webDriver);
    }


    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public void clickEditButton() {
        editButton.click();
    }

    private void clickOnStatusField() {
        statusField.click();
    }

    @Override
    public void selectStatus(final String statusSelect) {
        clickOnStatusField();
        clickOnStatusToSelect(statusSelect);
    }

    private void clickOnStatusToSelect(final String statusSelect) {
        String statusXpath = String.format(STATUS, statusSelect);
        statusToSelected = webDriver.findElement(By.cssSelector(statusXpath));
        actions.moveToElement(statusToSelected).click().build().perform();
    }
}
