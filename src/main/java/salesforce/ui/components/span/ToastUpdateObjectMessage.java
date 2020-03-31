/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.components.span;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.AbstractBasePage;

/**
 * Manages a ToastMessageSpan.
 *
 * @author Enrique Carrizales.
 * @version 1.0 22 March 2020.
 */
public class ToastUpdateObjectMessage extends AbstractBasePage {

    @FindBy(css = "span[class='toastMessage slds-text-heading--small forceActionsText']")
    private WebElement toastMessage;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(toastMessage));
    }

    /**
     * Returns a message.
     *
     * @return a String value.
     */
    public String getMessage() {
        return toastMessage.getText();
    }
}
