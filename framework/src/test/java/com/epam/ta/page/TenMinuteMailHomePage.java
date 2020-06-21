package com.epam.ta.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TenMinuteMailHomePage extends AbstractPage {

    @FindBy(id = "mail_address")
    WebElement mailAddress;

    @FindBy(className = "small_subject")
    WebElement openingMailButton;

    @FindBy(xpath = "//tr[@id='mobilepadding']//td[2]/h3")
    WebElement totalEstimatedCostFromMail;

    public TenMinuteMailHomePage(WebDriver driver) {
        super(driver);
    }

    public TenMinuteMailHomePage openTenMinuteMailHomePage() {
        ((JavascriptExecutor) driver).executeScript("window.open('https://10minutemail.com/')");
        driver.getWindowHandles().forEach(screen -> driver.switchTo().window(screen));
        return this;
    }

    public TenMinuteMailHomePage switchToNewWindowOpened() {
        driver.getWindowHandles().forEach(screen -> driver.switchTo().window(screen));
        return this;
    }

    public TenMinuteMailHomePage clickToOpenMail() {
        waitForElementVisibilityOf(openingMailButton);
        clickAsJavascriptExecutor(openingMailButton);
        return this;
    }

    public String getEmailAddress() {
        return mailAddress.getAttribute("value");
    }

    public String getTotalEstimatedCostFromMail() {
        return totalEstimatedCostFromMail.getText();
    }
}
