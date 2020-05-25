package test.epam.learn.webdriver.bringiton.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class PastebinPastePage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class='paste_box_line1']/h1")
    private WebElement pasteName;

    @FindBy (xpath = "//span[@class='h_640']/a")
    private WebElement syntaxHighlighting;

    @FindBy(className = "li1")
    private List<WebElement> codeList;

    public PastebinPastePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean driverTitleCorrespondsToPasteName() {
        return driver.getTitle().contains(pasteName.getText());
    }

    public boolean syntaxHighlightedForBash() {
        return syntaxHighlighting.getText().equals("Bash");
    }

    public boolean codeCorrespondsToTheEntered (List<String> expectedCodeList) {
        List<String> actualCodeList = codeList.stream().map(WebElement::getText).collect(Collectors.toList());
        return actualCodeList.equals(expectedCodeList);
    }
}
