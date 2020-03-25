/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforcetest.steps;

import core.utils.GradleReader;
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
import salesforce.ui.components.span.ToastMessageSpan;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.PageTransporter;
import salesforce.ui.pages.campaignlist.AbstractCampaignListPage;
import salesforce.ui.pages.newcampaign.AbstractNewCampaignPage;
import salesforce.ui.pages.opportunities.AbstractOpportunitiesPage;
import salesforce.ui.pages.opportunity.AbstractOpportunityPage;
import salesforce.utils.JsonFileReader;
import salesforce.utils.ReplacerMessages;
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
    private Context context;
    private OpportunityApiHelper opportunityApiHelper;
    private ArrayList<HashMap<String, String>> opportunityMapList;
    private PageTransporter pageTransporter;
    private AbstractCampaignListPage campaignsPage;
    private AbstractNewCampaignPage newCampaignPage;
    private NewCampaign newCampaign;
    private AbstractOpportunitiesPage opportunitiesPage;
    private AbstractOpportunityPage opportunityPage;
    private OpportunityUi opportunityUi;
    private static String userExperience = GradleReader.getInstance().getUserExperience();
    private static final int FIRST_OPPORTUNITY = 0;
    private static final String JSON_CONFIG_FILE = "config.json";
    private static final String USER_EXPERIENCE_LIGHTNING = "Lightning";
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
    @Then("the application should display an information message in Opportunity Lightning page with format {string}")
    public void displaysAnInformationMessageInOpportunityPageWithTheFormat(final String message) {
        if (userExperience.equals(USER_EXPERIENCE_LIGHTNING)) {
            ToastMessageSpan toastMessageSpan = new ToastMessageSpan();
            String actualResult = toastMessageSpan.getToastMessage();
            String expectedResult = ReplacerMessages.replaceChangeOwnerMessage(message, context.getOpportunities()
                    .get(FIRST_OPPORTUNITY).getName());
            Assert.assertEquals(actualResult, expectedResult);
        }
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
     * Deletes opportunities created.
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
     * Search an opportunity.
     *
     * @param listName contains a String value.
     */
    @And("I search the opportunity in list {string}")
    public void searchOpportunity(final String listName) {
        String opportunityName = context.getOpportunities().get(FIRST_OPPORTUNITY).getName();
        AppPageFactory.getOpportunitiesPage().displayOpportunityList(listName);
        AppPageFactory.getOpportunityList().clickOnOpportunity(opportunityName);
    }

    /**
     * Navigates to a page.
     *
     * @param page string value.
     */
    @When("I go to {string}")
    public void goesTo(final String page) {
        pageTransporter.navigateToPage(page);
    }

    /**
     * Creates a new campaign.
     *
     * @param mapNewCampaign map values.
     */
    @And("I create a new Campaign with")
    public void cratesNewCampaignWith(final Map<String, String> mapNewCampaign) {
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
    public void assignsTheCampaignToTheOpportunity(final Map<String, String> mapOpportunityEdit) {
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

    /**
     * Validates an opportunity owner.
     * @param ownerType contains String value.
     */
    @When("the opportunity page displays the owner {string}")
    public void displaysTheOwnerOnOpportunityPage(final String ownerType) {
        String actualResult = AppPageFactory.getOpportunityPage().getOwner(ownerType);
        String expectedResult = new JsonFileReader(JSON_CONFIG_FILE).getUser(ownerType).getUsername();
        Assert.assertEquals(actualResult, expectedResult);
    }

    /**
     * Uploads a file to opportunity.
     */
    @When("I upload the file to opportunity")
    public void uploadFile() {
        String filePath = "src/test/resources/filestoupload/cucumber.png";
        AppPageFactory.getOpportunityPage().clickOnNotesAndAttachmentsButton();
        AppPageFactory.getNotesAndAttachments().clickOnUploadFiles(filePath);
    }

    /**
     * Gets uploaded file name.
     */
    @Then("The file should be uploaded on opportunity")
    public void getFileName() {
        String fileName = "cucumber";
        String uploadedFileName = AppPageFactory.getNotesAndAttachments().getUploadedFileName(fileName);
        Assert.assertEquals(uploadedFileName, fileName);
    }

    /**
     * Selects opportunity.
     */
    @And("I select the created opportunity")
    public void selectOpportunity() {
        String opportunityName = context.getOpportunities().get(0).getName();
        System.out.println(opportunityName);
        // close popup
        AppPageFactory.getOpportunitiesPage().selectOpportunityName(opportunityName);
    }
}
