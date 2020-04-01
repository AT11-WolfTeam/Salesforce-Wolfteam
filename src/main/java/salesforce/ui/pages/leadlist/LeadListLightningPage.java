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
import java.util.NoSuchElementException;

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
    private static final String OBJECT_ROW_BASE_LOCATOR = "//tr[th[span[a[@title='%1$s']]] and td[span[span[@title="
            + "'%2$s']]] and td[span[span[text()='%3$s']]]]";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(changeStatusButton));
    }

    @Override
    public void changeLeadStatus(final List<Lead> leads) {
        for (Lead lead : leads) {
            clickOnCheckButton(lead);
        }
        clickOnChangeStatusLeadButton();
    }

    @Override
    public List<Lead> getLeadsUpdated(List<Lead> leads) {
        List<Lead> leadsUpdated = new ArrayList<>();
        for (Lead lead : leads) {
            String objectRowLocator = String.format(OBJECT_ROW_BASE_LOCATOR, lead.getLastName(), lead.getCompany(), lead.getLeadStatus());
            WebElement webElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectRowLocator)));
            Lead newLead = new Lead();
            newLead.setLastName(findInRowLastNameLead(webElement.findElement(By.xpath(objectRowLocator))));
            newLead.setCompany(findInRowCompanyLead(webElement.findElement(By.xpath(objectRowLocator))));
            newLead.setCompany(findInRowLeadStatus(webElement.findElement(By.xpath(objectRowLocator))));
            leadsUpdated.add(newLead);
        }
        return leadsUpdated;
    }

    /**
     * Gets a lastName of a lead.
     *
     * @param webElement contains a web element.
     * @return a String value.
     */
    private String findInRowLastNameLead(WebElement webElement) {
        final String cellLastNameLeadLocator = "//th[1]//a";
        return webElement.findElement(By.xpath(cellLastNameLeadLocator)).getText();
    }

    /**
     * Gets a company of a lead.
     *
     * @param webElement contains a web element.
     * @return a String value.
     */
    private String findInRowCompanyLead(WebElement webElement) {
        final String cellCompanyLeadLocator = "//td[3]//span[@class='slds-truncate uiOutputText']";
        return webElement.findElement(By.xpath(cellCompanyLeadLocator)).getText();
    }

    /**
     * Gets a Status of a lead.
     *
     * @param webElement contains a web element.
     * @return a String value.
     */
    private String findInRowLeadStatus(WebElement webElement) {
        final String cellLeadStatusLocator = "//td[6]//span[@class='slds-truncate']";
        return webElement.findElement(By.xpath(cellLeadStatusLocator)).getText();
    }

    /**
     * Click on a button.
     *
     * @param lead contains an object.
     */
    private void clickOnCheckButton(final Lead lead) {
        String checkBoxLocator = String.format(OBJECT_CHECK_BOX_BASE_LOCATOR, lead.getLastName(), lead.getCompany());
        try {
            webDriver.findElement(By.xpath(checkBoxLocator)).click();
        } catch (StaleElementReferenceException StaleElement) {
            webDriver.findElement(By.xpath(checkBoxLocator)).click();
        }
    }

    /**
     * Clicks on a button.
     */
    private void clickOnChangeStatusLeadButton() {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(changeStatusButton).click().perform();
    }
}
