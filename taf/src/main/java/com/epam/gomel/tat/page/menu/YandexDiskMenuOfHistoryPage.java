package com.epam.gomel.tat.page.menu;

import com.epam.gomel.tat.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexDiskMenuOfHistoryPage extends AbstractPage {

    private static final By TITLE_HISTORY = By.xpath("//h1[text()='История']");

    public YandexDiskMenuOfHistoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isMenuOfHistoryEnabled() {
        return isThePageOpened(TITLE_HISTORY);
    }
}
