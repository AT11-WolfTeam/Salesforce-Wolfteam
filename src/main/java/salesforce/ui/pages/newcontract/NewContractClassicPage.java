/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.newcontract;

import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.contract.AbstractContractPage;

/**
 * Defines NewContractClassicPage.
 *
 * @author Alan Escalera.
 * @version 1.0 28 March 2020.
 */
public class NewContractClassicPage extends AbstractNewContractPage {
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        //To Do
    }

    @Override
    protected void setAccount(final String accountName) {
        //To Do
    }

    @Override
    protected void setStatus(final String status) {
        //To Do
    }

    @Override
    protected void setContractStartDate(final String startDate) {
        //To Do
    }

    @Override
    protected void setContractTerm(final String contractTerm) {
        //To Do
    }

    @Override
    public AbstractContractPage clickSaveContract() {
        //To Do
        return AppPageFactory.getContractPage();
    }
}
