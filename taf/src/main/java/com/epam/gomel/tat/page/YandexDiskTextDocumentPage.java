package com.epam.gomel.tat.page;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class YandexDiskTextDocumentPage extends AbstractPage {

    private static final By DOCUMENT_SAVE = By.xpath("//span[contains(@class,'status')]");
    private static final By TITLE_BUTTON = By.id("documentTitle");
    private static final By OPENED_TITLE = By.xpath("//span[text()='.docx']");
    private static final By DOCUMENT_NAME_BOX = By.id("CommitNewDocumentTitle");
    private static final By LINE_FOR_DOCUMENT = By.xpath("//div[@id='WACViewPanel_EditingElement']");
    private String textDocumentName = new Faker().random().hex();

    public YandexDiskTextDocumentPage(WebDriver driver) {
        super(driver);
    }

    public YandexDiskTextDocumentPage clickOnDocumentTitleButton() {
        driver.switchTo().frame(0);
        isWaitForElementTextToBe(DOCUMENT_SAVE, "Сохранено в Yandex");
        waitForElementLocatedBy(TITLE_BUTTON).click();
        waitForElementLocatedBy(OPENED_TITLE);
        return this;
    }

    public YandexDiskTextDocumentPage addNameOfTextDocument() {
        waitForElementLocatedBy(DOCUMENT_NAME_BOX).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        waitForElementLocatedBy(DOCUMENT_NAME_BOX).sendKeys(textDocumentName);
        waitForElementLocatedBy(DOCUMENT_NAME_BOX).sendKeys(Keys.ENTER);
        isWaitForElementTextToBe(DOCUMENT_SAVE, "Сохранено в Yandex");
        return this;
    }

    public YandexDiskTextDocumentPage addTextToTextDocument(String text) {
        waitForElementLocatedBy(LINE_FOR_DOCUMENT).sendKeys(Keys.HOME, text);
        isWaitForElementTextToBe(DOCUMENT_SAVE, "Сохранено в Yandex");
        return this;
    }

    public YandexDiskTextDocumentPage closeTab() {
        closeCurrentTab();
        return this;
    }

    public YandexDiskFolderPage switchToTheYandexDiskFolderPage() {
        switchToTab(0);
        return new YandexDiskFolderPage(driver, textDocumentName);
    }
}
