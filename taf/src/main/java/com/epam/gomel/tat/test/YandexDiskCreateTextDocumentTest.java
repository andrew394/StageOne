package com.epam.gomel.tat.test;

import com.epam.gomel.tat.page.YandexDiskHomePage;
import com.epam.gomel.tat.page.menu.YandexDiskMenuOfFilesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static com.epam.gomel.tat.page.AbstractPage.LOGIN;
import static com.epam.gomel.tat.page.AbstractPage.PASSWORD;
import static org.testng.Assert.assertTrue;

public class YandexDiskCreateTextDocumentTest {

    private static final String TEXT = "Hello world!";
    private WebDriver driver;
    private YandexDiskMenuOfFilesPage yandexDiskMenuOfFilesPage;
    private String originalHandle;

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
        originalHandle = driver.getWindowHandle();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        yandexDiskMenuOfFilesPage.chooseTheMenuOfFiles();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        for(String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                driver.close();
            }
        }
        driver.switchTo().window(originalHandle);
    }

    @AfterClass(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    @Test(priority = 0)
    public void verifyDocumentInsideAppropriateFolderTest() {
        boolean isDocumentInsideFolderCorrect = yandexDiskMenuOfFilesPage
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
                .isDocumentInsideAppropriateFolder();
        assertTrue(isDocumentInsideFolderCorrect);
    }

    @Test(priority = 1)
    public void verifyOnenedTextDocumentTest() {
        boolean isOnenedTextDocumentCorrect = yandexDiskMenuOfFilesPage
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
                .reopenTextDocument()
                .isOnenedTextDocument();
        assertTrue(isOnenedTextDocumentCorrect);
    }

    @Test(priority = 2)
    public void verifySavedCorrectlyTextDocumentTest() {
        boolean isTextDocumentCorrect = yandexDiskMenuOfFilesPage
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
                .reopenTextDocument()
                .isSavedCorrectlyTextDocument(TEXT);
        assertTrue(isTextDocumentCorrect);
    }
}
