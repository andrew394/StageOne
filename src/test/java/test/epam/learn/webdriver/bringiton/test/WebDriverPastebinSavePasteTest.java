package test.epam.learn.webdriver.bringiton.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.epam.learn.webdriver.bringiton.page.PastebinHomePage;
import test.epam.learn.webdriver.bringiton.page.PastebinPastePage;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class WebDriverPastebinSavePasteTest {

    private static final String CODE = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    private static final String PASTE_NAME = "how to gain dominance among developers";
    private static final List<String> codeList = Arrays.asList(
            "git config --global user.name  \"New Sheriff in Town\"",
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")",
            "git push origin master --force"
    );
    private WebDriver driver;
    private PastebinPastePage pastebinPastePage;

    @BeforeMethod(alwaysRun = true)
    public void browserSetUp() {
        driver = new ChromeDriver();
        pastebinPastePage = new PastebinHomePage(driver)
                .openPage()
                .addCode(CODE)
                .chooseSyntaxHighlighting()
                .choosePasteExpiration()
                .addPasteName(PASTE_NAME)
                .createNewPaste();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    public void testPasteNameCorresponds() {
        assertTrue(pastebinPastePage.driverTitleCorrespondsToPasteName());
    }

    @Test
    public void testSyntaxHighlighted() {
        assertTrue(pastebinPastePage.syntaxHighlightedForBash());
    }

    @Test
    public void testCodeCorresponds() {
        assertTrue(pastebinPastePage.codeCorrespondsToTheEntered(codeList));
    }
}
