package com.epam.gomel.tat.page.menu;

import com.epam.gomel.tat.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexDiskMenuOfPhotoPage extends AbstractPage {

    private static final By TITLE_PHOTO = By.xpath("//h1[text()='Все фотографии']");

    public YandexDiskMenuOfPhotoPage(WebDriver driver) {
        super(driver);
    }

    public boolean isMenuOfPhotoEnabled() {
        return isThePageOpened(TITLE_PHOTO);
    }
}
