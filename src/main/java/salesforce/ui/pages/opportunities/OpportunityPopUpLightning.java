/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpportunityPopUpLightning extends OpportunityPageAbstract {
    @FindBy(css = "a[class='slds-grid slds-grid--vertical-align-center slds-grid--align-center sldsButtonHeightFix']")
    private WebElement verticalAlignButton;
    
    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }
}
