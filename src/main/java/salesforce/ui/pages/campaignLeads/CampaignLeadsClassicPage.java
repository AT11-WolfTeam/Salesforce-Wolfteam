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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.entities.Lead;
import java.util.ArrayList;
import java.util.List;

/**
 * Defines CampaignLeadsClassicPage.
 *
 * @author Enrique Carrizales.
 * @version 1.0 27 March 2020.
 */
public class CampaignLeadsClassicPage extends AbstractCampaignLeadsPage {

    @FindBy(xpath = "//span[text()='Previous']")
    private WebElement previousLabel;

    private static final String LEAD_ROW_PARTIAL_LOCATOR = "//tr[td[div[a[span[text()='%1$s']]]] and td[div[text()="
            + "'%2$s']]]";

    @Override
    public int countLeadsInList(final List<Lead> leadList) {
        List<WebElement> webElementsLeads = new ArrayList<>();
        for (Lead lead : leadList) {
            String leadRowLocator = String.format(LEAD_ROW_PARTIAL_LOCATOR, lead.getLastName(), lead.getCompany());
            webElementsLeads.add(webDriver.findElement(By.xpath(leadRowLocator)));
        }
        return webElementsLeads.size();
    }

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(previousLabel));
    }
}
