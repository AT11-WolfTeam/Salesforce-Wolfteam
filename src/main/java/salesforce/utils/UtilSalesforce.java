/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.utils;

import core.selenium.WebDriverManager;
import core.utils.GradleReader;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Manages UtilSalesforce.
 *
 * @author Alan Escalera.
 * @version 1.0 23 March 2020.
 */
public class UtilSalesforce {
    private static final int TWO_WINDOWS = 2;
    private static final int INTENTS = 3;
    private static final int MILLISECONDS_SLEEP = 500;
    private static final String MESSAGE_RETRY = "Retrying click ...";
    private static final String MESSAGE_EXCEPTION = "Could not execute click on: ";

    /**
     * Switches to new windows.
     *
     * @param parentHandle string value.
     */
    public static void switchToNewWindow(final String parentHandle) {
        WebDriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.numberOfWindowsToBe(TWO_WINDOWS));
        Set<String> handles = WebDriverManager.getInstance().getWebDriver().getWindowHandles();
        for (String winHandle : handles) {
            if (!parentHandle.equals(winHandle)) {
                WebDriverManager.getInstance().getWebDriver().switchTo().window(winHandle);
                break;
            }
        }
    }

    /**
     * Verifies if the web element is displayed.
     *
     * @param webElement value.
     * @param intervalTime value.
     * @return boolean value.
     */
    public static boolean isElementDisplayed(final WebElement webElement, final int intervalTime) {
        WebDriver webDriver = WebDriverManager.getInstance().getWebDriver();
        webDriver.manage().timeouts().implicitlyWait(intervalTime, TimeUnit.MILLISECONDS);
        try {
            return webElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            webDriver.manage().timeouts().implicitlyWait(GradleReader.getInstance().getImplicitWait(), TimeUnit
                    .MILLISECONDS);
        }
    }

    /**
     * Retries clicks when a webElement is no visible.
     *
     * @param webElement to click.
     * @param webElementIsVisible value.
     * @param intervalTime value.
     */
    public static void retryClick(final WebElement webElement, final WebElement webElementIsVisible,
                                  final int intervalTime) {
        int i = 0;

        do {
            try {
                if (!isElementDisplayed(webElementIsVisible, intervalTime)) {
                    webElement.click();
                    Thread.sleep(MILLISECONDS_SLEEP);
                } else {
                    return;
                }
            } catch (RuntimeException | InterruptedException Ex) {
                System.out.println(MESSAGE_RETRY);
            }
        } while (++i < INTENTS);
        throw new RuntimeException(MESSAGE_EXCEPTION + webElement.toString());
    }
}
