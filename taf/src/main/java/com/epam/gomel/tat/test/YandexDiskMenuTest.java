package com.epam.gomel.tat.test;

import com.epam.gomel.tat.page.*;
import com.epam.gomel.tat.page.menu.YandexDiskMenuOfFilesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

public class YandexDiskMenuTest {

    private static final String LOGIN = "andrew-394";
    private static final String PASSWORD = "andrew394";
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
        boolean isMenuOfFilesCorrect = yandexDiskMenuOfFilesPage
                .chooseTheMenuOfFiles()
                .isMenuOfFilesEnabled();
        assertTrue(isMenuOfFilesCorrect);
    }

    @Test
    public void verifyMenuOfRecentTest() {
        boolean isMenuOfRecentCorrect = yandexDiskMenuOfFilesPage
                .chooseTheMenuOfRecent()
                .isMenuOfRecentEnabled();
        assertTrue(isMenuOfRecentCorrect);
    }

    @Test
    public void verifyMenuOfPhotoTest() {
        boolean isMenuOfPhotoCorrect = yandexDiskMenuOfFilesPage
                .chooseTheMenuOfPhoto()
                .isMenuOfPhotoEnabled();
        assertTrue(isMenuOfPhotoCorrect);
    }

    @Test
    public void verifyMenuOfSharedTest() {
        boolean isMenuOfSharedCorrect = yandexDiskMenuOfFilesPage
                .chooseTheMenuOfShared()
                .isMenuOfSharedEnabled();
        assertTrue(isMenuOfSharedCorrect);
    }

    @Test
    public void verifyMenuOfHistoryTest() {
        boolean isMenuOfHistoryCorrect = yandexDiskMenuOfFilesPage
                .chooseTheMenuOfHistory()
                .isMenuOfHistoryEnabled();
        assertTrue(isMenuOfHistoryCorrect);
    }

    @Test
    public void verifyMenuOfArchiveTest() {
        boolean isMenuOfArchiveCorrect = yandexDiskMenuOfFilesPage
                .chooseTheMenuOfArchive()
                .isMenuOfArchiveEnabled();
        assertTrue(isMenuOfArchiveCorrect);
    }

    @Test
    public void verifyMenuOfRecycleBinTest() {
        boolean isMenuOfRecycleBinCorrect = yandexDiskMenuOfFilesPage
                .chooseTheMenuOfRecycleBin()
                .isMenuOfRecycleBinEnabled();
        assertTrue(isMenuOfRecycleBinCorrect);
    }
}
