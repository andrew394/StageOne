package com.epam.gomel.tat.test;

import com.epam.gomel.tat.page.YandexDiskHomePage;
import com.epam.gomel.tat.page.menu.YandexDiskMenuOfFilesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static com.epam.gomel.tat.page.AbstractPage.LOGIN;
import static com.epam.gomel.tat.page.AbstractPage.PASSWORD;
import static org.testng.Assert.assertTrue;

public class YandexDiskCreateFolderTest {

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
    public void verifyCreateFolderTest() {
        boolean isCreatedFolderCorrect = yandexDiskMenuOfFilesPage
                .clickOnCreateButton()
                .clickOnCreateFolder()
                .addNameOfFolder()
                .clickOnSaveFolder()
                .isCreatedFolder();
        assertTrue(isCreatedFolderCorrect);
    }

    @Test
    public void verifyOpenFolderTest() {
        boolean isOpenedFolderCorrect = yandexDiskMenuOfFilesPage
                .clickOnCreateButton()
                .clickOnCreateFolder()
                .addNameOfFolder()
                .clickOnSaveFolder()
                .openCreatedFolder()
                .isOnenedFolder();
        assertTrue(isOpenedFolderCorrect);
    }
}
