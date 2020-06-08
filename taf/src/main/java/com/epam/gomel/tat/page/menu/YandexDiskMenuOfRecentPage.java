package com.epam.gomel.tat.page.menu;

import com.epam.gomel.tat.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexDiskMenuOfRecentPage extends AbstractPage {

    private static final By TITLE_RECENT = By.xpath("//h1[@title='Последние файлы']");

    public YandexDiskMenuOfRecentPage(WebDriver driver) {
        super(driver);
    }

    public boolean isMenuOfRecentEnabled() {
        return isThePageOpened(TITLE_RECENT);
    }
}
