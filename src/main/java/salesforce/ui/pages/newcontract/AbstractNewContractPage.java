/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.newcontract;

import salesforce.ui.pages.AbstractBasePage;
import salesforce.ui.pages.contract.AbstractContractPage;

/**
 * Defines AbstractNewContractPage.
 *
 * @author Alan Escalera.
 * @version 1.0 28 March 2020.
 */
public abstract class AbstractNewContractPage extends AbstractBasePage {

    /**
     * Sets Account.
     * @param accountName value.
     */
    protected abstract void setAccount(String accountName);

    /**
     * Sets Status.
     * @param status value.
     */
    protected abstract void setStatus(String status);

    /**
     * Sets Contract start date
     * @param startDate value.
     */
    protected abstract void setContractStartDate(String startDate);

    /**
     * Sets contract term.
     * @param contractTerm value.
     */
    protected abstract void setContractTerm(String contractTerm);

    /**
     * Clicks on Save contract.
     * @return AbstractContractPage instance.
     */
    public abstract AbstractContractPage clickSaveContract();
}
