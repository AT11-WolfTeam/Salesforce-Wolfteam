/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.task;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskLightningPage extends AbstractTask {
    @FindBy(xpath = "//button[@title='Edit Name']")
    private WebElement editButton;

    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public void clickEditButton() {
        editButton.click();
    }
}
