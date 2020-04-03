/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.leadlist;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.entities.Lead;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages LeadListClassicPage.
 *
 * @author Enrique Carrizales.
 * @version 1.0 29 March 2020.
 */
public class LeadListClassicPage extends AbstractLeadListPage {
    @FindBy(css = "ul[class='piped'] input[class='btn'][value='Change Status']")
    private WebElement changeStatusButton;

    private static final String TABLE_ROWS = "div[class='x-grid3-body']";
    private static final String OBJECT_CHECK_BOX_BASE_LOCATOR = "//tr[td[div[a[span[contains(text(),'%1$s')]]]] and "
            + "td[div[a[span[contains(text(),'%2$s')]]]]]//input";
    private static final String OBJECT_ROW_BASE_LOCATOR = "//tr[td[div[a[span[contains(text(),'%1$s')]]]] and "
            + "td[div[a[span[contains(text(),'%2$s')]]]] and td[div[contains(text(),'%3$s')]]]";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(TABLE_ROWS)));
    }

    @Override
    public List<Lead> getLeadsUpdated(final List<Lead> leads) {
        List<Lead> leadsUpdated = new ArrayList<>();
        for (Lead lead : leads) {
            String objectRowLocator = String.format(OBJECT_ROW_BASE_LOCATOR, lead.getLastName(), lead.getCompany(),
                    lead.getLeadStatus());
            String objectRowLocatorLastName = objectRowLocator + "//td[4]//a//span";
            String objectRowLocatorCompany = objectRowLocator + "//td[5]//a//span";
            String objectRowLocatorLeadStatus = objectRowLocator + "//td[8]//div";
            Lead newLead = new Lead();
            newLead.setLastName(webDriver.findElement(By.xpath(objectRowLocatorLastName)).getText());
            newLead.setCompany(webDriver.findElement(By.xpath(objectRowLocatorCompany)).getText());
            newLead.setLeadStatus(webDriver.findElement(By.xpath(objectRowLocatorLeadStatus)).getText());
            leadsUpdated.add(newLead);
        }
        return leadsUpdated;
    }

    @Override
    protected void clickOnChangeStatusLeadButton() {
        changeStatusButton.click();
    }

    @Override
    protected void clickOnCheckButton(final Lead lead) {
        String checkBoxLocator = String.format(OBJECT_CHECK_BOX_BASE_LOCATOR, lead.getLastName(), lead.getCompany());
        try {
            webDriver.findElement(By.xpath(checkBoxLocator)).click();
        } catch (StaleElementReferenceException StaleElement) {
            webDriver.findElement(By.xpath(checkBoxLocator)).click();
        }
    }
}
