package test.epam.learn.webdriver.hurtmeplenty.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CloudPricingCalculatorPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='cloud-site']//iframe")
    private WebElement iframe;

    @FindBy(id = "myFrame")
    private WebElement myFrame;

    @FindBy(id = "input_58")
    WebElement numberOfInstances;

    @FindBy(id = "select_value_label_51")
    WebElement operatingSystemButton;

    @FindBy(id = "select_option_60")
    WebElement selectedOperatingSystem;

    @FindBy(id = "select_value_label_52")
    WebElement vMClassButton;

    @FindBy(id = "select_option_72")
    WebElement selectedVMClass;

    @FindBy(id = "select_value_label_55")
    WebElement instanceTypeButton;

    @FindBy(id = "select_option_212")
    WebElement selectedInstanceType;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    WebElement addGPUsBox;

    @FindBy(id = "select_value_label_332")
    WebElement numberOfGPUsButton;

    @FindBy(id = "select_option_339")
    WebElement selectedNumberOfGPUs;

    @FindBy(id = "select_value_label_333")
    WebElement GPUTypeButton;

    @FindBy(id = "select_option_346")
    WebElement selectedGPUType;

    @FindBy(id = "select_value_label_169")
    WebElement localSSDButton;

    @FindBy(id = "select_option_233")
    WebElement selectedLocalSSD;

    @FindBy(id = "select_value_label_56")
    WebElement datacenterLocationButton;

    @FindBy(id = "select_option_181")
    WebElement selectedDatacenterLocation;

    @FindBy(id = "select_value_label_57")
    WebElement commitedUsageButton;

    @FindBy(id = "select_option_90")
    WebElement selectedCommitedUsage;

    @FindBy(xpath = "//*[@aria-label='Add to Estimate']")
    WebElement addToEstimateButton;

    @FindBy(xpath = "//*[@id='compute']//md-list-item[2]")
    WebElement estimateVMClass;

    @FindBy(xpath = "//*[@id='compute']//md-list-item[3]")
    WebElement estimateInstanceType;

    @FindBy(xpath = "//*[@id='compute']//md-list-item[4]")
    WebElement estimateRegion;

    @FindBy(xpath = "//*[@id='compute']//md-list-item[5]")
    WebElement estimateLocalSSD;

    @FindBy(xpath = "//*[@id='compute']//md-list-item[6]")
    WebElement estimateCommitmentTerm;

    @FindBy(xpath = "//*[@id='resultBlock']//h2/b")
    WebElement totalEstimatedCost;

    public CloudPricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public CloudPricingCalculatorPage newForFrame() {
        driver.switchTo().frame(iframe).switchTo().frame(myFrame);
        return this;
    }

    public CloudPricingCalculatorPage newForNumberOfInstances(String number) {
        numberOfInstances.sendKeys(number);
        return this;
    }

    public CloudPricingCalculatorPage newForOperatingSystem() {
        operatingSystemButton.click();
        clickAsJavascriptExecutor(selectedOperatingSystem);
        return this;
    }

    public CloudPricingCalculatorPage newForVMClass() {
        clickAsJavascriptExecutor(vMClassButton);
        clickAsJavascriptExecutor(selectedVMClass);
        return this;
    }

    public CloudPricingCalculatorPage newForInstanceType() {
        clickAsJavascriptExecutor(instanceTypeButton);
        clickAsJavascriptExecutor(selectedInstanceType);
        return this;
    }

    public CloudPricingCalculatorPage newForAddGPUs() {
        clickAsJavascriptExecutor(addGPUsBox);
        return this;
    }

    public CloudPricingCalculatorPage newForNumberOfGPUs() {
        clickAsJavascriptExecutor(numberOfGPUsButton);
        clickAsJavascriptExecutor(selectedNumberOfGPUs);
        return this;
    }

    public CloudPricingCalculatorPage newForGPUType() {
        clickAsJavascriptExecutor(GPUTypeButton);
        clickAsJavascriptExecutor(selectedGPUType);
        return this;
    }

    public CloudPricingCalculatorPage newForLocalSSD() {
        clickAsJavascriptExecutor(localSSDButton);
        clickAsJavascriptExecutor(selectedLocalSSD);
        return this;
    }

    public CloudPricingCalculatorPage newForDatacenterLocation() {
        clickAsJavascriptExecutor(datacenterLocationButton);
        clickAsJavascriptExecutor(selectedDatacenterLocation);
        return this;
    }

    public CloudPricingCalculatorPage newForCommitedUsage() {
        clickAsJavascriptExecutor(commitedUsageButton);
        clickAsJavascriptExecutor(selectedCommitedUsage);
        return this;
    }

    public CloudPricingCalculatorPage newForAddToEstimate() {
        clickAsJavascriptExecutor(addToEstimateButton);
        return this;
    }

    public String findEstimateVMClass() {
        return estimateVMClass.getText();
    }

    public String findEstimateInstanceType() {
        return estimateInstanceType.getText();
    }

    public String findEstimateRegion() {
        return estimateRegion.getText();
    }

    public String findEstimateLocalSSD() {
        return estimateLocalSSD.getText();
    }

    public String findEstimateCommitmentTerm() {
        return estimateCommitmentTerm.getText();
    }

    public String findTotalEstimatedCost() {
        return totalEstimatedCost.getText();
    }
}
