/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.task;

import org.openqa.selenium.WebElement;
import salesforce.ui.pages.AbstractBasePage;

public abstract class AbstractTask extends AbstractBasePage {
    protected WebElement statusToSelected;

    /**
     * Clicks on edit button.
     */
    public abstract void clickEditButton();

    /**
     * Select status.
     */
    public abstract void selectStatus(final String statusToSelect);
}
