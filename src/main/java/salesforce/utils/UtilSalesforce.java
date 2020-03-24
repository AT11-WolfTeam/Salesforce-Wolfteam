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
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.Set;

/**
 * Manages UtilSalesforce.
 *
 * @author Alan Escalera.
 * @version 1.0 23 March 2020.
 */
public class UtilSalesforce {
    private static final int TWO_WINDOWS = 2;

    /**
     * Switches to new windows.
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
}
