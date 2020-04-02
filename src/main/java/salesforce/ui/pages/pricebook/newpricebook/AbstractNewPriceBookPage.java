/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.pricebook.newpricebook;

import salesforce.entities.PriceBook;
import salesforce.entities.constants.PriceBookConstant;
import salesforce.ui.pages.AbstractBasePage;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.pricebook.AbstractPriceBookPage;
import java.util.HashMap;
import java.util.Set;

/**
 * Defines AbstractNewPriceBookPage.
 *
 * @author Alan Escalera.
 * @version 1.0 1 April 2020.
 */
public abstract class AbstractNewPriceBookPage extends AbstractBasePage {

    /**
     * Clicks on save button.
     */
    protected abstract void clickOnSaveButton();

    /**
     * Sets price book name.
     * @param priceBookName value.
     */
    protected abstract void setPriceBookName(String priceBookName);

    /**
     * Sets the form of price book information.
     *
     * @param priceBook entity.
     * @param fields map.
     * @return PriceBook instance.
     */
    public AbstractPriceBookPage setPriceBookInformation(final PriceBook priceBook, final Set<String> fields) {
        HashMap<String, Runnable> strategtyMap = composeStrategyMap(priceBook);
        fields.forEach(field -> strategtyMap.get(field).run());
        clickOnSaveButton();
        return AppPageFactory.getPriceBookPage();
    }

    /**
     * Sets the information of new price book.
     *
     * @param priceBook entity.
     * @return HashMap value.
     */
    protected HashMap<String, Runnable> composeStrategyMap(final PriceBook priceBook) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(PriceBookConstant.PRICE_BOOK_NAME, () -> setPriceBookName(priceBook.getPriceBookName()));
        return strategyMap;
    }
}
