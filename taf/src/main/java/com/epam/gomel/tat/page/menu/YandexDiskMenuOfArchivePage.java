package com.epam.gomel.tat.page.menu;

import com.epam.gomel.tat.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexDiskMenuOfArchivePage extends AbstractPage {

    private static final By TITLE_ARCHIVE = By.xpath("//h1[@title='Архив']");

    public YandexDiskMenuOfArchivePage(WebDriver driver) {
        super(driver);
    }

    public boolean isMenuOfArchiveEnabled() {
        return isThePageOpened(TITLE_ARCHIVE);
    }
}
