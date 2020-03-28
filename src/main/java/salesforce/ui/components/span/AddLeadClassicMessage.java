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
 * Manages a ToastUpdateLeadClassicMessage.
 *
 * @author Enrique Carrizales.
 * @version 1.0 27 March 2020.
 */
public class AddLeadClassicMessage extends AbstractUpdateLeadMessage {

    @FindBy(css = "td[class='messageCell'] div h4")
    private WebElement message;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(message));
    }

    @Override
    public String getMessage() {
        return message.getText();
    }
}
