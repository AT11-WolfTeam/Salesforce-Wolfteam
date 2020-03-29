/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforcetest.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import salesforce.entities.Context;
import salesforce.entities.Contract;
import salesforce.ui.components.span.ToastUpdateObjectMessage;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.genericTabs.AbstractTabObjectsPage;
import salesforce.ui.pages.newcontract.AbstractNewContractPage;
import salesforce.ui.pages.newopportunity.AbstractNewOpportunityPage;

import java.util.Map;

public class ContractSteps {
    private Context context;
    private AbstractTabObjectsPage abstractTabObjectsPage;
    private AbstractNewContractPage abstractNewContractPage;
    private Contract contract;
    private ToastUpdateObjectMessage toastUpdateObjectMessage;
    private AbstractNewOpportunityPage abstractNewOpportunityPage;

    public ContractSteps(Context context) {
        this.context = context;
    }

    @And("I create New Contract with")
    public void iCreateNewContractWith(final Map<String, String> mapNewContract) {
        abstractTabObjectsPage = AppPageFactory.getTabObjectsPage();
        abstractTabObjectsPage.clickOnNewButton();
        abstractNewContractPage = AppPageFactory.getNewContractPage();
        contract = context.getContract();
        contract.processInformation(mapNewContract);
        abstractNewContractPage.setNewContract(contract, mapNewContract.keySet());
        abstractNewContractPage.clickSaveContract();
        toastUpdateObjectMessage = new ToastUpdateObjectMessage();
        String contractNumber = toastUpdateObjectMessage.getMessage().replace("\\D+","");
        contract.setContractNumber(contractNumber);
    }

    @And("I create New Opportunity with")
    public void iCreateNewOpportunityWith() {
        abstractTabObjectsPage.clickOnNewButton();
        abstractNewOpportunityPage.clickSaveOpportunityButton();

    }

    @When("I close the opportunity as {string}")
    public void iCloseTheOpportunityAs(String arg0) {

    }

    @Then("the application should display a message {string}")
    public void theApplicationShouldDisplayAMessage(String arg0) {

    }

    @And("On opportunities object should be display current stage")
    public void onOpportunitiesObjectShouldBeDisplayCurrentStage() {
    }
}
