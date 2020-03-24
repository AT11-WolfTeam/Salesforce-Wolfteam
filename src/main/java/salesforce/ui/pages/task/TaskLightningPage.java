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

    @FindBy(xpath = "/html/body/div[4]/div[1]/section/div/div/div[1]/div[2]/div/div[1]/div/div[2]/div/div/div/section/div/div/article/div[3]/div/div[1]/div/div[1]/div/div/div[1]/div[2]/div/div/div/div/div[1]/div/div/a")
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

    @Override
    public void selectStatus(String statusSelect) {
        String statusXpath = String.format(STATUS, statusSelect);
        statusToSelected = webDriver.findElement(By.cssSelector(statusXpath));
        actions.moveToElement(statusToSelected).click().build().perform();
    }

}
