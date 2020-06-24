package com.epam.ta.page;

import com.epam.ta.model.Search;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CloudHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://cloud.google.com";

    @FindBy(name = "q")
    private WebElement searchBox;

    public CloudHomePage(WebDriver driver) {
        super(driver);
    }

    public CloudHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public CloudHomePage enterTermInTneSearchBox(Search search) {
        waitForElementVisibilityOf(searchBox);
        searchBox.sendKeys(search.getTerm());
        return this;
    }

    public SearchResultPage submitSearchBoxRequest() {
        searchBox.submit();
        return new SearchResultPage(driver);
    }

}
