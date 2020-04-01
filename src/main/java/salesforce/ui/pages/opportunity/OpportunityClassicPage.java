/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunity;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.opportunity.opportunitycontactroles.AbstractContactRolesPage;
import salesforce.ui.pages.opportunity.opportunitycontactroles.ContactRolesClassicPage;
import salesforce.ui.pages.opportunity.taskopportunity.AbstractTaskOpportunity;
import salesforce.ui.pages.owner.OwnerEditClassicPage;
import salesforce.utils.UtilSalesforce;

import java.util.HashMap;

/**
 * Defines an OpportunityClassicPage.
 *
 * @author Enrique Carrizales.
 * @version 1.0 21 March 2020.
 */
public class OpportunityClassicPage extends AbstractOpportunityPage {
    @FindBy(css = "td[id='opp17_ilecell']")
    private WebElement campaignField;

    @FindBy(xpath = "//img[@alt='Primary Campaign Source Lookup (New Window)']")
    private WebElement lookupButton;

    @FindBy(css = "input[name='inlineEditSave']")
    private WebElement saveButton;

    @FindBy(xpath = "//div[@id='opp17_ileinner']")
    private WebElement campaignSaved;

    @FindBy(css = "input[title='Edit']")
    private WebElement editButton;

    @FindBy(name = "resultsFrame")
    private WebElement resultsFrame;

    @FindBy(xpath = "//a[contains(text(),'[Change]')]")
    private WebElement changeLinkText;

    @FindBy(css = "div[id='opp1_ileinner'] a[id]")
    private WebElement ownerLabel;

    @FindBy(css = "input[value='Attach File']")
    private WebElement attachFileButton;

    @FindBy(xpath = "//span[text()='New Task']")
    private WebElement addTaskButton;

    @FindBy(xpath = "//span[@class='publisherattachtext ' and text()='File']")
    private WebElement addFile;

    @FindBy(css = "input[name='newRole']")
    private WebElement newRoleButton;

    @FindBy(xpath = "//input[@name='tsk5__09D3h0000012ZVJ']")
    private WebElement subjectField;

