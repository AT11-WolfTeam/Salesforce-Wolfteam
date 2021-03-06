/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.leadlist;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * Manages ChangeStatusLeadsClassicPage.
 *
 * @author Enrique Carrizales.
 * @version 1.0 29 March 2020.
 */
public class ChangeStatusLeadsClassicPage extends AbstractChangeStatusLeads {

    @FindBy(css = "td[class='pbButtonb'] input[name='save']")
    private WebElement saveButton;

    @FindBy(css = "select[id=p0]")
    private WebElement leadStatusListBox;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(saveButton));
    }

    @Override
    public void selectStatusLeads(final String statusLeads) {
        Select select = new Select(leadStatusListBox);
        select.selectByVisibleText(statusLeads);
        clickOnSaveButton();
    }

    /**
     * Clicks on a button "Save button".
     */
    private void clickOnSaveButton() {
        saveButton.click();
    }
}
