package com.epam.gomel.tat.test;

import com.epam.gomel.tat.page.PassportYandexPage;
import com.epam.gomel.tat.page.YandexDiskHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class YandexDiskLoginTest {

    private static final String LOGIN = "andrew-394";
    private static final String PASSWORD = "andrew394";
    private static final String PASSWORD_INCORRECT = "a";
    private WebDriver driver;
    private PassportYandexPage passportYandexPage;

    @BeforeMethod(alwaysRun = true)
    public void browserSetUp() {
        driver = new ChromeDriver();
        passportYandexPage = new PassportYandexPage(driver);
        new YandexDiskHomePage(driver)
                .openPage()
                .enterThePassportYandexPage()
                .enterLogin(LOGIN)
                .clickOnEnterButton();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    public void verifyLoginTest() {
        boolean isLoginCorrect = passportYandexPage
                .enterPassword(PASSWORD)
                .enterTheMenuOfFilesPage()
                .isSettingsEnabled();
        assertTrue(isLoginCorrect);
    }

    @Test
    public void verifyLoginIncorrectTest() {
        boolean isLoginCorrect = passportYandexPage
                .enterPassword(PASSWORD_INCORRECT)
                .enterTheMenuOfFilesPage()
                .isSettingsEnabled();
        assertFalse(isLoginCorrect);
    }
}
