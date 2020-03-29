package salesforce.ui.pages.leadlist;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.entities.Lead;

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

    private static final String OBJECT_TAB_BASE_LOCATOR = "//tr[th[span[a[@title='%1$s']]]and td[span[span[@title="
            + "'%2$s']]]]//label[@class='slds-checkbox']//span[@class='slds-checkbox--faux']";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(changeStatusButton));
    }

    @Override
    public void changeLeadStatus(final List<Lead> leads) {
        for (Lead lead : leads) {
            clickOnCheckButton(lead);
        }
    }

    /**
     * Click on a button.
     *
     * @param lead contains an object.
     */
    private void clickOnCheckButton(final Lead lead) {
        String checkBoxLocator = String.format(OBJECT_TAB_BASE_LOCATOR, lead.getLastName(), lead.getCompany());
        try {
            webDriver.findElement(By.xpath(checkBoxLocator)).click();
            clickOnChangeStatusLeadButton();
        } catch (StaleElementReferenceException StaleElement) {
            webDriver.findElement(By.xpath(checkBoxLocator)).click();
            clickOnChangeStatusLeadButton();
        }
    }

    /**
     * Clicks on a button.
     */
    private void clickOnChangeStatusLeadButton() {
        changeStatusButton.click();
    }
}
