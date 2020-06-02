package com.epam.gomel.tat.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.stream.Collectors;

public class YandexDiskTextDocumentReopenPage extends AbstractPage {

    private static final String OPEN_DOCUMENT_TITLE = "//span[text()='%s']";
    private static final By TEXT_DOCUMENT = By.xpath("//div[@id='WACViewPanel_EditingElement']");
    private String name;

    YandexDiskTextDocumentReopenPage(WebDriver driver, String name) {
        super(driver);
        this.name = name;
    }

    public boolean isOnenedTextDocument() {
        driver.switchTo().frame(0);
        By documentTitleBy = By.xpath(String.format(OPEN_DOCUMENT_TITLE, name));
        return isWaitForElementTextToBe(documentTitleBy, name);
    }

    public boolean isSavedCorrectlyTextDocument(String text) {
        driver.switchTo().frame(0);
        String textFromDocument = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(TEXT_DOCUMENT))
                .stream().map(WebElement::getText).collect(Collectors.joining()).trim();
        driver.switchTo().defaultContent();
        return textFromDocument.equals(text);
    }
}
