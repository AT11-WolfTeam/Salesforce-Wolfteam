/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.newopportunity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.opportunity.AbstractOpportunityPage;

/**
 * Defines NewOpportunityLightningPopUp.
 *
 * @author Alan Escalera.
 * @version 1.0 29 March 2020.
 */
public class NewOpportunityLightningPopUp extends AbstractNewOpportunityPage {
    private static final String MODAL_CONTAINER = "//div[@class='modal-container slds-modal__container']";

    @FindBy(xpath = MODAL_CONTAINER + "//span[text()='Opportunity Name']/../.."
            + "//input")
    private WebElement opportunityNameField;

    @FindBy(xpath = MODAL_CONTAINER + "//span[text()='Close Date']/../..//input")
    private WebElement closeDateField;

    @FindBy(xpath = MODAL_CONTAINER + "//span[text()='Stage']/../..//a[@class='select']")
    private WebElement stageComboBox;

    @FindBy(xpath = "//div[@class='windowViewMode-normal oneRecordActionWrapper isModal active lafPageHost']"
            + "//button[@title='Save']")

    private WebElement saveOpportunityButton;
    private WebElement stageSelected;
    private static final String STAGE_TO_SELECT = "//div[@class='select-options']//a[@title='%s']";
    private Actions actions = new Actions(webDriver);

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(opportunityNameField));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(opportunityNameField));
    }


    @Override
    protected void setOpportunityName(final String opportunityName) {
        opportunityNameField.sendKeys(opportunityName);
    }

    @Override
    protected void setCloseDate(final String closeDate) {
        closeDateField.sendKeys(closeDate);
    }

    @Override
    protected void setStage(final String stage) {
        clickOnStageComboBox();
        selectStage(stage);
    }

    /**
     * Selects stage.
     *
     * @param stage value.
     */

    private void selectStage(final String stage) {
        stageSelected = webDriver.findElement(By.xpath(String.format(STAGE_TO_SELECT, stage)));
        actions.click(stageSelected).build().perform();
    }

    /**
     * clicks on Stage combobox.
     */
    private void clickOnStageComboBox() {
        stageComboBox.click();
    }

    @Override
    public AbstractOpportunityPage clickSaveOpportunityButton() {
        saveOpportunityButton.click();
        return AppPageFactory.getOpportunityPage();
    }
}
