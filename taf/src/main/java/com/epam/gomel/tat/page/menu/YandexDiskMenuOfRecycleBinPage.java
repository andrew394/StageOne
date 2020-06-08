package com.epam.gomel.tat.page.menu;

import com.epam.gomel.tat.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexDiskMenuOfRecycleBinPage extends AbstractPage {

    private static final By TITLE_RECYCLE_BIN = By.xpath("//h1[@title='Корзина']");
    private static final String DELETED_DOCUMENT = "//div/span[text()='%s.docx']";
    private static final By CLEAN_BIN_BUTTON = By.xpath("//button[contains(.,'Очистить Корзину')]");
    private static final By CONFIRM_CLEANING_BIN_BUTTON = By.xpath("//span[text()='Очистить']/ancestor::button");
    private String name;

    public YandexDiskMenuOfRecycleBinPage(WebDriver driver) {
        super(driver);
    }

    public YandexDiskMenuOfRecycleBinPage(WebDriver driver, String name) {
        super(driver);
        this.name = name;
    }

    public boolean isMenuOfRecycleBinEnabled() {
        return isThePageOpened(TITLE_RECYCLE_BIN);
    }

    public boolean isDocumentInsideRecycleBin() {
        By documentInsideFolderBy = By.xpath(String.format(DELETED_DOCUMENT, name));
        return isThePageOpened(documentInsideFolderBy);
    }

    public YandexDiskMenuOfRecycleBinPage clickOnCleanBinButton() {
        waitForElementLocatedBy(CLEAN_BIN_BUTTON).click();
        return this;
    }

    public YandexDiskMenuOfRecycleBinPage clickOnConfirmCleanBinButton() {
        waitForElementToBeClickableBy(CONFIRM_CLEANING_BIN_BUTTON).click();
        return this;
    }

    public boolean isDocumentRemovedCompletely() {
        By documentInsideFolderBy = By.xpath(String.format(DELETED_DOCUMENT, name));
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.invisibilityOfElementLocated(documentInsideFolderBy));
    }
}
