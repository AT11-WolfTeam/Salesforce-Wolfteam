/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.home;

import salesforce.ui.components.menu.TopMenuAbstract;
import salesforce.ui.pages.AbstractBasePage;
import salesforce.ui.pages.AppPageFactory;

/**
 * Defines a abstract class page.
 *
 * @author Enrique Carrizales.
 * @version 1.0 17 March 2020.
 */
public abstract class AbstractHomePage extends AbstractBasePage {
    private TopMenuAbstract topMenu;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
    }

    /**
     * Returns a TopMenuAbstract class.
     * @return an instance.
     */
    public TopMenuAbstract getTopMenu() {
        return topMenu;
    }

    /**
     * Builds a HomePage class.
     */
    public AbstractHomePage() {
        topMenu = AppPageFactory.getTopMenu();
    }
}
