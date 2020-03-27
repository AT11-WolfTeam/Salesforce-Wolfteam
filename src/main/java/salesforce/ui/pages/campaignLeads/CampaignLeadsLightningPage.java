/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.campaignLeads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import salesforce.entities.Lead;
import salesforce.ui.pages.AbstractBasePage;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines CampaignMembersLightningPage.
 *
 * @author Enrique Carrizales.
 * @version 1.0 26 March 2020.
 */
public class CampaignLeadsLightningPage extends AbstractBasePage {

    private static final String LEAD_ROW_PARTIAL_LOCATOR = "//tr[*[span[*[text()='Lead']]] and td[span[*[text()='%1$s'"
            + "]]] and td[span[*[text()='%2$s']]]]";

    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Counts leads added to a campaign.
     *
     * @param leadList contains a list value.
     * @return a int value.
     */
    public int countLeadsInList(final List<Lead> leadList) {
        List<WebElement> webElementsLeads = new ArrayList<>();
        for (Lead lead : leadList) {
            String leadRowLocator = String.format(LEAD_ROW_PARTIAL_LOCATOR, lead.getLastName(), lead.getCompany());
            webElementsLeads.add(webDriver.findElement(By.xpath(leadRowLocator)));
        }
        return webElementsLeads.size();
    }
}
