package salesforce.ui.pages.leadlist;

import salesforce.entities.Lead;
import salesforce.ui.pages.AbstractBasePage;

import java.util.List;

/**
 * Manages AbstractLeadListPage.
 *
 * @author Enrique Carrizales.
 * @version 1.0 29 March 2020.
 */
public abstract class AbstractLeadListPage extends AbstractBasePage {

    /**
     * Changes Lead Status of leads.
     *
     * @param leads contains a list value.
     */
    public void changeLeadStatus(final List<Lead> leads) {
        for (Lead lead : leads) {
            clickOnCheckButton(lead);
        }
        clickOnChangeStatusLeadButton();
    }

    /**
     * Reviews leads in a page.
     *
     * @param leads contains a list value.
     * @return int value.
     */
    public abstract List<Lead> getLeadsUpdated(List<Lead> leads);

    /**
     * Clicks on a button.
     */
    protected abstract void clickOnChangeStatusLeadButton();

    /**
     * Clicks on a button.
     *
     * @param lead contains an object.
     */
    protected abstract void clickOnCheckButton(Lead lead);
}
