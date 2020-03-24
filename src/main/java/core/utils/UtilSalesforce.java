/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package core.utils;

import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class UtilSalesforce {

    public static void switchToNewWindow(final String parentHandle) {
        WebDriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> handles = WebDriverManager.getInstance().getWebDriver().getWindowHandles();
        for (String winHandle : handles) {
            if (!parentHandle.equals(winHandle)) {
                WebDriverManager.getInstance().getWebDriver().switchTo().window(winHandle);
                break;
            }
        }
    }
}
