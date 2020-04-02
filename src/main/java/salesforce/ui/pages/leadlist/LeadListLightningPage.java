package salesforce.ui.pages.leadlist;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.entities.Lead;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages LeadListLightningPage.
 *
 * @author Enrique Carrizales.
 * @version 1.0 29 March 2020.
 */
public class LeadListLightningPage extends AbstractLeadListPage {

    @FindBy(xpath = "//a[div[@title='Change Status']]")
    private WebElement changeStatusButton;

    private static final String OBJECT_CHECK_BOX_BASE_LOCATOR = "//tr[th[span[a[@title='%1$s']]] and td[span[span"
            + "[@title='%2$s']]]]//label[@class='slds-checkbox']//span[@class='slds-checkbox--faux']";
    private static final String OBJECT_ROW_GENERIC_LOCATOR = "//tr[td[span[span[contains(text(),'-')]]]]";
    private static final String OBJECT_ROW_BASE_LOCATOR = "//tr[th[span[a[contains(text(),'%1$s')]]]  and "
            + "td[span[span[@title='%2$s']]] and td[span[span[text()='%3$s']]]]";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(changeStatusButton));
    }

    @Override
    public List<Lead> getLeadsUpdated(final List<Lead> leads) {
        List<Lead> leadsUpdated = new ArrayList<>();
        try {
            webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.
                    xpath(OBJECT_ROW_GENERIC_LOCATOR)));
        } catch (StaleElementReferenceException staleElement) {
            webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.
                    xpath(OBJECT_ROW_GENERIC_LOCATOR)));
        }
        for (Lead lead : leads) {
            String objectRowLocator = String.format(OBJECT_ROW_BASE_LOCATOR, lead.getLastName(), lead.getCompany(),
                    lead.getLeadStatus());
            String objectRowLocatorLastName = objectRowLocator + "//th[1]//a";
            String objectRowLocatorCompany = objectRowLocator + "//td[3]//span[@class='slds-truncate uiOutputText']";
            String objectRowLocatorLeadStatus = objectRowLocator + "//span[contains(text(),'-')]";
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
        Actions actions = new Actions(webDriver);
        actions.moveToElement(changeStatusButton).click().perform();
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
