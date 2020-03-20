/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforcetest.steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;
import salesforce.api.AccountHelper;
import salesforce.entities.Account;
import salesforce.entities.Context;
import salesforce.utils.SheetManager;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Manages account steps.
 *
 * @author Juan Martinez.
 * @version 1.0 18 March 2020.
 */
public class AccountSteps {

    // Entities
    private Context context;

    private AccountHelper accountHelper;
    private ArrayList<HashMap<String, String>> accountMapList;

    /**
     * Account steps constructor.
     *
     * @param context object.
     */
    public AccountSteps(final Context context) {
        this.context = context;
        accountHelper = new AccountHelper();
    }

    /**
     * Allows to create account.
     *
     * @param quantity    number of accounts.
     * @param accountType value.
     */
    @Given("I create {int} {string} accounts")
    public void createAccount(final int quantity, final String accountType) {
        String sheetName = "Accounts";
        accountMapList = SheetManager.manageSheet(sheetName, quantity, accountType);
        ArrayList<Account> accounts = accountHelper.setAccounts(accountMapList);
        context.setAccounts(accounts);
        accountHelper.postAccounts(context.getAccounts());
    }

    /**
     * Deletes account.
     */
    @When("I delete created accounts")
    public void deleteAccounts() {
        accountHelper.deleteAccounts(context.getAccounts());
        final String expected = "204";
        for (Account account : context.getAccounts()) {
            Assert.assertEquals(account.getStatusCode(), expected);
        }
    }
}
