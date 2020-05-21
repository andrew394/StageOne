package test.epam.learn.webdriver.hardcore.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.epam.learn.webdriver.hardcore.page.CloudHomePage;
import test.epam.learn.webdriver.hardcore.page.TenMinuteMailHomePage;
import test.epam.learn.webdriver.hardcore.page.CloudPricingCalculatorPage;

public class WebDriverCloudEmailTest {

    private static final String term = "Google Cloud Platform Pricing Calculator";
    private static final String number = "4";
    private WebDriver driver;
    private CloudPricingCalculatorPage cloudPricingCalculatorPage;
    private TenMinuteMailHomePage tenMinuteMailHomePage;

    @BeforeMethod(alwaysRun = true)
    public void browserSetUp() {
        driver = new ChromeDriver();
        cloudPricingCalculatorPage = new CloudPricingCalculatorPage(driver);
        tenMinuteMailHomePage = new TenMinuteMailHomePage(driver);
        new CloudHomePage(driver)
                .openPage()
                .newForSearchBox(term)
                .searchForTerm()
                .openGoogleCloudCalculatorLink()
                .newForFrame()
                .newForNumberOfInstances(number)
                .newForOperatingSystem()
                .newForVMClass()
                .newForInstanceType()
                .newForAddGPUs()
                .newForNumberOfGPUs()
                .newForGPUType()
                .newForLocalSSD()
                .newForDatacenterLocation()
                .newForCommitedUsage()
                .newForAddToEstimate()
                .newForEmailEstimate();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    public void testTotalEstimatedCostFromEmail() {
        tenMinuteMailHomePage
                .openTenMinuteMailHomePage();
        String email = tenMinuteMailHomePage.findEmailAddress();
        cloudPricingCalculatorPage
                .newForFindFirstPage()
                .newForFrame()
                .newForEmailPaste(email)
                .newForSendEmail()
                .newForChoicePage()
                .newForOpeningMail();
        String totalEstimatedCostFromEmail = tenMinuteMailHomePage.findTotalEstimatedCostFromMail();
        cloudPricingCalculatorPage
                .newForFindFirstPage()
                .newForFrame()
                .findTotalEstimatedCost();
        String totalEstimatedCost = cloudPricingCalculatorPage.findTotalEstimatedCost();

        Assert.assertTrue(totalEstimatedCost.contains(totalEstimatedCostFromEmail));
    }
}
