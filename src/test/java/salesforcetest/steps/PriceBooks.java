/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforcetest.steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

/**
 * Defines price books.
 */
public class PriceBooks {
    /**
     * test price book.
     *
     * @param arg0 value.
     */
    @Given("I login as {string}")
    public void iLoginAs(final String arg0) {

    }

    /**
     * test price book.
     *
     * @param arg0 value.
     */
    @And("I create product as ProductTest{int}")
    public void iCreateProductAsProductTest(final int arg0) {

    }

    /**
     * test price book.
     *
     * @param arg0 value.
     * @throws Exception exception.
     */
    @And("I create PriceBook as {string}")
    public void iCreatePriceBookAs(final String arg0) throws Exception {
        throw new Exception("Failed");

    }

    /**
     * test price book.
     *
     * @param arg0 value.
     */
    @And("I search {string}")
    public void iSearch(final String arg0) {

    }

    /**
     * test price book.
     */
    @When("To do")
    public void toDo() {
        throw new PendingException();
    }
}
