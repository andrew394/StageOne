package com.epam.gomel.tat.page;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexDiskCreateFolderPage extends AbstractPage {

    private static final By FOLDER_NAME_BOX = By.xpath("//form[@class='rename-dialog__rename-form']//input");
    private static final By FOLDER_SAVE = By.xpath("//button[contains(.,'Сохранить')]");
    private static final By CREATED_FOLDER = By.xpath("//div[text()='Вы создали папку ']");
    private static final String CHOOSE_CREATED_FOLDER = "//div[@class='listing-item__info']//span[text()='%s']";
    private String name = new Faker().random().hex();
    private By createdFolderBy = By.xpath(String.format(CHOOSE_CREATED_FOLDER, name));

    public YandexDiskCreateFolderPage(WebDriver driver) {
        super(driver);
    }

    public YandexDiskCreateFolderPage addNameOfFolder() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.attributeToBe(FOLDER_NAME_BOX, "value", "Новая папка"));
        do {
            waitForElementLocatedBy(FOLDER_NAME_BOX).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
            waitForElementLocatedBy(FOLDER_NAME_BOX).sendKeys(name);
        } while (!waitForElementLocatedBy(FOLDER_NAME_BOX).getAttribute("value").equals(name));
        return this;
    }

    public YandexDiskCreateFolderPage clickOnSaveFolder() {
        waitForElementLocatedBy(FOLDER_SAVE).click();
        waitForElementLocatedBy(CREATED_FOLDER);
        return this;
    }

    public boolean isCreatedFolder() {
        return isThePageOpened(createdFolderBy);
    }

    public YandexDiskFolderPage openCreatedFolder() {
        Actions actions = new Actions(driver);
        actions.doubleClick(waitForElementLocatedBy(createdFolderBy)).build().perform();
        return new YandexDiskFolderPage(driver, name);
    }
}
