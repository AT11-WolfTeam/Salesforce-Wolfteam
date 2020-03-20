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
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.campaigns.CampaignsPageAbstract;
import salesforce.ui.pages.campaigns.NewCampaignPageAbstract;
import salesforce.ui.pages.opportunities.OpportunitiesPageAbstract;
import salesforce.ui.pages.opportunities.OpportunityPageAbstract;
import salesforce.utils.SheetManager;
import salesforce.ui.pages.PageTransporter;
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
    private CampaignsPageAbstract campaignsPage;
    private NewCampaignPageAbstract newCampaignPage;
    private NewCampaign newCampaign;
    private OpportunitiesPageAbstract opportunitiesPage;
    private OpportunityPageAbstract opportunityPage;

    /**
     * OpportunityStep constructor.
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
     * @param opportunity contains name Opportunity object.
     */
    @Given("^I create opportunity as (.*)")
    public void createsOpportunity(final String opportunity) {
        System.out.println(opportunity);
    }

    /**
     * Changes an opportunity's Owner.
     *
     * @param owner contains name Owner object.
     */
    @When("^I change an opportunity's owner with \"([^\"]*)\"$")
    public void changesAnOpportunitySOwnerWith(final String owner) {
        System.out.println(owner);
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
     * @param quantity number of opportunities.
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
        PageTransporter pageTransporter = new PageTransporter();
        pageTransporter.navigateToPage(OPPORTUNITY_PAGE);
    }

    /**
     * Search an opportunity.
     *
     * @param arg0 contains opportunity name.
     */
    @And("I search an opportunity {string}")
    public void searchsOportunity(final String arg0) {
    }

    @Given("I go to {string}")
    public void iGoTo(String page) {
        pageTransporter.navigateToPage(page);
    }

    @And("I create a new Campaign with")
    public void iCreateANewCampaignWith(final Map<String, String> mapNewCampaign) {
        campaignsPage = AppPageFactory.getCampaignsPage();
        newCampaignPage = campaignsPage.clickOnNewButton();
        newCampaign = context.getNewCampaign();
        newCampaign.processInformation(mapNewCampaign);
        newCampaignPage.setNewCampaign(newCampaign, mapNewCampaign.keySet());
        newCampaignPage.clickSaveButton();

    }

    @When("I assign the Campaign to the opportunity")
    public void iAssignTheCampaignToTheOpportunity(final Map<String, String> mapNewCampaign) {
        opportunitiesPage = AppPageFactory.getOpportunitiesPage();
        opportunityPage = opportunitiesPage.selectOpportunityName("Test Opportunity");
        opportunityPage.editOpportunity(newCampaign,mapNewCampaign.keySet());
    }
}
