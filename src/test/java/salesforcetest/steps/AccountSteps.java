/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforcetest.steps;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.Assert;
import salesforce.entities.Context;
import salesforce.api.AccountHelper;
import salesforce.utils.ExcelReader;
import salesforce.utils.SheetManager;

import org.apache.poi.ss.usermodel.Sheet;

import io.cucumber.java.en.Given;

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
     * @param context object.
     */
    public AccountSteps(Context context) {
        this.context = context;
        accountHelper = new AccountHelper(context);
    }

    @Given("I create {int} {string} accounts")
    public void createAccount(int quantity, String accountType) {
        Sheet dataSheet = ExcelReader.readExcel("Contacts");
        accountMapList = SheetManager.manageSheet(dataSheet, quantity, accountType);
        accountHelper.createEntity(accountMapList);
    }

    @Given("I delete created accounts")
    public void deleteAccounts() {
        accountHelper.deleteAccount(context.getIdsMap());
        int expected = 204;
        for (int statusCode: context.getDeleteEntity().values()) {
            Assert.assertEquals(statusCode, expected);
        }
    }
}
