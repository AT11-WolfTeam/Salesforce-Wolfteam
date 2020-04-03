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
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import salesforce.ui.pages.LoginPage;
import salesforce.ui.pages.PageTransporter;

/**
 * Manages execution hooks.
 *
 * @author Enrique Carrizales.
 * @version 1.0 16 March 2020.
 */
public class RunCukeTest extends AbstractTestNGCucumberTests {
    private static final String LOGIN_PAGE = "Login Page";
    private WebDriver webDriver;

    public RunCukeTest() {
        this.webDriver = WebDriverManager.getInstance().getWebDriver();
    }

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
    public void afterExecution(final Scenario scenario) {
        Report.getInstance().generateReport();
        WebDriverManager.getInstance().quitDriver();
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
    }
}
