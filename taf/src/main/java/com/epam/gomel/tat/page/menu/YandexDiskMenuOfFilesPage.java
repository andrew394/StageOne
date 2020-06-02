package com.epam.gomel.tat.page.menu;

import com.epam.gomel.tat.page.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexDiskMenuOfFilesPage extends AbstractPage {

    private static final By SETTINGS = By.cssSelector("img[data-lego]");
    private static final By MENU_OF_FILES = By.xpath("//a[@title='Файлы']");
    private static final By TITLE_FILES = By.xpath("//h1[@title='Файлы']");
    private static final By MENU_OF_RECENT = By.xpath("//a[@title='Последние']");
    private static final By MENU_OF_PHOTO = By.xpath("//a[@title='Фото']");
    private static final By MENU_OF_SHARED = By.xpath("//a[@title='Общий доступ']");
    private static final By MENU_OF_HYSTORY = By.xpath("//a[@title='История']");
    private static final By MENU_OF_ARCHIVE = By.xpath("//a[@title='Архив']");
    private static final By MENU_OF_RECYCLE_BIN = By.xpath("//a[@title='Корзина']");
    private static final By CREATE_BUTTON = By.xpath("//button[contains(.,'Создать')]");
    private static final By CREATE_FOLDER = By.xpath("//button[contains(.,'Папку')]");

    public YandexDiskMenuOfFilesPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSettingsEnabled() {
        return isThePageOpened(SETTINGS);
    }

    public YandexDiskMenuOfFilesPage chooseTheMenuOfFiles() {
        waitForElementLocatedBy(MENU_OF_FILES).click();
        return this;
    }

    public boolean isMenuOfFilesEnabled() {
        return isThePageOpened(TITLE_FILES);
    }

    public YandexDiskMenuOfRecentPage chooseTheMenuOfRecent() {
        waitForElementLocatedBy(MENU_OF_RECENT).click();
        return new YandexDiskMenuOfRecentPage(driver);
    }

    public YandexDiskMenuOfPhotoPage chooseTheMenuOfPhoto() {
        waitForElementLocatedBy(MENU_OF_PHOTO).click();
        return new YandexDiskMenuOfPhotoPage(driver);
    }

    public YandexDiskMenuOfSharedPage chooseTheMenuOfShared() {
        waitForElementLocatedBy(MENU_OF_SHARED).click();
        return new YandexDiskMenuOfSharedPage(driver);
    }

    public YandexDiskMenuOfHistoryPage chooseTheMenuOfHistory() {
        waitForElementLocatedBy(MENU_OF_HYSTORY).click();
        return new YandexDiskMenuOfHistoryPage(driver);
    }

    public YandexDiskMenuOfArchivePage chooseTheMenuOfArchive() {
        waitForElementLocatedBy(MENU_OF_ARCHIVE).click();
        return new YandexDiskMenuOfArchivePage(driver);
    }

    public YandexDiskMenuOfRecycleBinPage chooseTheMenuOfRecycleBin() {
        waitForElementLocatedBy(MENU_OF_RECYCLE_BIN).click();
        return new YandexDiskMenuOfRecycleBinPage(driver);
    }

    public YandexDiskMenuOfFilesPage clickOnCreateButton() {
        waitForElementLocatedBy(CREATE_BUTTON).click();
        return this;
    }

    public YandexDiskCreateFolderPage clickOnCreateFolder() {
        waitForElementToBeClickableBy(CREATE_FOLDER).click();
        return new YandexDiskCreateFolderPage(driver);
    }
}
