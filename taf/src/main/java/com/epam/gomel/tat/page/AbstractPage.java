package com.epam.gomel.tat.page;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public abstract class AbstractPage {

    public static final String LOGIN = "andrew-394";
    public static final String PASSWORD = "andrew394";
    protected static final int WAIT_TIMEOUT_SECONDS = 15;
    protected WebDriver driver;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    protected WebElement waitForElementLocatedBy(By by) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected WebElement waitForElementToBeClickableBy(By by) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    protected boolean isWaitForElementTextToBe(By by, String value) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.textToBe(by, value));
    }

    protected boolean isThePageOpened(By by) {
        try {
            return waitForElementLocatedBy(by).isEnabled();
        } catch (TimeoutException e) {
            return false;
        }
    }

    void closeCurrentTab() {
        driver.switchTo().window(driver.getWindowHandle()).close();
    }

    void switchToTab(int tabNumber) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNumber));
    }

    void findNewWindowHandle(String originalHandle) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if (tabs.size() > 1) {
            for (String handle : tabs) {
                if(!originalHandle.contentEquals(handle)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }
        }
    }
}
