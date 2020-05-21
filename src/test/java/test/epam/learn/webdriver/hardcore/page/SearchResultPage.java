package test.epam.learn.webdriver.hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends AbstractPage {

    @FindBy(linkText = "Google Cloud Platform Pricing Calculator")
    private WebElement searchResult;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public CloudPricingCalculatorPage openGoogleCloudCalculatorLink() {
        waitForElementVisibilityOf(searchResult);
        searchResult.click();
        return new CloudPricingCalculatorPage(driver);
    }
}
