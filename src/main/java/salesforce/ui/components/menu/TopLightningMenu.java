/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.components.menu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Manages a web page.
 *
 * @author Enrique Carrizales.
 * @version 1.0 17 March 2020.
 */
public class TopLightningMenu extends TopMenuAbstract {

    @FindBy(css = "button[class = slds-button]")
    private WebElement btnApps;

    /**
     * Click on apps button.
     */
    @Override
    protected void clickOnAppsButton() {
        btnApps.click();
    }
}
