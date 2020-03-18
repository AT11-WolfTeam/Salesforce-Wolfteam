/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforcetest.runner;

import core.report.Report;

import core.selenium.WebDriverManager;

import io.cucumber.testng.AbstractTestNGCucumberTests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import ui.pages.LoginPage;
import ui.pages.PageTransporter;

/**
 * Manages execution hooks.
 *
 * @author Enrique Carrizales.
 * @version 1.0 16 March 2020.
 */
public class RunCukeTest extends AbstractTestNGCucumberTests {

    private static final String LOGIN_PAGE = "Login Page";

    /**
     * Executes code block before tests execution.
     */
    @BeforeTest
    public void beforeExecution() {
        PageTransporter pageTransporter = new PageTransporter();
        pageTransporter.navigateToPage(LOGIN_PAGE);
        LoginPage loginPage = new LoginPage();
        loginPage.loginSalesforce();
    }

    /**
     * Executes code block after tests execution.
     */
    @AfterTest
    public void afterExecution() {
        Report.getInstance().generateReport();
        WebDriverManager.getInstance().quitDriver();
    }
}
