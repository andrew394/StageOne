package test.epam.learn.webdriver.hurtmeplenty.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    private static final int WAIT_TIMEOUT_SECOND = 15;
    WebDriver driver;

    AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    void waitForElementVisibilityOf(WebElement element) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.visibilityOf(element));
    }

    void clickAsJavascriptExecutor(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}
