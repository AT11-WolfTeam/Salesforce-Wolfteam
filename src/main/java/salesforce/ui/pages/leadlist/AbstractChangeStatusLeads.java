/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.leadlist;

import salesforce.ui.pages.AbstractBasePage;

/**
 * Manages AbstractChangeStatusLeads.
 *
 * @author Enrique Carrizales.
 * @version 1.0 29 March 2020.
 */
public abstract class AbstractChangeStatusLeads extends AbstractBasePage {

    /**
     * Selects a status.
     *
     * @param statusLeads contains a String value.
     */
    public abstract void selectStatusLeads(String statusLeads);
}
