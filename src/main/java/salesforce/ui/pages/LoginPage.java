/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.utils.PropertiesReader;

/**
 * Manages Login Page instance.
 *
 * @author Alan Escalera.
 * @version 1.0 17 March 2020.
 */
public class LoginPage extends BasePage {
    @FindBy(id = "username")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "Login")
    private WebElement loginButton;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(passwordField));
    }

    /**
     * Logins on salesforce page.
     */
    public void loginSalesforce() {
        this.userNameField.sendKeys(PropertiesReader.getInstance().getUser().getUsername());
        this.passwordField.sendKeys(PropertiesReader.getInstance().getUser().getPassword());
        this.loginButton.click();
    }
}
