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
