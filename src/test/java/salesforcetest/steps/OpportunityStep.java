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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import salesforce.api.requestapi.OpportunityApiHelper;
import salesforce.entities.Context;
import salesforce.entities.NewCampaign;
import salesforce.entities.Opportunity;
import salesforce.entities.OpportunityUi;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.PageTransporter;
import salesforce.ui.pages.campaignlist.CampaignListPageAbstract;
import salesforce.ui.pages.newcampaign.NewCampaignPageAbstract;
import salesforce.ui.pages.opportunities.OpportunitiesPageAbstract;
import salesforce.ui.pages.opportunity.OpportunityPageAbstract;
import salesforce.utils.SheetManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Manages a Opportunity steps definition.
 *
 * @author Enrique Carrizales.
 * @version 1.0 16 March 2020.
 */
public class OpportunityStep {
    private static final String OPPORTUNITY_PAGE = "Opportunities Page";
    private Context context;
    private OpportunityApiHelper opportunityApiHelper;
    private ArrayList<HashMap<String, String>> opportunityMapList;
    private PageTransporter pageTransporter;
    private CampaignListPageAbstract campaignsPage;
    private NewCampaignPageAbstract newCampaignPage;
    private NewCampaign newCampaign;
    private OpportunitiesPageAbstract opportunitiesPage;
    private OpportunityPageAbstract opportunityPage;
    private OpportunityUi opportunityUi;

    /**
     * OpportunityStep constructor.
     *
     * @param context value.
     */
    public OpportunityStep(final Context context) {
        this.context = context;
        opportunityApiHelper = new OpportunityApiHelper();
        pageTransporter = new PageTransporter();
    }

    /**
     * Creates Opportunity.
     *
     * @param opportunityQuantity contains opportunity quantity.
     * @param opportunity         contains opportunity type.
     */
    @Given("I create {int} opportunity as {string}")
    public void createsOpportunity(final int opportunityQuantity, final String opportunity) {
        String sheetName = "Accounts";
        opportunityMapList = SheetManager.manageSheet(sheetName, opportunityQuantity, opportunity);
        ArrayList<Opportunity> opportunities = opportunityApiHelper.setOpportunities(opportunityMapList);
        context.setOpportunities(opportunities);
        opportunityApiHelper.postOpportunities(context.getOpportunities());
    }

    /**
     * Changes an opportunity's Owner.
     *
     * @param ownerType contains name Owner object.
     */
    @When("^I change an opportunity's owner with \"([^\"]*)\"$")
    public void changesAnOpportunitySOwnerWith(final String ownerType) {
        AppPageFactory.getOpportunityPage().changeOwner(ownerType);

    }

    /**
     * Validates a message.
     *
     * @param message contains a String message.
     */
    @Then("^the application should display an information message in Opportunity page with the format \"([^\"]*)\"$")
    public void displaysAnInformationMessageInOpportunityPageWithTheFormat(final String message) {
        System.out.println("com.steps.Opportunity: Then");
    }

    /**
     * Allows to create many opportunities.
     *
     * @param quantity        number of opportunities.
     * @param opportunityType value.
     */
    @Given("I create {int} {string} opportunities")
    public void createsOpportunities(final int quantity, final String opportunityType) {
        String sheetName = "Opportunities";
        opportunityMapList = SheetManager.manageSheet(sheetName, quantity, opportunityType);
        ArrayList<Opportunity> opportunities = opportunityApiHelper.setOpportunities(opportunityMapList);
        context.setOpportunities(opportunities);
        opportunityApiHelper.postOpportunities(context.getOpportunities());
    }

    /**
     * Deletes created opportunities.
     */
    @When("I delete created opportunities")
    public void deleteOpportunities() {
        opportunityApiHelper.deleteOpportunities(context.getOpportunities());
        final String expected = "204";
        for (Opportunity opportunity : context.getOpportunities()) {
            Assert.assertEquals(opportunity.getStatusCode(), expected);
        }
    }

    /**
     * Navigates to an opportunity.
     */
    @And("I navigate to Opportunities Page")
    public void navigatesToOpportunitiesPage() {
        pageTransporter.navigateToPage(OPPORTUNITY_PAGE);
    }

    /**
     * Search an opportunity.
     *
     * @param listName        contains a String value.

     */
    @And("I search the opportunity in list {string}")
    public void searchOpportunity(final String listName) {
        String opportunityName = context.getOpportunities().get(0).getName();
        AppPageFactory.getOpportunitiesPage().displayOpportunityList(listName);
        AppPageFactory.getOpportunityList().clickOnOpportunity(opportunityName);
    }

    /**
     * Navigates to a page.
     *
     * @param page string value.
     */
    @When("I go to {string}")
    public void iGoTo(final String page) {
        pageTransporter.navigateToPage(page);
    }

    /**
     * Creates a new campaign.
     *
     * @param mapNewCampaign map values.
     */
    @And("I create a new Campaign with")
    public void iCreateANewCampaignWith(final Map<String, String> mapNewCampaign) {
        campaignsPage = AppPageFactory.getCampaignsPage();
        newCampaignPage = campaignsPage.clickOnNewButton();
        newCampaign = context.getNewCampaign();
        newCampaign.processInformation(mapNewCampaign);
        newCampaignPage.setNewCampaign(newCampaign, mapNewCampaign.keySet());
        newCampaignPage.clickSaveButton();

    }

    /**
     * Assigns campaign to an opportunity already created.
     *
     * @param mapOpportunityEdit map values.
     */
    @When("I assign the Campaign to the opportunity")
    public void iAssignTheCampaignToTheOpportunity(final Map<String, String> mapOpportunityEdit) {
        opportunitiesPage = AppPageFactory.getOpportunitiesPage();
        opportunityPage = opportunitiesPage.selectOpportunityName(context.getOpportunities().get(0).getName());
        opportunityUi = context.getOpportunityUi();
        opportunityUi.processInformation(mapOpportunityEdit);
        opportunityPage.editOpportunity(opportunityUi, mapOpportunityEdit.keySet());
        opportunityPage.clickSaveButton();
    }

    /**
     * Validates the assignment of the campaign.
     */
    @Then("On the details section should display the Campaign name")
    public void onTheDetailsSectionShouldDisplayTheCampaignName() {
        HashMap<String, String> mapOpportunityValidate = opportunityPage.getOpportunityDetails();
        Assert.assertEquals(mapOpportunityValidate, context.getOpportunityUi().getOpportunityEdit());
    }
}
