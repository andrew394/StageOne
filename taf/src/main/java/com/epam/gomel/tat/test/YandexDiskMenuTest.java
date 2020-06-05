package com.epam.gomel.tat.test;

import com.epam.gomel.tat.page.*;
import com.epam.gomel.tat.page.menu.YandexDiskMenuOfFilesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static com.epam.gomel.tat.page.AbstractPage.LOGIN;
import static com.epam.gomel.tat.page.AbstractPage.PASSWORD;
import static org.testng.Assert.assertTrue;

public class YandexDiskMenuTest {

    private WebDriver driver;
    private YandexDiskMenuOfFilesPage yandexDiskMenuOfFilesPage;

    @BeforeClass(alwaysRun = true)
    public void browserSetUp() {
        driver = new ChromeDriver();
        yandexDiskMenuOfFilesPage = new YandexDiskMenuOfFilesPage(driver);
        new YandexDiskHomePage(driver)
                .openPage()
                .enterThePassportYandexPage()
                .enterLogin(LOGIN)
                .clickOnEnterButton()
                .enterPassword(PASSWORD)
                .enterTheMenuOfFilesPage();
    }

    @AfterClass(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    public void verifyMenuOfFilesTest() {
       assertTrue(yandexDiskMenuOfFilesPage
                .chooseTheMenuOfFiles()
                .isMenuOfFilesEnabled());
    }

    @Test
    public void verifyMenuOfRecentTest() {
        assertTrue(yandexDiskMenuOfFilesPage
                .chooseTheMenuOfRecent()
                .isMenuOfRecentEnabled());
    }

    @Test
    public void verifyMenuOfPhotoTest() {
        assertTrue(yandexDiskMenuOfFilesPage
                .chooseTheMenuOfPhoto()
                .isMenuOfPhotoEnabled());
    }

    @Test
    public void verifyMenuOfSharedTest() {
        assertTrue(yandexDiskMenuOfFilesPage
                .chooseTheMenuOfShared()
                .isMenuOfSharedEnabled());
    }

    @Test
    public void verifyMenuOfHistoryTest() {
        assertTrue(yandexDiskMenuOfFilesPage
                .chooseTheMenuOfHistory()
                .isMenuOfHistoryEnabled());
    }

    @Test
    public void verifyMenuOfArchiveTest() {
        assertTrue(yandexDiskMenuOfFilesPage
                .chooseTheMenuOfArchive()
                .isMenuOfArchiveEnabled());
    }

    @Test
    public void verifyMenuOfRecycleBinTest() {
        assertTrue(yandexDiskMenuOfFilesPage
                .chooseTheMenuOfRecycleBin()
                .isMenuOfRecycleBinEnabled());
    }
}
