package salesforce.ui.pages.leadlist;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.entities.Lead;

import java.util.List;

/**
 * Manages LeadListClassicPage.
 *
 * @author Enrique Carrizales.
 * @version 1.0 29 March 2020.
 */
public class LeadListClassicPage extends AbstractLeadListPage {

    @FindBy(css = "ul[class='piped'] input[class='btn'][value='Add to Campaign']")
    private WebElement changeStatusButton;

    private static final String OBJECT_CHECK_BOX_BASE_LOCATOR = "//tr[td[div[a[span[contains(text(),'%1$s')]]]] and "
            + "td[div[a[span[contains(text(),'%2$s')]]]]]//input";

    @Override
    public void changeLeadStatus(final List<Lead> leads) {

    }

    @Override
    public List<Lead> getLeadsUpdated(final List<Lead> leads) {
        return null;
    }

    @Override
    protected void clickOnChangeStatusLeadButton() {
        changeStatusButton.click();
    }

    @Override
    protected void clickOnCheckButton(Lead lead) {
        String checkBoxLocator = String.format(OBJECT_CHECK_BOX_BASE_LOCATOR, lead.getLastName(), lead.getCompany());
        try {
            webDriver.findElement(By.xpath(checkBoxLocator)).click();
        } catch (StaleElementReferenceException StaleElement) {
            webDriver.findElement(By.xpath(checkBoxLocator)).click();
        }
    }

    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }
}
