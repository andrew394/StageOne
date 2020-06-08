package com.epam.gomel.tat.test;

import com.epam.gomel.tat.page.YandexDiskHomePage;
import com.epam.gomel.tat.page.menu.YandexDiskMenuOfFilesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.gomel.tat.page.AbstractPage.LOGIN;
import static com.epam.gomel.tat.page.AbstractPage.PASSWORD;
import static org.testng.Assert.assertTrue;

public class YandexDiskEmptyRecycleBinTest {

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

    @AfterClass(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    public void verifyDocumentRemovedCompletelyTest() {
        boolean isDocumentRemovedCorrect = yandexDiskMenuOfFilesPage
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
                .clickOnCleanBinButton()
                .clickOnConfirmCleanBinButton()
                .isDocumentRemovedCompletely();
        assertTrue(isDocumentRemovedCorrect);
    }
}
