package salesforce.ui.pages.leadlist;

import salesforce.entities.Lead;

import java.util.List;

/**
 * Manages LeadListClassicPage.
 *
 * @author Enrique Carrizales.
 * @version 1.0 29 March 2020.
 */
public class LeadListClassicPage extends AbstractLeadListPage {
    @Override
    public void changeLeadStatus(final List<Lead> leads) {

    }

    @Override
    public List<Lead> getLeadsUpdated(final List<Lead> leads) {
        return null;
    }

    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }
}
