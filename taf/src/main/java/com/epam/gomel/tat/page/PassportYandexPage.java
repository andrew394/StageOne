package com.epam.gomel.tat.page;

import com.epam.gomel.tat.page.menu.YandexDiskMenuOfFilesPage;
import org.openqa.selenium.*;

public class PassportYandexPage extends AbstractPage {

    private static final By LOGIN_BOX = By.name("login");
    private static final By PASSWORD_BOX = By.name("passwd");
    private static final By ENTER_BUTTON = By.xpath("//button[contains(@type,'submit')]");

    public PassportYandexPage(WebDriver driver) {
        super(driver);
    }

    public PassportYandexPage enterLogin(String username) {
        WebElement login = waitForElementLocatedBy(LOGIN_BOX);
        login.sendKeys(username);
        return this;
    }

    public PassportYandexPage enterPassword(String password) {
        waitForElementLocatedBy(PASSWORD_BOX).sendKeys(password);
        return this;
    }

    public PassportYandexPage clickOnEnterButton() {
        waitForElementLocatedBy(ENTER_BUTTON).click();
        return this;
    }

    public YandexDiskMenuOfFilesPage enterTheMenuOfFilesPage() {
        waitForElementLocatedBy(ENTER_BUTTON).click();
        return new YandexDiskMenuOfFilesPage(driver);
    }
}
