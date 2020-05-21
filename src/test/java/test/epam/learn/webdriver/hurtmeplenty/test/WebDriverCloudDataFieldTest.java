package test.epam.learn.webdriver.hurtmeplenty.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.epam.learn.webdriver.hurtmeplenty.page.CloudHomePage;
import test.epam.learn.webdriver.hurtmeplenty.page.CloudPricingCalculatorPage;

public class WebDriverCloudDataFieldTest {

    private static final String term = "Google Cloud Platform Pricing Calculator";
    private static final String number = "4";
    private static final String expectedVMClass = "VM class: regular";
    private static final String expectedInstanceType = "Instance type: n1-standard-8";
    private static final String expectedRegion = "Region: Frankfurt";
    private static final String expectedLocalSSD = "Total available local SSD space 2x375 GiB";
    private static final String expectedCommitmentTerm = "Commitment term: 1 Year";
    private static final String expectedEstimatedCost = "Total Estimated Cost: USD 1,082.77 per 1 month";
    private WebDriver driver;
    private CloudPricingCalculatorPage cloudPricingCalculatorPage;

    @BeforeMethod(alwaysRun = true)
    public void browserSetUp() {
        driver = new ChromeDriver();
        cloudPricingCalculatorPage = new CloudPricingCalculatorPage(driver);
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
                .newForAddToEstimate();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    public void testEstimateVMClass()  {
        Assert.assertEquals(cloudPricingCalculatorPage.findEstimateVMClass(), expectedVMClass);
    }

    @Test
    public void testEstimateInstanceType() {
        Assert.assertEquals(cloudPricingCalculatorPage.findEstimateInstanceType(), expectedInstanceType);
    }

    @Test
    public void testEstimateRegion() {
        Assert.assertEquals(cloudPricingCalculatorPage.findEstimateRegion(), expectedRegion);
    }

    @Test
    public void testEstimateLocalSSD() {
        Assert.assertEquals(cloudPricingCalculatorPage.findEstimateLocalSSD(), expectedLocalSSD);
    }

    @Test
    public void testEstimateCommitmentTerm() {
        Assert.assertEquals(cloudPricingCalculatorPage.findEstimateCommitmentTerm(), expectedCommitmentTerm);
    }

    @Test
    public void testTotalEstimatedCost() {
        Assert.assertEquals(cloudPricingCalculatorPage.findTotalEstimatedCost(), expectedEstimatedCost);
    }
}
