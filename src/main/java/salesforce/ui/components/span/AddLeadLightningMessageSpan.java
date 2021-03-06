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

/**
 * Manages a ToastAddMessageSpan.
 *
 * @author Enrique Carrizales.
 * @version 1.0 26 March 2020.
 */
public class AddLeadLightningMessageSpan extends AbstractUpdateLeadMessage {

    @FindBy(css = "div[class='toastTitle slds-text-heading--small']")
    private WebElement toastFirstMessage;

    @FindBy(css = "span[class='toastMessage forceActionsText']")
    private WebElement toastFirstPartSecondMessage;

    private static final String WHITE_SPACE = " ";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(toastFirstPartSecondMessage));
    }

    @Override
    public String getMessage() {
        String firstPartMessage = toastFirstMessage.getText() + WHITE_SPACE;
        String secondPartMessageText = toastFirstPartSecondMessage.getText();
        return firstPartMessage + secondPartMessageText;
    }
}
