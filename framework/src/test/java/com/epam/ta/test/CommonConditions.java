package com.epam.ta.test;

import com.epam.ta.driver.DriverSingleton;
import com.epam.ta.page.CloudPricingCalculatorPage;
import com.epam.ta.page.TenMinuteMailHomePage;
import com.epam.ta.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonConditions {

    WebDriver driver;
    CloudPricingCalculatorPage cloudPricingCalculatorPage;
    TenMinuteMailHomePage tenMinuteMailHomePage;

    @BeforeMethod(alwaysRun = true)
    public void browserSetUp() {
        driver = DriverSingleton.getDriver();
        cloudPricingCalculatorPage = new CloudPricingCalculatorPage(driver);
        tenMinuteMailHomePage = new TenMinuteMailHomePage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        DriverSingleton.closeDriver();
    }
}
