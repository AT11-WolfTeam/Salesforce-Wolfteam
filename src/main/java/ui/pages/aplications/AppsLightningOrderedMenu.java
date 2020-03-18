package salesforce.ui.pages.aplications;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.BasePage;

public class AppsLightningOrderedMenu extends BasePage {

    @FindBy(css = "a[id='07p3h0000004JoeAAE']")
    private WebElement marketingButton;

    @FindBy(css = "button[class='slds-button']")
    private WebElement linkTextViewAll;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(linkTextViewAll));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(linkTextViewAll));
    }

    public void clickOnMarketingButton(){
        marketingButton.click();
    }
}
