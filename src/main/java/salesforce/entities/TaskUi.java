/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.entities;

/**
 * Manages Task information.
 *
 * @author Alan Escalera.
 * @version 1.0 24 March 2020.
 */
public class TaskUi {
    private String status;
    private String priority;
    private String account;

    /**
     * Returns status value.
     *
     * @return string value.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets status value.
     *
     * @param status value.
     */
    public void setStatus(final String status) {
        this.status = status;
    }

    /**
     * Returns priority value.
     *
     * @return string value.
     */
    public String getPriority() {
        return priority;
    }

    /**
     * Sets priority value.
     *
     * @param priority value.
     */
    public void setPriority(final String priority) {
        this.priority = priority;
    }

    /**
     * Returns account value.
     *
     * @return string value.
     */
    public String getAccount() {
        return account;
    }

    /**
     * Sets account value.
     *
     * @param account value.
     */
    public void setAccount(final String account) {
        this.account = account;
    }
}
