package test.epam.learn.webdriver.hurtmeplenty.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.epam.learn.webdriver.hurtmeplenty.page.CloudHomePage;
import test.epam.learn.webdriver.hurtmeplenty.page.CloudPricingCalculatorPage;

import static org.testng.Assert.assertEquals;

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
                .clickOnAddToEstimate();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    public void testEstimateVMClass()  {
        assertEquals(cloudPricingCalculatorPage.getEstimateVMClass(), expectedVMClass);
    }

    @Test
    public void testEstimateInstanceType() {
        assertEquals(cloudPricingCalculatorPage.getEstimateInstanceType(), expectedInstanceType);
    }

    @Test
    public void testEstimateRegion() {
        assertEquals(cloudPricingCalculatorPage.getEstimateRegion(), expectedRegion);
    }

    @Test
    public void testEstimateLocalSSD() {
        assertEquals(cloudPricingCalculatorPage.getEstimateLocalSSD(), expectedLocalSSD);
    }

    @Test
    public void testEstimateCommitmentTerm() {
        assertEquals(cloudPricingCalculatorPage.getEstimateCommitmentTerm(), expectedCommitmentTerm);
    }

    @Test
    public void testTotalEstimatedCost() {
        assertEquals(cloudPricingCalculatorPage.getTotalEstimatedCost(), expectedEstimatedCost);
    }
}
