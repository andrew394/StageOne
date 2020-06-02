package com.epam.gomel.tat.page.menu;

import com.epam.gomel.tat.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexDiskMenuOfSharedPage extends AbstractPage {

    private static final By TITLE_SHARED = By.xpath("//h1[text()='Публичные ссылки']");

    public YandexDiskMenuOfSharedPage(WebDriver driver) {
        super(driver);
    }

    public boolean isMenuOfSharedEnabled() {
        return isThePageOpened(TITLE_SHARED);
    }
}
