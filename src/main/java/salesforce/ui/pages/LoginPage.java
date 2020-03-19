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

import salesforce.utils.JsonFileReader;
import salesforce.utils.SalesforceUser;

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

    private static final String JSON_FILE_NAME = "config.json";
    private static final String USER_TYPE = "Admin User";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(passwordField));
    }

    /**
     * Logins on salesforce page.
     */
    public void loginSalesforce() {
        JsonFileReader jsonFileReader = new JsonFileReader(JSON_FILE_NAME);
        SalesforceUser salesforceUser = jsonFileReader.getUser(USER_TYPE);
        this.userNameField.sendKeys(salesforceUser.getUsername());
        this.passwordField.sendKeys(salesforceUser.getPassword());
        this.loginButton.click();
    }
}
