package com.epam.gomel.tat.page;

import com.epam.gomel.tat.page.menu.YandexDiskMenuOfRecycleBinPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexDiskFolderPage extends AbstractPage {

    private static final String OPEN_CREATED_FOLDER = "//h1[@title='%s']";
    private static final By CREATE_BUTTON = By.xpath("//button[contains(.,'Создать')]");
    private static final By CREATE_TEXT_DOCUMENT = By.xpath("//button[contains(.,'Текстовый документ')]");
    private static final By DELETE_BUTTON = By.xpath("//button[contains(.,'Удалить')]");
    private static final By DELETED_DOCUMENT = By.xpath("//span[text()='Очистить Корзину']");
    private static final By DOCUMENT_IS_SAVED = By.xpath("//div[contains(@class,'column_size')]");
    private static final By MENU_OF_RECYCLE_BIN = By.xpath("//a[@title='Корзина']");
    private static final String CHOOSE_CREATED_DOCUMENT = "//div/span[text()='%s.docx']";
    private static final String AMOUNT_OF_MEMORY_BY_DEFAULT = "10,8 КБ";
    private String name;

    public YandexDiskFolderPage(WebDriver driver, String name) {
        super(driver);
        this.name = name;
    }

    public boolean isOnenedFolder() {
        By openedFolderBy = By.xpath(String.format(OPEN_CREATED_FOLDER, name));
        return isThePageOpened(openedFolderBy);
    }

    public YandexDiskFolderPage clickOnButtonCreate() {
        waitForElementLocatedBy(CREATE_BUTTON).click();
        return this;
    }

    public YandexDiskTextDocumentPage clickOnCreateTextDocument() {
        waitForElementToBeClickableBy(CREATE_TEXT_DOCUMENT).click();
        String originalHandle = driver.getWindowHandle();
        findNewWindowHandle(originalHandle);
        return new YandexDiskTextDocumentPage(driver);
    }

    public boolean isDocumentInsideAppropriateFolder() {
        By documentInsideAppropriateFolderBy = By.xpath(String.format(CHOOSE_CREATED_DOCUMENT, name));
        return isThePageOpened(documentInsideAppropriateFolderBy);
    }

    public YandexDiskTextDocumentReopenPage reopenTextDocument() {
        By textDocumentBy = By.xpath(String.format(CHOOSE_CREATED_DOCUMENT, name));
        Actions actions = new Actions(driver);
        actions.doubleClick(waitForElementLocatedBy(textDocumentBy)).build().perform();
        String originalHandle = driver.getWindowHandle();
        findNewWindowHandle(originalHandle);
        return new YandexDiskTextDocumentReopenPage(driver, name);
    }

    public YandexDiskFolderPage chooseTextDocument() {
        By textDocumentBy = By.xpath(String.format(CHOOSE_CREATED_DOCUMENT, name));
        Actions actions = new Actions(driver);
        actions.click(waitForElementLocatedBy(textDocumentBy)).build().perform();
        return this;
    }

    public YandexDiskFolderPage clickOnDeleteButton() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.not(
                        ExpectedConditions.textToBe(DOCUMENT_IS_SAVED, AMOUNT_OF_MEMORY_BY_DEFAULT)));
        waitForElementLocatedBy(DELETE_BUTTON).click();
        waitForElementLocatedBy(DELETED_DOCUMENT);
        return this;
    }

    public YandexDiskMenuOfRecycleBinPage openTheMenuOfRecycleBin() {
        waitForElementLocatedBy(MENU_OF_RECYCLE_BIN).click();
        return new YandexDiskMenuOfRecycleBinPage(driver, name);
    }

    public boolean isDocumentNotInsideFolder() {
        By documentInsideFolderBy = By.xpath(String.format(CHOOSE_CREATED_DOCUMENT, name));
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.invisibilityOfElementLocated(documentInsideFolderBy));
    }
}
