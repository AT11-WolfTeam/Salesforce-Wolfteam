/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Checks if web element is displayed.
 *
 * @author Juan Martinez.
 * @version 1.0 25 March 2020.
 */
public final class WebElementChecker {

    /**
     * Allows to verify if the web element is displayed or does not exist.
     *
     * @param webDriver instance.
     * @param by        value.
     * @return true if the web element is displayed and false if it is not there.
     */
    public static boolean webElementIsDisplayed(final WebDriver webDriver, final String by) {
        try {
            webDriver.findElement(By.xpath(by)).isDisplayed();
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
