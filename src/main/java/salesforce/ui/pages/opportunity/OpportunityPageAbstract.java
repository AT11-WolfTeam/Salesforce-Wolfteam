/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunity;

import salesforce.ui.pages.BasePage;

/**
 * Defines OpportunitiesPageClassic.
 *
 * @author Alan Escalera.
 * @version 1.0 19 March 2020.
 */
public abstract class OpportunityPageAbstract extends BasePage {

    /**
     * Changes an Opportunity owner.
     * @param ownerType contains a String value.
     */
    public abstract void changeOwner(final String ownerType);
}
