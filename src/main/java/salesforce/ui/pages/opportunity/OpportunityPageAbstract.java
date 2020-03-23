/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

<<<<<<< HEAD:src/main/java/salesforce/ui/pages/opportunities/opportunity/OpportunityPageAbstract.java
package salesforce.ui.pages.opportunities.opportunity;
=======
package salesforce.ui.pages.opportunity;
>>>>>>> 7e558496d83ca8606aa81dac59d0b17091d7466c:src/main/java/salesforce/ui/pages/opportunity/OpportunityPageAbstract.java

import salesforce.ui.pages.BasePage;

/**
 * Defines OpportunitiesPageClassic.
 *
 * @author Alan Escalera.
 * @version 1.0 19 March 2020.
 */
public abstract class OpportunityPageAbstract extends BasePage {

    /**
<<<<<<< HEAD:src/main/java/salesforce/ui/pages/opportunities/opportunity/OpportunityPageAbstract.java
     * Allows to open notes and attachments page.
     */
    public abstract void clickOnNotesAndAttachmentsButton();
=======
     * Changes an Opportunity owner.
     * @param ownerType contains a String value.
     */
    public abstract void changeOwner(String ownerType);
>>>>>>> 7e558496d83ca8606aa81dac59d0b17091d7466c:src/main/java/salesforce/ui/pages/opportunity/OpportunityPageAbstract.java
}
