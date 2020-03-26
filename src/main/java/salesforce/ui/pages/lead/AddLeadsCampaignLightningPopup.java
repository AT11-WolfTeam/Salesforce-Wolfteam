/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.lead;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.entities.Lead;
import salesforce.ui.pages.AbstractBasePage;
import java.util.List;

/**
 * Defines AddLeadsCampaignPopup.
 *
 * @author Enrique Carrizales.
 * @version 1.0 26 March 2020.
 */
public class AddLeadsCampaignLightningPopup extends AbstractBasePage {

    @FindBy(css = "button[class*='slds-button slds-button--neutral button--'")
    private WebElement nextButton;

    private static final String TABLE_ITEM_PARTIAL_CHECK_BOX_LOCATOR =
            "//tr[th[span[a[contains(.,'%1$s')]]] and td[span[span[contains(.,'%2$s')]]] and td[span[span"
                    + "[contains(.,'%3$s')]]]]//../span[@class='slds-checkbox--faux']";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(nextButton));
    }

    /**
     * Adds leads to a campaign.
     * @param leads contains a list value.
     */
    public void addLead(final List<Lead> leads) {
        for (Lead lead : leads) {
            String rowCheckLocator = String.format(TABLE_ITEM_PARTIAL_CHECK_BOX_LOCATOR, lead.getName(), lead
                    .getCompany(), lead.getLeadStatus());
            webDriver.findElement(By.xpath(rowCheckLocator)).click();
        }
    }
}