    private String parentHandle;
    protected static final String CAMPAIGN_NAME = "//th[@scope='row']//a[contains(text(),'%s')]";
    private static final String CONTACT_NAME = "//th//a[text()='%s']";
    private static final String CONTACT_ROLE = "//th[a[text()='%s']]/..//td[text()='%s']";
    protected static final int INTERVAL_TIME = 2000;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(campaignField));
    }

    @Override
    protected void assignCampaign(final String campaignName) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,400)");
        clickCampaignField();
        clickLookupButton();
        selectCampaign(campaignName);
        clickSaveButton();
    }

    @Override
    public void clickOnAStage(final String stageName) {
        //To Do
    }

    @Override
    public void clickOnMarkAsCurrentStageButton() {
        //To Do
    }

    @Override
    public void clickOnSelectCloseStage(final String closeAs) {
        //To do
    }

    @Override
    public void refreshPage() {
        webDriver.navigate().refresh();
    }

    @Override
    protected String getCampaignName() {
        webDriverWait.until(ExpectedConditions.visibilityOf(campaignSaved));
        webDriverWait.until(ExpectedConditions.visibilityOf(editButton));
        return campaignSaved.getText();
    }

    /**
     * Selects the campaign.
     *
     * @param campaignName value.
     */
    private void selectCampaign(final String campaignName) {
        parentHandle = webDriver.getWindowHandle();
        try {
            UtilSalesforce.switchToNewWindow(parentHandle);
            webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(resultsFrame));
            clickOnCampaignSelected(campaignName);
        } finally {
            webDriver.switchTo().window(parentHandle);
        }
    }

    /**
     * Clicks on campaign selected.
     *
     * @param campaignName string value.
     */
    private void clickOnCampaignSelected(final String campaignName) {
        String campaignNameXpath = String.format(CAMPAIGN_NAME, campaignName);
        campaignNameSelect = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(campaignNameXpath)));
        campaignNameSelect.click();
    }

    @Override
    public void clickSaveButton() {
        saveButton.click();
    }

    /**
     * Clicks on campaign field.
     */
    private void clickCampaignField() {
        campaignField.click();
        campaignField.sendKeys(Keys.ENTER);
    }

    /**
     * Clicks on lookup button.
     */
    private void clickLookupButton() {
        lookupButton.click();
    }

    @Override
    public void changeOwner(final String ownerType) {
        changeLinkText.click();
        OwnerEditClassicPage ownerEditClassicPage = new OwnerEditClassicPage();
        ownerEditClassicPage.setOwnerNameTexBox(ownerType);
        ownerEditClassicPage.clickOnSaveButton();
    }

    @Override
    public String getOwner(final String ownerType) {
        webDriverWait.until(ExpectedConditions.visibilityOf(ownerLabel));
        return ownerLabel.getText();
    }

    /**
     * Clicks on notes and attachments link.
     */
    private void clickOnAttachFileButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(attachFileButton));
        attachFileButton.click();
    }

    @Override
    public void clickOnNotesAndAttachmentsButton() {
        clickOnAttachFileButton();
    }

    /**
     * Clicks on contact role button.
     */
    private void clickOnContactRolesButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(newRoleButton));
        newRoleButton.click();
    }

    @Override
    public AbstractContactRolesPage clickOnContactRoles() {
        clickOnContactRolesButton();
        return new ContactRolesClassicPage();
    }

    @Override
    public AbstractTaskOpportunity clickAddTask() {
        UtilSalesforce.retryClick(addTaskButton, subjectField, INTERVAL_TIME);
        return AppPageFactory.getTaskOpportunity();
    }

    /**
     * Waits until the elements are found.
     */
    private void waiters() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addTaskButton));
        webDriverWait.until(ExpectedConditions.visibilityOf(addTaskButton));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(editButton));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addFile));
        webDriverWait.until(ExpectedConditions.visibilityOf(addFile));
    }

    /**
     * Gets composed web element.
     *
     * @param xpath value.
     * @return web element.
     */
    private WebElement getWebElement(final String xpath) {
        return webDriver.findElement(By.xpath(xpath));
    }

    /**
     * Gets contact name.
     *
     * @param contactName value.
     * @return contact name text.
     */
    private String getContactNameText(final String contactName) {
        webDriverWait.until(ExpectedConditions.visibilityOf(getWebElement(String.format(CONTACT_NAME, contactName))));
        return getWebElement(String.format(CONTACT_NAME, contactName)).getText();
    }

    /**
     * Gets contact name.
     *
     * @param contactName value.
     * @param rolName     value.
     * @return composed web element.
     */
    private String getRoleTextByContactName(final String contactName, final String rolName) {
        return getWebElement(String.format(CONTACT_ROLE, contactName, rolName)).getText();
    }

    /**
     * Iterates contacts.
     *
     * @param contactsList values.
     * @return contact roles text.
     */
    private HashMap<String, String> iterateContacts(final HashMap<String, String> contactsList) {
        HashMap<String, String> contactsText = new HashMap<>();
        String contactText;
        String contactRoleText;
        for (String key : contactsList.keySet()) {
            contactText = getContactNameText(key);
            contactRoleText = getRoleTextByContactName(key, contactsList.get(key));
            contactsText.put(contactText, contactRoleText);
        }
        return contactsText;
    }

    /**
     * Verifies contacts role values.
     *
     * @param contactsList values.
     * @return iterated list.
     */
    public HashMap<String, String> verifyContactRoles(final HashMap<String, String> contactsList) {
        return iterateContacts(contactsList);
    }

    /**
     * Clicks on edit button.
     */
    private void clickOnEditButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(editButton));
        editButton.click();
    }

    @Override
    public void enableToValidateOpportunity() {
        clickOnEditButton();
    }
}
