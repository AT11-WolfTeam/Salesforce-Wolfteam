/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages;

import core.utils.GradleReader;
import salesforce.ui.components.menu.TopClassicMenu;
import salesforce.ui.components.menu.TopLightningMenu;
import salesforce.ui.components.menu.TopMenuAbstract;
import salesforce.ui.components.span.AbstractUpdateLeadMessage;
import salesforce.ui.components.span.AddLeadClassicMessage;
import salesforce.ui.components.span.AddLeadLightningMessageSpan;
import salesforce.ui.pages.event.AbstractEventPage;
import salesforce.ui.pages.event.EventClassicPage;
import salesforce.ui.pages.event.EventLightningPage;
import salesforce.ui.pages.leadlist.AbstractChangeStatusLeads;
import salesforce.ui.pages.leadlist.AbstractLeadListPage;
import salesforce.ui.pages.leadlist.ChangeStatusLeadsClassicPage;
import salesforce.ui.pages.leadlist.ChangeStatusLeadsLightningPopup;
import salesforce.ui.pages.leadlist.LeadListClassicPage;
import salesforce.ui.pages.leadlist.LeadListLightningPage;
import salesforce.ui.pages.campaign.AbstractCampaignPage;
import salesforce.ui.pages.campaign.CampaignClassicPage;
import salesforce.ui.pages.campaign.CampaignLightningPage;
import salesforce.ui.pages.campaignLeads.AbstractCampaignLeadsPage;
import salesforce.ui.pages.campaignLeads.CampaignLeadsClassicPage;
import salesforce.ui.pages.campaignLeads.CampaignLeadsLightningPage;
import salesforce.ui.pages.campaigncontact.AbstractCampaignContactPage;
import salesforce.ui.pages.campaigncontact.CampaignContactClassicPage;
import salesforce.ui.pages.campaigncontact.CampaignContactPopupLightningPage;
import salesforce.ui.pages.campaignlist.AbstractCampaignListPage;
import salesforce.ui.pages.campaignlist.CampaignListClassicPage;
import salesforce.ui.pages.campaignlist.CampaignListLightningPage;
import salesforce.ui.pages.campaignmembers.AbstractCampaignMembersPage;
import salesforce.ui.pages.campaignmembers.CampaignMembersClassicPage;
import salesforce.ui.pages.campaignmembers.CampaignMembersLightningPage;
import salesforce.ui.pages.contract.AbstractContractPage;
import salesforce.ui.pages.contract.ContractClassicPage;
import salesforce.ui.pages.contract.ContractLightningPage;
import salesforce.ui.pages.contractlist.AbstractContractListPage;
import salesforce.ui.pages.contractlist.ContractListClassicPage;
import salesforce.ui.pages.contractlist.ContractListLightningPage;
import salesforce.ui.pages.genericTabs.AbstractTabObjectsPage;
import salesforce.ui.pages.genericTabs.TabObjectsClassicPage;
import salesforce.ui.pages.genericTabs.TabObjectsLightningPage;
import salesforce.ui.pages.newcampaign.AbstractNewCampaignPage;
import salesforce.ui.pages.newcampaign.NewCampaignClassicPage;
import salesforce.ui.pages.newcampaign.NewCampaignLightningPopUp;
import salesforce.ui.pages.newcontract.AbstractNewContractPage;
import salesforce.ui.pages.newcontract.NewContractClassicPage;
import salesforce.ui.pages.newcontract.NewContractLightningPopUp;
import salesforce.ui.pages.notesattachments.NotesAndAttachmentsClassicPage;
import salesforce.ui.pages.notesattachments.NotesAndAttachmentsLightningPage;
import salesforce.ui.pages.notesattachments.NotesAndAttachmentsPageAbstract;
import salesforce.ui.pages.oportunitieslist.AbstractOpportunityListPage;
import salesforce.ui.pages.oportunitieslist.OpportunityListClassicPage;
import salesforce.ui.pages.oportunitieslist.OpportunityListLightningPage;
import salesforce.ui.pages.opportunity.AbstractOpportunityPage;
import salesforce.ui.pages.opportunity.OpportunityClassicPage;
import salesforce.ui.pages.opportunity.OpportunityLightningPage;
import salesforce.ui.pages.opportunity.newopportunity.NewOpportunityClassicPage;
import salesforce.ui.pages.opportunity.opportunityevent.AbstractOpportunityEvent;
import salesforce.ui.pages.opportunity.opportunityevent.OpportunityEventClassicPage;
import salesforce.ui.pages.opportunity.opportunityevent.OpportunityEventLightningPage;
import salesforce.ui.pages.opportunity.opportunityproducts.AbstractOpportunityProductsPage;
import salesforce.ui.pages.opportunity.opportunityproducts.OpportunityProductsClassicPage;
import salesforce.ui.pages.opportunity.opportunityproducts.OpportunityProductsLightningPage;
import salesforce.ui.pages.opportunity.taskopportunity.AbstractTaskOpportunity;
import salesforce.ui.pages.opportunity.taskopportunity.TaskOpportunityClassic;
import salesforce.ui.pages.opportunity.taskopportunity.TaskOpportunityLightning;
import salesforce.ui.pages.opportunity.newopportunity.AbstractNewOpportunity;
import salesforce.ui.pages.opportunity.newopportunity.NewOpportunityLightningPage;
import salesforce.ui.pages.pricebook.AbstractPriceBookPage;
import salesforce.ui.pages.pricebook.PriceBookClassicPage;
import salesforce.ui.pages.pricebook.PriceBookLightningPage;
import salesforce.ui.pages.pricebook.addproducts.AbstractAddProduct;
import salesforce.ui.pages.pricebook.addproducts.AddProductClassicPage;
import salesforce.ui.pages.pricebook.addproducts.AddProductLightningPopUp;
import salesforce.ui.pages.pricebook.editselectedpricebookentries.AbstractEditSelectedPriceBookEntriesPage;
import salesforce.ui.pages.pricebook.editselectedpricebookentries.EditSelectedPriceBookEntriesClassicPage;
import salesforce.ui.pages.pricebook.editselectedpricebookentries.EditSelectedPriceBookEntriesLightingPopUp;
import salesforce.ui.pages.pricebook.newpricebook.AbstractNewPriceBookPage;
import salesforce.ui.pages.pricebook.newpricebook.NewPriceBookClassicPage;
import salesforce.ui.pages.pricebook.newpricebook.NewPriceBookLightningPopUp;
import salesforce.ui.pages.pricebook.pricebooklist.AbstractPriceBookListPage;
import salesforce.ui.pages.pricebook.pricebooklist.PriceBookListClassicPage;
import salesforce.ui.pages.pricebook.pricebooklist.PriceBookListLightningPage;
import salesforce.ui.pages.product.AbstractProductPage;
import salesforce.ui.pages.product.ProductClassicPage;
import salesforce.ui.pages.product.ProductLightningPage;
import salesforce.ui.pages.product.newpricebookentry.AbstractNewPriceBookEntryPage;
import salesforce.ui.pages.product.newpricebookentry.NewPriceBookEntryClassicPage;
import salesforce.ui.pages.product.newpricebookentry.NewPriceBookEntryLightningPopUp;
import salesforce.ui.pages.product.newproduct.AbstractNewProductPage;
import salesforce.ui.pages.product.newproduct.NewProductClassicPage;
import salesforce.ui.pages.product.newproduct.NewProductLightningPopUp;
import salesforce.ui.pages.product.productlist.AbstractProductListPage;
import salesforce.ui.pages.product.productlist.ProductListClassicPage;
import salesforce.ui.pages.product.productlist.ProductListLightningPage;
import salesforce.ui.pages.task.AbstractTask;
import salesforce.ui.pages.task.TaskClassicPage;
import salesforce.ui.pages.task.TaskLightningPage;

