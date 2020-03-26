/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.lead;

import salesforce.ui.pages.AbstractBasePage;

/**
 * Defines AddLeadsCampaignPopup.
 *
 * @author Enrique Carrizales.
 * @version 1.0 26 March 2020.
 */
public class AddLeadsCampaignLightningPopup extends AbstractBasePage {
    private static final String TABLE_ITEM_PARTIAL_CHECK_BOX_LOCATOR =
            "//tr[th[span[a[contains(.,'%s')]]] and td[span[span[contains(.,'%s')]]] and td[span[span"
                    + "[contains(.,'%s')]]]]//../span[@class='slds-checkbox--faux']";

    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }
}
