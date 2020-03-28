/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunity.opportunitycontactroles;

import salesforce.ui.pages.AbstractBasePage;
import salesforce.ui.pages.opportunity.AbstractOpportunityPage;
import salesforce.ui.pages.opportunity.contactrolespopup.AbstractContactRolesPopup;

import java.util.HashMap;

/**
 * Manages contact roles of an opportunity.
 *
 * @author Juan Martinez.
 * @version 1.0 26 March 2020.
 */
public abstract class AbstractContactRolesPage extends AbstractBasePage {

    /**
     * Clicks on add contact roles.
     * @return contact roles popup instance.
     */
    public abstract AbstractContactRolesPopup addContactRoles();

    /**
     * Verify contacts roles.
     * @param contactRolList values.
     * @return a map of strings.
     */
    public abstract HashMap<String, String> verifyContactRoles(HashMap<String, String> contactRolList);

    /**
     * Sets contact roles.
     * @param contactsList values.
     * @return opportunity classic instance.
     */
    public abstract AbstractOpportunityPage setContacts(HashMap<String, String> contactsList);
}
