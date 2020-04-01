/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.newcontract;

import salesforce.entities.Contract;
import salesforce.entities.constants.ContractConstant;
import salesforce.ui.pages.AbstractBasePage;
import salesforce.ui.pages.contract.AbstractContractPage;
import java.util.HashMap;
import java.util.Set;

/**
 * Defines AbstractNewContractPage.
 *
 * @author Alan Escalera.
 * @version 1.0 28 March 2020.
 */
public abstract class AbstractNewContractPage extends AbstractBasePage {

    /**
     * Sets Account.
     *
     * @param accountName value.
     */
    protected abstract void setAccount(String accountName);

    /**
     * Sets Status.
     *
     * @param status value.
     */
    protected abstract void setStatus(String status);

    /**
     * Sets Contract start date.
     *
     * @param startDate value.
     */
    protected abstract void setContractStartDate(String startDate);

    /**
     * Sets contract term.
     *
     * @param contractTerm value.
     */
    protected abstract void setContractTerm(String contractTerm);

    /**
     * Clicks on Save contract.
     *
     * @return AbstractContractPage instance.
     */
    public abstract AbstractContractPage clickSaveContract();

    /**
     * Sets the form of new Contract.
     *
     * @param contract entity.
     * @param fields   map.
     */
    public void setNewContract(final Contract contract, final Set<String> fields) {
        HashMap<String, Runnable> strategtyMap = composeStrategyMap(contract);
        fields.forEach(field -> strategtyMap.get(field).run());
    }

    /**
     * Sets the information of new Contract.
     *
     * @param contract entity.
     * @return HashMap value.
     */
    protected HashMap<String, Runnable> composeStrategyMap(final Contract contract) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(ContractConstant.ACCOUNT, () -> setAccount(contract.getAccountName()));
        strategyMap.put(ContractConstant.STATUS, () -> setStatus(contract.getStatus()));
        strategyMap.put(ContractConstant.START_DATE, () -> setContractStartDate(contract.getStartDate()));
        strategyMap.put(ContractConstant.CONTRACT_TERM, () -> setContractTerm(contract.getContractTerm()));
        return strategyMap;
    }
}
