package com.epam.gomel.tat.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YandexDiskHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://disk.yandex.by/";
    private static final By LOGIN_BUTTON = By.linkText("Войти");

    public YandexDiskHomePage(WebDriver driver) {
        super(driver);
    }

    public YandexDiskHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public PassportYandexPage enterThePassportYandexPage() {
        WebElement login = waitForElementLocatedBy(LOGIN_BUTTON);
        login.click();
        return new PassportYandexPage(driver);
    }
}
