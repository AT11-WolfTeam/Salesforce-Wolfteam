/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunities;

import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Defines OpportunityPopUpLightning.
 *
 * @author Alan Escalera.
 * @version 1.0 19 March 2020.
 */
public class OpportunityPopUpLightning extends OpportunityPageAbstract {
    private WebElement campaignNameSelect;

    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    @Override
    protected void assignCampaign(final String campaignName) {
        String campaignNameCss = String.format(CAMPAIGN_NAME, campaignName);
        campaignNameSelect = WebDriverManager.getInstance().getWebDriver().findElement(By.cssSelector(campaignNameCss));
        campaignNameSelect.click();
    }
}
