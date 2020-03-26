/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.campaignmembers;

import salesforce.ui.pages.AbstractBasePage;
import java.util.HashMap;

/**
 * Manages campaign members.
 *
 * @author Juan Martinez.
 * @version 1.0 24 March 2020
 */
public abstract class AbstractCampaignMembersPage extends AbstractBasePage {

    /**
     * Gets contacts name.
     * @param contacts list.
     * @return list of names.
     */
    public abstract HashMap<String, String> getContactsText(HashMap<String, String> contacts);
}
