package com.epam.ta.page;

import com.epam.ta.model.Engine;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CloudPricingCalculatorPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='cloud-site']//iframe")
    private WebElement firstFrame;

    @FindBy(id = "myFrame")
    private WebElement secondFrame;

    @FindBy(id = "input_58")
    private WebElement numberOfInstances;

    @FindBy(id = "select_value_label_51")
    private WebElement operatingSystemButton;

    @FindBy(id = "select_option_60")
    private WebElement selectedOperatingSystem;

    @FindBy(id = "select_value_label_52")
    private WebElement vmClassButton;

    @FindBy(id = "select_option_72")
    private WebElement selectedVmClass;

    @FindBy(id = "select_value_label_55")
    private WebElement instanceTypeButton;

    @FindBy(id = "select_option_212")
    private WebElement selectedInstanceType;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement addGpusBox;

    @FindBy(id = "select_value_label_332")
    private WebElement numberOfGpusButton;

    @FindBy(id = "select_option_339")
    private WebElement selectedNumberOfGpus;

    @FindBy(id = "select_value_label_333")
    private WebElement GpuTypeButton;

    @FindBy(id = "select_option_346")
    private WebElement selectedGpuType;

    @FindBy(id = "select_value_label_169")
    private WebElement localSsdButton;

    @FindBy(id = "select_option_233")
    private WebElement selectedLocalSsd;

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
        driver.switchTo().frame(firstFrame).switchTo().frame(secondFrame);
        return this;
    }

    public CloudPricingCalculatorPage addNumberOfInstances(Engine engine) {
        numberOfInstances.sendKeys(engine.getNumberOfInstances());
        return this;
    }

    public CloudPricingCalculatorPage chooseOperatingSystem() {
        operatingSystemButton.click();
        clickAsJavascriptExecutor(selectedOperatingSystem);
        return this;
    }

    public CloudPricingCalculatorPage chooseVMClass() {
        clickAsJavascriptExecutor(vmClassButton);
        clickAsJavascriptExecutor(selectedVmClass);
        return this;
    }

    public CloudPricingCalculatorPage chooseInstanceType() {
        clickAsJavascriptExecutor(instanceTypeButton);
        clickAsJavascriptExecutor(selectedInstanceType);
        return this;
    }

    public CloudPricingCalculatorPage chooseAddGPUs() {
        clickAsJavascriptExecutor(addGpusBox);
        return this;
    }

    public CloudPricingCalculatorPage chooseNumberOfGPUs() {
        clickAsJavascriptExecutor(numberOfGpusButton);
        clickAsJavascriptExecutor(selectedNumberOfGpus);
        return this;
    }

    public CloudPricingCalculatorPage chooseGPUType() {
        clickAsJavascriptExecutor(GpuTypeButton);
        clickAsJavascriptExecutor(selectedGpuType);
        return this;
    }

    public CloudPricingCalculatorPage chooseLocalSSD() {
        clickAsJavascriptExecutor(localSsdButton);
        clickAsJavascriptExecutor(selectedLocalSsd);
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

    public CloudPricingCalculatorPage swithToFirstOpenedWindow() {
        driver.getWindowHandles().stream().findFirst().ifPresent(screen -> driver.switchTo().window(screen));
        return this;
    }

    public String getTotalEstimatedCost() {
        return totalEstimatedCost.getText();
    }
}
