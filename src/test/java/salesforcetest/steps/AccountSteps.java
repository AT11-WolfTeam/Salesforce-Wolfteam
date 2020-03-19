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

import salesforce.entities.Account;
import salesforce.entities.Context;
import salesforce.restclient.AccountHelper;
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
    private Account account;
    private Context context;
    private SheetManager sheetManager;
    private AccountHelper accountHelper;

    public AccountSteps(Context context) {
        this.context = context;
        this.accountHelper = new AccountHelper();
        this.sheetManager = new SheetManager();
    }

    @Given("created {int} {string} accounts")
    public void createdAccounts(int quantity, String accountType) {
        Sheet dataSheet = ExcelReader.readExcel("Accounts.xlsx");
        ArrayList<HashMap<String, String>> accountMapList = sheetManager.manageSheet(dataSheet, quantity, accountType);
        for (HashMap<String, String> accountItem: accountMapList) {
            account = new Account();
            account.setAccountInformation(accountItem);
            context.setAccount(account);
        }
        accountHelper.convertToJson(context.getAccounts());
    }

}
