/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.contractlist;

import salesforce.ui.pages.AbstractBasePage;

public abstract class AbstractContractListPage extends AbstractBasePage {

    /**
     * Deletes a contract selected.
     *
     * @param contractNumber value.
     */
    public abstract void deleteContract(String contractNumber);
}
