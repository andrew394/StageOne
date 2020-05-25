package test.epam.learn.webdriver.hardcore.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.epam.learn.webdriver.hardcore.page.CloudHomePage;
import test.epam.learn.webdriver.hardcore.page.CloudPricingCalculatorPage;
import test.epam.learn.webdriver.hardcore.page.TenMinuteMailHomePage;

import static org.testng.Assert.assertTrue;

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
                .enterTermInTneSearchBox(term)
                .searchForTerm()
                .openGoogleCloudCalculatorLink()
                .switchFrame()
                .addNumberOfInstances(number)
                .chooseOperatingSystem()
                .chooseVMClass()
                .chooseInstanceType()
                .chooseAddGPUs()
                .chooseNumberOfGPUs()
                .chooseGPUType()
                .chooseLocalSSD()
                .chooseDatacenterLocation()
                .chooseCommitedUsage()
                .clickAddToEstimate()
                .clickOnEmailEstimate();
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
        String email = tenMinuteMailHomePage.getEmailAddress();
        cloudPricingCalculatorPage
                .switchToFindFirstWindowOpened()
                .switchFrame()
                .pasteEmailFromTenMinuteMail(email)
                .clickOnSendEmail()
                .switchToNewWindowOpened()
                .clickToOpenMail();
        String totalEstimatedCostFromEmail = tenMinuteMailHomePage.getTotalEstimatedCostFromMail();
        cloudPricingCalculatorPage
                .switchToFindFirstWindowOpened()
                .switchFrame()
                .getTotalEstimatedCost();
        String totalEstimatedCost = cloudPricingCalculatorPage.getTotalEstimatedCost();

        assertTrue(totalEstimatedCost.contains(totalEstimatedCostFromEmail));
    }
}
