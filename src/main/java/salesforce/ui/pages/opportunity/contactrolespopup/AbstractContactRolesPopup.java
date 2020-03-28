/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunity.contactrolespopup;

import salesforce.ui.pages.AbstractBasePage;
import salesforce.ui.pages.opportunity.opportunitycontactroles.AbstractContactRolesPage;

import java.util.HashMap;

/**
 * Manages contact roles popups.
 *
 * @author Juan Martinez.
 * @version 1.0 26 March 2020.
 */
public abstract class AbstractContactRolesPopup extends AbstractBasePage {

    /**
     * Selects contacts.
     * @param contactsList values.
     * @return contact roles instance.
     */
    public abstract AbstractContactRolesPage selectContacts(HashMap<String, String> contactsList);
}
