/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunity;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Defines an OpportunityLightningPage.
 *
 * @author Enrique Carrizales.
 * @version 1.0 21 March 2020.
 */
public class OpportunityLightningPage extends OpportunityPageAbstract {

    @FindBy(css = "div[data-aura-class='forceOutputOwnerIdLookupWithChangeLink'] button")
    //svg[data-key='change_owner']
    private WebElement changeOwnerButton;

    @FindBy(css = "span[class='view-all-label']")
    private WebElement viewAllLinkText;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(viewAllLinkText));
    }

    @Override
    public void changeOwner(final String ownerType) {
        changeOwnerButton.click();
        ChangeOpportunityOwnerLightningPopup changeOpportunityOwnerPopup = new ChangeOpportunityOwnerLightningPopup();
        changeOpportunityOwnerPopup.clickOnOwnerNameTextBox();
        changeOpportunityOwnerPopup.selectOwner(ownerType);
        changeOpportunityOwnerPopup.clickOnChangeOwnerButton();
    }
}
