/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.entities;

import salesforce.entities.constants.ContractConstant;
import salesforce.utils.DateFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * Manages Contract instance.
 *
 * @author Alan Escalera.
 * @version 1.0 29 March 2020.
 */
public class Contract {
    private String contractNumber;
    private String accountName;
    private String status;
    private String startDate;
    private String contractTerm;

    /**
     * Gets accountName.
     *
     * @return account name value.
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * Sets accountName.
     *
     * @param accountName value.
     */
    public void setAccountName(final String accountName) {
        this.accountName = accountName;
    }

    /**
     * Gets status.
     *
     * @return status value.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status value.
     */
    public void setStatus(final String status) {
        this.status = status;
    }

    /**
     * Gets startDate.
     *
     * @return startDate value.
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets startDate.
     *
     * @param startDate value.
     */
    public void setStartDate(final String startDate) {
        this.startDate = DateFormatter.formatDateUi(startDate);
    }

    /**
     * Gets ContractTerm.
     *
     * @return ContractTerm value.
     */
    public String getContractTerm() {
        return contractTerm;
    }

    /**
     * Sets contractTerm.
     *
     * @param contractTerm value.
     */
    public void setContractTerm(final String contractTerm) {
        this.contractTerm = contractTerm;
    }

    /**
     * Gets ContractNumber.
     *
     * @return contractNumber value.
     */
    public String getContractNumber() {
        return contractNumber;
    }

    /**
     * Sets ContractNumber.
     *
     * @param contractNumber value.
     */
    public void setContractNumber(final String contractNumber) {
        this.contractNumber = contractNumber;
    }

    /**
     * Strategy process information.
     *
     * @param mapNewContract map.
     */
    public void processInformation(final Map<String, String> mapNewContract) {
        HashMap<String, Runnable> strategyMap = composeStrategy(mapNewContract);
        mapNewContract.keySet().forEach(key -> strategyMap.get(key).run());
    }

    /**
     * ComposeStrategy to set attributes.
     *
     * @param mapNewContract map.
     * @return HashMap values.
     */
    private HashMap<String, Runnable> composeStrategy(final Map<String, String> mapNewContract) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(ContractConstant.ACCOUNT, () -> setAccountName(mapNewContract.get(ContractConstant.ACCOUNT)));
        strategyMap.put(ContractConstant.STATUS, () -> setStatus(mapNewContract.get(ContractConstant.STATUS)));
        strategyMap.put(ContractConstant.START_DATE, () -> setStartDate(mapNewContract.get(ContractConstant.
                START_DATE)));
        strategyMap.put(ContractConstant.CONTRACT_TERM, () -> setContractTerm(mapNewContract.get(ContractConstant.
                CONTRACT_TERM)));
        return strategyMap;
    }
}
