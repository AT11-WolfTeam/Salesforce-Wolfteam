package salesforce.ui.pages.aplications;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.BasePage;

public class AllTabsClassicPage extends BasePage {

    @FindBy(css = "td[class='dataCol opportunityBlock col02']")
    private WebElement opportunityButton;

    @FindBy(css = "input[class='btnImportant']")
    private WebElement customTabsButton;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(customTabsButton));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(customTabsButton));
    }
}
