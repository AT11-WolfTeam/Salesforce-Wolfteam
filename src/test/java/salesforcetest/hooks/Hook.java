/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforcetest.hooks;

import core.selenium.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import salesforce.api.requestapi.AccountHelper;
import salesforce.api.requestapi.ContactApiHelper;
import salesforce.api.requestapi.OpportunityApiHelper;
import salesforce.entities.Account;
import salesforce.entities.Contact;
import salesforce.entities.Context;
import salesforce.entities.Opportunity;
import salesforce.ui.helpers.LeadHelper;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.PageTransporter;
import salesforce.ui.pages.campaign.AbstractCampaignPage;
import salesforce.ui.pages.campaignlist.AbstractCampaignListPage;
import salesforce.ui.pages.genericTabs.AbstractTabObjectsPage;
import salesforce.ui.pages.oportunitieslist.AbstractOpportunityListPage;
import salesforce.ui.pages.pricebook.pricebooklist.AbstractPriceBookListPage;
import salesforce.ui.pages.product.productlist.AbstractProductListPage;

/**
 * Manages Hook instance.
 *
 * @author Alan Escalera.
 * @version 1.0 17 March 2020.
 */
public class Hook {
    private Context context;
    private WebDriver webDriver;
    private AbstractCampaignListPage abstractCampaignListPage;
    private PageTransporter pageTransporter;
    private AbstractCampaignPage abstractCampaignPage;
    private OpportunityApiHelper opportunityApiHelper;
    private LeadHelper leadHelper;
    private ContactApiHelper contactApiHelper;
    private AbstractTabObjectsPage abstractTabObjectsPage;
    private AbstractOpportunityListPage abstractOpportunityListPage;
    private AbstractProductListPage abstractProductListPage;
    private AbstractPriceBookListPage abstractPriceBookListPage;
    private static final String CAMPAIGNS_PAGE = "Campaigns Page";
    private static final String CONTRACTS_PAGE = "Contracts Page";
    private static final String OPPORTUNITIES_PAGE = "Opportunities Page";
    private static final String PRODUCTS_PAGE = "Products Page";
    private static final String PRICE_BOOKS_PAGE = "PriceBooks Page";
    private AccountHelper accountHelper;

    /**
     * Constructor Hook.
     *
     * @param context dependency injection.
     */
    public Hook(final Context context) {
        this.context = context;
        this.webDriver = WebDriverManager.getInstance().getWebDriver();
        pageTransporter = new PageTransporter();
        opportunityApiHelper = new OpportunityApiHelper();
        leadHelper = new LeadHelper();
        contactApiHelper = new ContactApiHelper();
        accountHelper = new AccountHelper();
    }

    /**
     * Deletes campaign.
     */
    @After("@DeleteCampaign")
    public void deletesCampaign() {
        pageTransporter.navigateToPage(CAMPAIGNS_PAGE);
        abstractCampaignListPage = AppPageFactory.getCampaignsPage();
        abstractCampaignPage = abstractCampaignListPage.selectCampaignName(context.getNewCampaign().getCampaignName());
        abstractCampaignListPage = abstractCampaignPage.deleteCampaign();
    }

    /**
     * Deletes opportunity.
     */
    @After("@DeleteOpportunity")
    public void deletesOpportunity() {
        opportunityApiHelper.deleteOpportunities(context.getOpportunities());
        final String expected = "204";
        for (Opportunity opportunity : context.getOpportunities()) {
            Assert.assertEquals(opportunity.getStatusCode(), expected);
        }
    }

     /**
     * Deletes leads.
     */
    @After("@DeleteLeads")
    public void deletesLeads() {
        leadHelper.deleteLeads(context.getLeads());
    }

    /**
     * Deletes contacts.
     */
    @After("@DeleteContacts")
    public void deleteContacts() {
        contactApiHelper.deleteContacts(context.getContacts());
        final String expected = "204";
        for (Contact contact : context.getContacts()) {
            Assert.assertEquals(contact.getStatusCode(), expected);
        }
    }

    /**
     * Deletes Contract.
     */
    @After("@DeleteContract")
    public void deleteContract() {
        pageTransporter.navigateToPage(CONTRACTS_PAGE);
        abstractTabObjectsPage = AppPageFactory.getTabObjectsPage();
        abstractTabObjectsPage.clickOnDeleteButton(context.getContract().getContractNumber());
    }

    /**
     * Deletes an Opportunity by UI.
     */
    @After("@DeleteAnOpportunity")
    public void deleteAnOpportunity() {
        pageTransporter.navigateToPage(OPPORTUNITIES_PAGE);
        abstractOpportunityListPage = AppPageFactory.getOpportunityList();
        abstractOpportunityListPage.deleteOpportunity(context.getOpportunity().getName());
    }

    /**
     * Deletes accounts.
     */
    @After("@DeleteAccounts")
    public void deleteAccounts() {
        accountHelper.deleteAccounts(context.getAccounts());
        final String expected = "204";
        for (Account account : context.getAccounts()) {
            Assert.assertEquals(account.getStatusCode(), expected);
        }
    }

    /**
     * Deletes a product.
     */
    @After("@DeleteProduct")
    public void deleteProduct() {
        pageTransporter.navigateToPage(PRODUCTS_PAGE);
        abstractProductListPage = AppPageFactory.getProductListPage();
        abstractProductListPage.deleteAProduct(context.getProduct().getName());
    }

    /**
     * Deletes a price book.
     */
    @After("@DeletePriceBook")
    public void deletePriceBook() {
        pageTransporter.navigateToPage(PRICE_BOOKS_PAGE);
        abstractPriceBookListPage = AppPageFactory.getPriceBookListPage();
        abstractPriceBookListPage.deleteAPriceBook(context.getPriceBook().getPriceBookName());
    }

    /**
     * This method is executed after the scenarios.
     *
     * @param scenario contains a scenarios of cucumber.
     */
    @After
    public void tearDown(final Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
    }
}
