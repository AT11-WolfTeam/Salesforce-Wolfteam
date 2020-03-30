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
import org.junit.Assert;
import salesforce.entities.Context;
import salesforce.entities.Contract;
import salesforce.entities.Opportunity;
import salesforce.ui.components.span.ToastUpdateObjectMessage;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.genericTabs.AbstractTabObjectsPage;
import salesforce.ui.pages.newcontract.AbstractNewContractPage;
import salesforce.ui.pages.newopportunity.AbstractNewOpportunityPage;
import salesforce.ui.pages.oportunitieslist.AbstractOpportunityListPage;
import salesforce.ui.pages.opportunity.AbstractOpportunityPage;

import java.util.HashMap;
import java.util.Map;

public class ContractSteps {
    private Context context;
    private AbstractTabObjectsPage abstractTabObjectsPage;
    private AbstractNewContractPage abstractNewContractPage;
    private Contract contract;
    private ToastUpdateObjectMessage toastUpdateObjectMessage;
    private Opportunity opportunity;
    private AbstractNewOpportunityPage abstractNewOpportunityPage;
    private AbstractOpportunityPage abstractOpportunityPage;
    private AbstractOpportunityListPage abstractOpportunityListPage;

    private static final int ARRAY_POSITION_FIRST = 0;

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
        contract.setAccountName(context.getAccounts().get(ARRAY_POSITION_FIRST).getName());
        abstractNewContractPage.setNewContract(contract, mapNewContract.keySet());
        abstractNewContractPage.clickSaveContract();
        toastUpdateObjectMessage = new ToastUpdateObjectMessage();
        String contractNumber = toastUpdateObjectMessage.getMessage().replaceAll("\\D+","");
        contract.setContractNumber(contractNumber);
    }

    @And("I create New Opportunity with")
    public void iCreateNewOpportunityWith(final Map<String, String> mapNewOpportunity) {
        HashMap<String, String> mapOpportunity = new HashMap<>(mapNewOpportunity);
        abstractTabObjectsPage.clickOnNewButton();
        abstractNewOpportunityPage = AppPageFactory.getNewOpportunityPage();
        opportunity = context.getOpportunity();
        opportunity.setOpportunityInformation(mapOpportunity);
        abstractNewOpportunityPage.setNewOpportunity(opportunity, mapNewOpportunity.keySet());
        abstractOpportunityPage = abstractNewOpportunityPage.clickSaveOpportunityButton();
    }
    @When("I select stage as {string}")
    public void iSelectStageAs(String stage) {
        abstractOpportunityPage.clickOnAStage(stage);
    }

    @When("I close the opportunity as {string}")
    public void iCloseTheOpportunityAs(String closeAs) {
        opportunity.setStageName(closeAs);
        abstractOpportunityPage.clickOnSelectCloseStage(closeAs);
    }

    @Then("the application should display a message {string}")
    public void theApplicationShouldDisplayAMessage(String message) {
        toastUpdateObjectMessage = new ToastUpdateObjectMessage();
        String messageClosed = toastUpdateObjectMessage.getMessage();
        Assert.assertEquals(message,messageClosed);

    }

    @And("On opportunities object should be display the current stage")
    public void onOpportunitiesObjectShouldBeDisplayCurrentStage() {
        abstractOpportunityListPage = AppPageFactory.getOpportunityList();
        String actual = abstractOpportunityListPage.getStageName(context.getOpportunity().getName());
        String expected = opportunity.getStageName();
        Assert.assertEquals(expected, actual);
    }

}
