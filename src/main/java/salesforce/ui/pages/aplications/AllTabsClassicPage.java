/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.aplications;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.BasePage;

/**
 * Defines a AllTabsClassicPage page.
 *
 * @author Enrique Carrizales.
 * @version 1.0 18 March 2020.
 */
public class AllTabsClassicPage extends BasePage {
    @FindBy(css = "td[class='dataCol opportunityBlock col02']")
    private WebElement opportunityButton;

    @FindBy(css = "input[class='btnImportant']")
    private WebElement customTabsButton;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(customTabsButton));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(customTabsButton));
    }
}
