/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.contract;

import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.opportunity.newopportunity.AbstractNewOpportunity;

/**
 * Defines ContractClassicPage.
 *
 * @author Alan Escalera.
 * @version 1.0 28 March 2020.
 */
public class ContractClassicPage extends AbstractContractPage {
    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public AbstractNewOpportunity clickOnNewOpportunity() {
        //To Do
        return AppPageFactory.getNewOpportunityPage();
    }
}
