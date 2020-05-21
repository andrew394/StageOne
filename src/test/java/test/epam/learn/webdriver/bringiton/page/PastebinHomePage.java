package test.epam.learn.webdriver.bringiton.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.epam.learn.webdriver.bringiton.util.CustomCondition;

public class PastebinHomePage {

    private static final String HOMEPAGE_URL = "https://pastebin.com";
    private static final int WAIT_TIMEOUT_SECOND = 5;
    private WebDriver driver;

    @FindBy(id = "paste_code")
    private WebElement newPaste;

    @FindBy(xpath = "//*[@id='myform']/div[3]/div[1]//span[1]/span/span[2]")
    private WebElement selectSyntaxHighlightingButton;

    @FindBy(xpath = "//*[@id='myform']/div[3]/div[1]//option[3]")
    private WebElement choiceSyntaxHighlighting;

    @FindBy (xpath = "//*[@id='myform']/div[3]/div[2]//span[1]/span/span[2]")
    private WebElement selectPasteExpirationButton;

    @FindBy(xpath = "//option[@value='10M']")
    private WebElement choicePasteExpiration;

    @FindBy(name = "paste_name")
    private WebElement newPasteName;

    @FindBy(id = "submit")
    private WebElement createPasteButton;

    public PastebinHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PastebinHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(CustomCondition.jQueryAJAXsCompleted());
        return this;
    }

    public PastebinHomePage newForCode(String code) {
        newPaste.sendKeys(code);
        return this;
    }

    public PastebinHomePage newForSyntaxHighlighting() {
        selectSyntaxHighlightingButton.click();
        waitForElementVisibilityOf(driver, choiceSyntaxHighlighting);
        choiceSyntaxHighlighting.click();
        selectSyntaxHighlightingButton.click();
        return this;
    }

    public PastebinHomePage newForPasteExpiration()  {
        selectPasteExpirationButton.click();
        waitForElementVisibilityOf(driver, choicePasteExpiration);
        choicePasteExpiration.click();
        selectPasteExpirationButton.click();
        return this;
    }

    public PastebinHomePage newForPasteName(String pasteName) {
        newPasteName.sendKeys(pasteName);
        return this;
    }

    public PastebinPastePage createForNewPaste() {
        createPasteButton.submit();
        return new PastebinPastePage(driver);
    }

    private void waitForElementVisibilityOf(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.visibilityOf(element));
    }
}
