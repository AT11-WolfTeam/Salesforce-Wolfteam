/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.product.productlist;

import salesforce.ui.pages.AbstractBasePage;

/**
 * Defines AbstractProductListPage.
 *
 * @author Alan Escalera.
 * @version 1.0 3 April 2020.
 */
public abstract class AbstractProductListPage extends AbstractBasePage {

    /**
     * Deletes a product.
     *
     * @param productName value.
     */
    public abstract void deleteAProduct(String productName);
}
