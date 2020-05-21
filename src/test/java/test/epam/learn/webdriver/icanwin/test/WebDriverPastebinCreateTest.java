package test.epam.learn.webdriver.icanwin.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.epam.learn.webdriver.icanwin.page.PastebinHomePage;

public class WebDriverPastebinCreateTest {

    private static final String CODE = "Hello from WebDriver";
    private static final String PASTE_NAME = "helloweb";
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetUp() {
        driver = new ChromeDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    public void testCreatePaste() {
        new PastebinHomePage(driver)
                .openPage()
                .newForCode(CODE)
                .newForPasteExpiration()
                .newForPasteName(PASTE_NAME)
                .createForNewPaste();
    }
}
