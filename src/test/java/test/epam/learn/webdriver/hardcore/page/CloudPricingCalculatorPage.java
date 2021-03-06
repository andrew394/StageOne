package test.epam.learn.webdriver.hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CloudPricingCalculatorPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='cloud-site']//iframe")
    private WebElement iframe;

    @FindBy(id = "myFrame")
    private WebElement myFrame;

    @FindBy(id = "input_58")
    private WebElement numberOfInstances;

    @FindBy(id = "select_value_label_51")
    private WebElement operatingSystemButton;

    @FindBy(id = "select_option_60")
    private WebElement selectedOperatingSystem;

    @FindBy(id = "select_value_label_52")
    private WebElement vMClassButton;

    @FindBy(id = "select_option_72")
    private WebElement selectedVMClass;

    @FindBy(id = "select_value_label_55")
    private WebElement instanceTypeButton;

    @FindBy(id = "select_option_212")
    private WebElement selectedInstanceType;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement addGPUsBox;

    @FindBy(id = "select_value_label_332")
    private WebElement numberOfGPUsButton;

    @FindBy(id = "select_option_339")
    private WebElement selectedNumberOfGPUs;

    @FindBy(id = "select_value_label_333")
    private WebElement GPUTypeButton;

    @FindBy(id = "select_option_346")
    private WebElement selectedGPUType;

    @FindBy(id = "select_value_label_169")
    private WebElement localSSDButton;

    @FindBy(id = "select_option_233")
    private WebElement selectedLocalSSD;

    @FindBy(id = "select_value_label_56")
    private WebElement datacenterLocationButton;

    @FindBy(id = "select_option_181")
    private WebElement selectedDatacenterLocation;

    @FindBy(id = "select_value_label_57")
    private WebElement commitedUsageButton;

    @FindBy(id = "select_option_90")
    private WebElement selectedCommitedUsage;

    @FindBy(xpath = "//*[@aria-label='Add to Estimate']")
    private WebElement addToEstimateButton;

    @FindBy(id = "email_quote")
    private WebElement emailEstimateButton;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailPaste;

    @FindBy(xpath = "//*[@aria-label='Send Email']")
    private WebElement sendEmailButton;

    @FindBy(xpath = "//*[@id='resultBlock']//h2/b")
    private WebElement totalEstimatedCost;

    public CloudPricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public CloudPricingCalculatorPage switchFrame() {
        driver.switchTo().frame(iframe).switchTo().frame(myFrame);
        return this;
    }

    public CloudPricingCalculatorPage addNumberOfInstances(String number) {
        numberOfInstances.sendKeys(number);
        return this;
    }

    public CloudPricingCalculatorPage chooseOperatingSystem() {
        operatingSystemButton.click();
        clickAsJavascriptExecutor(selectedOperatingSystem);
        return this;
    }

    public CloudPricingCalculatorPage chooseVMClass() {
        clickAsJavascriptExecutor(vMClassButton);
        clickAsJavascriptExecutor(selectedVMClass);
        return this;
    }

    public CloudPricingCalculatorPage chooseInstanceType() {
        clickAsJavascriptExecutor(instanceTypeButton);
        clickAsJavascriptExecutor(selectedInstanceType);
        return this;
    }

    public CloudPricingCalculatorPage chooseAddGPUs() {
        clickAsJavascriptExecutor(addGPUsBox);
        return this;
    }

    public CloudPricingCalculatorPage chooseNumberOfGPUs() {
        clickAsJavascriptExecutor(numberOfGPUsButton);
        clickAsJavascriptExecutor(selectedNumberOfGPUs);
        return this;
    }

    public CloudPricingCalculatorPage chooseGPUType() {
        clickAsJavascriptExecutor(GPUTypeButton);
        clickAsJavascriptExecutor(selectedGPUType);
        return this;
    }

    public CloudPricingCalculatorPage chooseLocalSSD() {
        clickAsJavascriptExecutor(localSSDButton);
        clickAsJavascriptExecutor(selectedLocalSSD);
        return this;
    }

    public CloudPricingCalculatorPage chooseDatacenterLocation() {
        clickAsJavascriptExecutor(datacenterLocationButton);
        clickAsJavascriptExecutor(selectedDatacenterLocation);
        return this;
    }

    public CloudPricingCalculatorPage chooseCommitedUsage() {
        clickAsJavascriptExecutor(commitedUsageButton);
        clickAsJavascriptExecutor(selectedCommitedUsage);
        return this;
    }

    public CloudPricingCalculatorPage clickAddToEstimate() {
        clickAsJavascriptExecutor(addToEstimateButton);
        return this;
    }

    public TenMinuteMailHomePage clickOnEmailEstimate() {
        waitForElementVisibilityOf(emailEstimateButton);
        clickAsJavascriptExecutor(emailEstimateButton);
        return new TenMinuteMailHomePage(driver);
    }

    public CloudPricingCalculatorPage pasteEmailFromTenMinuteMail(String email) {
        emailPaste.sendKeys(email);
        return this;
    }

    public TenMinuteMailHomePage clickOnSendEmail() {
        waitForElementVisibilityOf(sendEmailButton);
        clickAsJavascriptExecutor(sendEmailButton);
        return new TenMinuteMailHomePage(driver);
    }

    public CloudPricingCalculatorPage switchToFindFirstWindowOpened() {
        driver.getWindowHandles().stream().findFirst().ifPresent(screen -> driver.switchTo().window(screen));
        return this;
    }

    public String getTotalEstimatedCost() {
        return totalEstimatedCost.getText();
    }
}
