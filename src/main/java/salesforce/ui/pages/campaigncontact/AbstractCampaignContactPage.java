/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.campaigncontact;

import salesforce.ui.pages.AbstractBasePage;

import java.util.HashMap;

/**
 * Manages campaign contacts.
 *
 * @author Juan Martinez.
 * @version 1.0 25 March 2020.
 */
public abstract class AbstractCampaignContactPage extends AbstractBasePage {

    /**
     * Checks contacts checkbox.
     *
     * @param namesOfContacts list.
     */
    public abstract void checkContacts(HashMap<String, String> namesOfContacts);
}