/**
 * Builds a page specific.
 *
 * @author Enrique Carrizales.
 * @version 1.0 17 March 2020.
 */
public class AppPageFactory {
    private static String userExperience = GradleReader.getInstance().getUserExperience();
    private static final String CLASSIC_USER_EXPERIENCE = "Classic";

    /**
     * Returns a page from a user experience.
     *
     * @return TopMenu instance.
     */
    public static TopMenuAbstract getTopMenu() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new TopClassicMenu();
        }
        return new TopLightningMenu();
    }

    /**
     * Returns a campaigns page.
     *
     * @return CampaignsPage instance.
     */
    public static AbstractCampaignListPage getCampaignsPage() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new CampaignListClassicPage();
        }
        return new CampaignListLightningPage();
    }

    /**
     * Allows to instance Opportunities page.
     *
     * @return OpportunitiesPage instance.
     */
    public static AbstractTabObjectsPage getTabObjectsPage() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new TabObjectsClassicPage();
        }
        return new TabObjectsLightningPage();
    }

    /**
     * Returns a campaigns page.
     *
     * @return CampaignsPage instance.
     */
    public static AbstractOpportunityPage getOpportunityPage() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new OpportunityClassicPage();
        }
        return new OpportunityLightningPage();
    }

    /**
     * Returns a New campaigns page.
     *
     * @return NewCampaignsPage instance.
     */
    public static AbstractNewCampaignPage getNewCampaignPage() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new NewCampaignClassicPage();
        }
        return new NewCampaignLightningPopUp();
    }

    /**
     * Returns a OpportunityList page.
     *
     * @return OpportunityListPage instance;
     */
    public static AbstractOpportunityListPage getOpportunityList() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new OpportunityListClassicPage();
        }
        return new OpportunityListLightningPage();
    }

    /**
     * Returns a campaigns page.
     *
     * @return CampaignsPage instance.
     */
    public static AbstractCampaignPage getCampaignPage() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new CampaignClassicPage();
        }
        return new CampaignLightningPage();
    }

    /**
     * Returns a task page.
     *
     * @return task instance.
     */
    public static AbstractTask getTaskPage() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new TaskClassicPage();
        }
        return new TaskLightningPage();
    }

    /**
     * Returns a task page.
     *
     * @return task instance.
     */
    public static AbstractContractPage getContractPage() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new ContractClassicPage();
        }
        return new ContractLightningPage();
    }

    /**
     * Allows to identify notes and attachment user experience page.
     *
     * @return NotesAndAttachmentsPage instance.
     */
    public static NotesAndAttachmentsPageAbstract getNotesAndAttachments() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new NotesAndAttachmentsClassicPage();
        }
        return new NotesAndAttachmentsLightningPage();
    }

    /**
     * Allows to identify campaign members user experience page.
     *
     * @return campaign members instance.
     */
    public static AbstractCampaignMembersPage getCampaignMembers() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new CampaignMembersClassicPage();
        }
        return new CampaignMembersLightningPage();
    }

    /**
     * Returns TaskOpportunity.
     *
     * @return task Opportunity instance.
     */
    public static AbstractTaskOpportunity getTaskOpportunity() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new TaskOpportunityClassic();
        }
        return new TaskOpportunityLightning();
    }

    /**
     * Allows to identify campaign members user experience page.
     *
     * @return campaign members instance.
     */
    public static AbstractCampaignContactPage getCampaignContacts() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new CampaignContactClassicPage();
        }
        return new CampaignContactPopupLightningPage();
    }

    /**
     * Allows to get a web component message.
     *
     * @return a AddLeadLightningMessageSpan.
     */
    public static AbstractUpdateLeadMessage getAddLeadMessage() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new AddLeadClassicMessage();
        }
        return new AddLeadLightningMessageSpan();
    }

    /**
     * Allows to get leads details.
     *
     * @return a AbstractUpdateLeadMessage.
     */
    public static AbstractCampaignLeadsPage getCampaignLeadsPage() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new CampaignLeadsClassicPage();
        }
        return new CampaignLeadsLightningPage();
    }

    /**
     * Returns New Contract Page.
     *
     * @return new contract instance.
     */
    public static AbstractNewContractPage getNewContractPage() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new NewContractClassicPage();
        }
        return new NewContractLightningPopUp();
    }

    /**
     * Returns NewOpportunityPage.
     *
     * Allows to get lead list page.
     *
     * @return a AbstractLeadListPage.
     */
    public static AbstractLeadListPage getLeadListPage() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new LeadListClassicPage();
        }
        return new LeadListLightningPage();
    }

    /**
     * Allows to get change status lead.
     *
     * @return a AbstractChangeStatusLeads.
     */
    public static AbstractChangeStatusLeads getChangeStatusLeads() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new ChangeStatusLeadsClassicPage();
        }
        return new ChangeStatusLeadsLightningPopup();
    }

    /**
     * Allows to get new opportunities.
     *
     * @return NewOpportunityPage instance.
     */
    public static AbstractNewOpportunity getNewOpportunityPage() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new NewOpportunityClassicPage();
        }
        return new NewOpportunityLightningPage();
    }

    /**
     * Returns ContractListPage.
     *
     * @return ContractListPage instance.
     */
    public static AbstractContractListPage getContractListPage() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new ContractListClassicPage();
        }
        return new ContractListLightningPage();
    }

    /**
     * Gets a OpportunityEventPage.
     *
     * @return page instance.
     */
    public static AbstractOpportunityEvent getOpportunityEvent() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new OpportunityEventClassicPage();
        }
        return new OpportunityEventLightningPage();
    }

    /**
     * Gets a AbstractEventPage.
     *
     * @return page instance.
     */
    public static AbstractEventPage getEventPage() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new EventClassicPage();
        }
        return new EventLightningPage();
    }

    /**
     * Returns NewPriceBookEntryPage.
     *
     * @return NewPriceBookEntry instance.
     */
    public static AbstractNewPriceBookEntryPage getNewPriceBookEntry() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new NewPriceBookEntryClassicPage();
        }
        return new NewPriceBookEntryLightningPopUp();
    }

    /**
     * Returns PriceBookPage.
     *
     * @return PriceBook instance.
     */
    public static AbstractPriceBookPage getPriceBookPage() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new PriceBookClassicPage();
        }
        return new PriceBookLightningPage();
    }

    /**
     * Returns ProductPage.
     *
     * @return Product instance.
     */
    public static AbstractProductPage getProductPage() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new ProductClassicPage();
        }
        return new ProductLightningPage();
    }

    /**
     * Returns AddProductPage instance.
     *
     * @return AddProduct instance.
     */
    public static AbstractAddProduct getAddProductPage() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new AddProductClassicPage();
        }
        return new AddProductLightningPopUp();
    }

    /**
     * Returns EditSelectedPriceBookEntriesPage.
     *
     * @return EditSelectedPriceBookEntries instance.
     */
    public static AbstractEditSelectedPriceBookEntriesPage getEditSelectedPriceBookEntriesPage() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new EditSelectedPriceBookEntriesClassicPage();
        }
        return new EditSelectedPriceBookEntriesLightingPopUp();
    }

    /**
     * Returns NewPriceBookPage.
     *
     * @return NewPriceBook instance.
     */
    public static AbstractNewPriceBookPage getNewPriceBookPage() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new NewPriceBookClassicPage();
        }
        return new NewPriceBookLightningPopUp();
    }

    /**
     * Gets new product instance.
     *
     * @return new product instance.
     */
    public static AbstractNewProductPage getNewProductPage() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new NewProductClassicPage();
        }
        return new NewProductLightningPopUp();
    }

    /**
     * Gets new Price Book list instance.
     *
     * @return PriceBookListPage instance.
     */
    public static AbstractPriceBookListPage getPriceBookListPage() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new PriceBookListClassicPage();
        }
        return new PriceBookListLightningPage();
    }

    /**
     * Gets new product list instance.
     *
     * @return ProductListPage instance.
     */
    public static AbstractProductListPage getProductListPage() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new ProductListClassicPage();
        }
        return new ProductListLightningPage();
    }

    /**
     * Gets opportunity products instance.
     *
     * @return opportunity products instance.
     */
    public static AbstractOpportunityProductsPage getOpportunityProductsPage() {
        if (userExperience.equals(CLASSIC_USER_EXPERIENCE)) {
            return new OpportunityProductsClassicPage();
        }
        return new OpportunityProductsLightningPage();
    }
}
