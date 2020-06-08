package com.epam.gomel.tat.test;

import com.epam.gomel.tat.page.YandexDiskHomePage;
import com.epam.gomel.tat.page.menu.YandexDiskMenuOfFilesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.gomel.tat.page.AbstractPage.LOGIN;
import static com.epam.gomel.tat.page.AbstractPage.PASSWORD;
import static org.testng.Assert.assertTrue;

public class YandexDiskRemovalTextDocumentTest {

    private static final String TEXT = "Hello world!";
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

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        yandexDiskMenuOfFilesPage.chooseTheMenuOfFiles();
    }

    @AfterClass(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    public void verifyDocumentInRecycleBinTest() {
        boolean isDocumentInRecycleBin = yandexDiskMenuOfFilesPage
                .clickOnCreateButton()
                .clickOnCreateFolder()
                .addNameOfFolder()
                .clickOnSaveFolder()
                .openCreatedFolder()
                .clickOnButtonCreate()
                .clickOnCreateTextDocument()
                .clickOnDocumentTitleButton()
                .addNameOfTextDocument()
                .addTextToTextDocument(TEXT)
                .closeTab()
                .switchToTheYandexDiskFolderPage()
                .chooseTextDocument()
                .clickOnDeleteButton()
                .openTheMenuOfRecycleBin()
                .isDocumentInsideRecycleBin();
        assertTrue(isDocumentInRecycleBin);
    }

    @Test
    public void verifyDocumentNotInOriginFolderTest() {
        boolean isDocumentNotInOriginFolder = yandexDiskMenuOfFilesPage
                .clickOnCreateButton()
                .clickOnCreateFolder()
                .addNameOfFolder()
                .clickOnSaveFolder()
                .openCreatedFolder()
                .clickOnButtonCreate()
                .clickOnCreateTextDocument()
                .clickOnDocumentTitleButton()
                .addNameOfTextDocument()
                .addTextToTextDocument(TEXT)
                .closeTab()
                .switchToTheYandexDiskFolderPage()
                .chooseTextDocument()
                .clickOnDeleteButton()
                .isDocumentNotInsideFolder();
        assertTrue(isDocumentNotInOriginFolder);
    }
}
