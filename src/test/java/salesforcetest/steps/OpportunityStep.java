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
import groovy.util.AbstractFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import salesforce.api.requestapi.OpportunityApiHelper;
import salesforce.entities.Contact;
import salesforce.entities.Context;
import salesforce.entities.NewCampaign;
import salesforce.entities.Opportunity;
import salesforce.entities.TaskOpportunity;
import salesforce.entities.constants.OpportunityConstant;
import salesforce.ui.components.span.ToastUpdateObjectMessage;
import salesforce.entities.constants.TaskConstant;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.PageTransporter;
import salesforce.ui.pages.campaignlist.AbstractCampaignListPage;
import salesforce.ui.pages.newcampaign.AbstractNewCampaignPage;
import salesforce.ui.pages.genericTabs.AbstractTabObjectsPage;
import salesforce.ui.pages.opportunity.AbstractOpportunityPage;
import salesforce.ui.pages.opportunity.OpportunityClassicPage;
import salesforce.ui.pages.opportunity.contactrolespopup.AbstractContactRolesPopup;
import salesforce.ui.pages.opportunity.newopportunity.AbstractNewOpportunity;
import salesforce.ui.pages.opportunity.opportunitycontactroles.AbstractContactRolesPage;
import salesforce.ui.pages.opportunity.taskopportunity.AbstractTaskOpportunity;
import salesforce.ui.pages.task.AbstractTask;
import salesforce.utils.JsonFileReader;
import salesforce.utils.ReplacerMessages;
import salesforce.utils.SheetManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    private AbstractTabObjectsPage opportunitiesPage;
    private AbstractOpportunityPage opportunityPage;
    private Opportunity opportunity;
    private AbstractTaskOpportunity abstractTaskOpportunity;
    private AbstractTask abstractTask;
    private TaskOpportunity taskOpportunity;
    private AbstractContactRolesPage contactRolesPage;
    private AbstractContactRolesPopup contactRolesPopup;
    private AbstractNewOpportunity newOpportunity;

    private static String userExperience = GradleReader.getInstance().getUserExperience();
    private static final int ARRAY_POSITION_FIRST = 0;
    private static final String JSON_CONFIG_FILE = "config.json";
    private static final String USER_EXPERIENCE_LIGHTNING = "Lightning";
    private static final String USER_EXPERIENCE_CLASSIC = "Classic";
    private static final String WHITE_SPACE = " ";

    private HashMap<String, String> contactsList = new HashMap<>();
    private ArrayList<String> roles = new ArrayList<>();
    private HashMap<String, String> actual;
    private HashMap<String, String> mapNewTask;
    private HashMap<String, String> actualOpportunityValues;

    /**
     * OpportunityStep constructor.
     *
     * @param context value.
     */
    public OpportunityStep(final Context context) {
        this.context = context;
        opportunity = context.getOpportunity();
        opportunityApiHelper = new OpportunityApiHelper();
        pageTransporter = new PageTransporter();
    }

    /**
     * Changes an opportunity's Owner.
     *
     * @param ownerType contains name Owner object.
     */
    @When("^I change the opportunity's owner with \"([^\"]*)\"$")
    public void changesAnOpportunitySOwnerWith(final String ownerType) {
        AppPageFactory.getOpportunityPage().changeOwner(ownerType);
    }

    /**
     * Validates a message only for Lightning User Experience.
     *
     * @param message contains a String message.
     */
    @Then("the application should display this message in Opportunity Page only for Lightning Experience")
    public void displaysAnInformationMessageInOpportunityPageWithTheFormat(final List<String> message) {
        if (userExperience.equals(USER_EXPERIENCE_LIGHTNING)) {
            ToastUpdateObjectMessage toastUpdateObjectMessageSpan = new ToastUpdateObjectMessage();
            String actualResult = toastUpdateObjectMessageSpan.getMessage();
            String expectedResult = ReplacerMessages.replaceTransactionMessage(message.get(ARRAY_POSITION_FIRST),
                    context.getOpportunities().get(ARRAY_POSITION_FIRST).getName());
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
    @When("I search for the opportunity in list {string}")
    public void searchOpportunity(final String listName) {
        String opportunityName = context.getOpportunities().get(ARRAY_POSITION_FIRST).getName();
        AppPageFactory.getTabObjectsPage().displayList(listName);
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

        HashMap<String, String> mapOpportunity = new HashMap<>();
        mapOpportunity.putAll(mapOpportunityEdit);
        opportunitiesPage = AppPageFactory.getTabObjectsPage();
        opportunityPage = opportunitiesPage.selectObjectByName(context.getOpportunities().get(ARRAY_POSITION_FIRST)
                .getName());
        opportunity = context.getOpportunity();
        opportunity.setOpportunityInformation(mapOpportunity);
        opportunityPage.editOpportunity(opportunity, mapOpportunityEdit.keySet());
        opportunityPage.clickSaveButton();
    }

    /**
     * Validates the assignment of the campaign.
     */
    @Then("On the details section should display the Campaign name")
    public void onTheDetailsSectionShouldDisplayTheCampaignName() {
        HashMap<String, String> mapOpportunityValidate = opportunityPage.getOpportunityDetails();
        Assert.assertEquals(mapOpportunityValidate, context.getOpportunity().getOpportunityInformation());
    }

    /**
     * Validates an opportunity owner.
     *
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
        String opportunityName = context.getOpportunities().get(ARRAY_POSITION_FIRST).getName();
        System.out.println(opportunityName);
        AppPageFactory.getTabObjectsPage().selectObjectByName(opportunityName);
    }

    /**
     * Adds new Task.
     *
     * @param mapTask map values.
     */
    @And("I add new Task with")
    public void iAddNewTaskWith(final Map<String, String> mapTask) {
        mapNewTask = new HashMap<>(mapTask);
        opportunitiesPage = AppPageFactory.getTabObjectsPage();
        opportunityPage = opportunitiesPage.selectObjectByName(context.getOpportunities().get(ARRAY_POSITION_FIRST)
                .getName());
        abstractTaskOpportunity = opportunityPage.clickAddTask();
        taskOpportunity = context.getTaskOpportunity();
        if (!context.getContacts().isEmpty()) {
            String contact = context.getContacts().get(ARRAY_POSITION_FIRST).getFirstName() + " " + context
                    .getContacts().get(ARRAY_POSITION_FIRST).getLastName();
            mapNewTask.put(TaskConstant.CONTACT, contact);
        }
        taskOpportunity.processInformation(mapNewTask);
        abstractTaskOpportunity.setNewTask(taskOpportunity, mapNewTask.keySet());
        abstractTaskOpportunity.clickSaveTask();
    }

    /**
     * Adds additional information to task already created.
     *
     * @param mapAddInformationTask map values.
     */
    @When("I add additional information to the task")
    public void iAddAdditionalInformationToTheTask(final Map<String, String> mapAddInformationTask) {
        mapNewTask = new HashMap<>(mapAddInformationTask);
        abstractTask = abstractTaskOpportunity.clickTaskToEdit(context.getTaskOpportunity().getSubject());
        abstractTask.clickEditButton();
        taskOpportunity.processInformation(mapNewTask);
        abstractTask.addInformationToTask(taskOpportunity, mapNewTask.keySet());
        abstractTask.clickOnSaveTaskButton();
    }

    /**
     * Validate the addition information inserted.
     */
    @And("the task should display the information added")
    public void theTaskShouldDisplayTheInformationAdded() {
        HashMap<String, String> mapTaskValidate = abstractTask.getTaskDetails(taskOpportunity, mapNewTask.keySet());
        Assert.assertEquals(mapTaskValidate, context.getTaskOpportunity().getTaskEdited());
    }

    /**
     * Selects the opportunity.
     */
    @And("I select the opportunity")
    public void selectTheOpportunity() {
        String opportunityName = context.getOpportunities().get(ARRAY_POSITION_FIRST).getName();
        opportunityPage = AppPageFactory.getTabObjectsPage().selectObjectByName(opportunityName);
    }

    /**
     * Adds roles to opportunity contacts.
     */
    @And("I add roles its contacts")
    public void addRolesToContacts() {
        contactRolesPage = opportunityPage.clickOnContactRoles();
        contactRolesPopup = contactRolesPage.addContactRoles();
        roles.add("Business User");
        roles.add("Economic Buyer");
        roles.add("Evaluator");
        String fullName;
        int counter = 0;
        for (Contact contact : context.getContacts()) {
            fullName = contact.getFirstName() + WHITE_SPACE + contact.getLastName();
            contactsList.put(fullName, roles.get(counter));
            counter++;
        }
        if (userExperience.equals(USER_EXPERIENCE_CLASSIC)) {
            contactRolesPage.setContacts(contactsList);
            return;
        }
        contactRolesPage = contactRolesPopup.selectContacts(contactsList);
    }

    /**
     * Verifies the added roles.
     */
    @Then("The added contacts with roles should be displayed on Contact Roles page")
    public void verifyAddedContactsWithRoles() {
        if (userExperience.equals(USER_EXPERIENCE_CLASSIC)) {
            OpportunityClassicPage opportunity = new OpportunityClassicPage();
            actual = opportunity.verifyContactRoles(contactsList);
            Assert.assertEquals(actual, contactsList, "message: ");
            return;
        }
        actual = contactRolesPage.verifyContactRoles(contactsList);
        Assert.assertEquals(actual, contactsList, "message: ");
    }

    /**
     * Validates a message only for Lightning User Experience.
     *
     * @param message list.
     */
    @Then("the application should this message only for Lightning Experience")
    public void theApplicationShouldThisMessageOnlyForLightningExperience(final List<String> message) {
        if (userExperience.equals(USER_EXPERIENCE_LIGHTNING)) {
            ToastUpdateObjectMessage toastUpdateMessageSpan = new ToastUpdateObjectMessage();
            String actualResult = toastUpdateMessageSpan.getMessage();
            String expectedResult = ReplacerMessages.replaceTaskSavedMessage(message.get(ARRAY_POSITION_FIRST),
                    context.getTaskOpportunity().getSubject());
            Assert.assertEquals(actualResult, expectedResult);
        }
        abstractTask = abstractTaskOpportunity.clickTaskToEdit(context.getTaskOpportunity().getSubject());
    }

    /**
     * Creates new opportunity with all values.
     */
    @When("I create new opportunity with the following values")
    public void createOpportunity(final Map<String, String> opportunityValues) {
        opportunity.setOpportunityInformation(opportunityValues);
        opportunitiesPage = AppPageFactory.getTabObjectsPage();
        opportunitiesPage.clickOnNewButton();
        newOpportunity = AppPageFactory.getNewOpportunityPage();
        opportunityPage = newOpportunity.addOpportunityInformation(opportunity, opportunityValues.keySet());
    }

    /**
     * Verifies if the opportunity contains values specified.
     */
    @Then("The added Information should be displayed on Opportunity Page")
    public void informationShouldBeDisplayed() {
        opportunityPage.enableToValidateOpportunity();
        actualOpportunityValues = newOpportunity.getOpportunityInformation(opportunity.getOpportunityInformation());
        opportunity.setAmount(actualOpportunityValues.get(OpportunityConstant.AMOUNT));
        opportunity.setProbability(actualOpportunityValues.get(OpportunityConstant.PROBABILITY));
        opportunity.setCloseDate(actualOpportunityValues.get(OpportunityConstant.CLOSE_DATE));
        for (String key : actualOpportunityValues.keySet()) {
            org.junit.Assert.assertEquals(key + ": ", opportunity.getOpportunityInformation().get(key),
                    actualOpportunityValues.get(key));
        }
    }
}
