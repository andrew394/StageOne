package test.epam.learn.webdriver.bringiton.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.epam.learn.webdriver.bringiton.page.PastebinHomePage;

import java.util.Arrays;
import java.util.List;

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

    @BeforeMethod(alwaysRun = true)
    public void browserSetUp() {
        driver = new ChromeDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    public void testPasteNameCorresponds() {
        boolean pasteNameCorresponds = new PastebinHomePage(driver)
                .openPage()
                .newForCode(CODE)
                .newForSyntaxHighlighting()
                .newForPasteExpiration()
                .newForPasteName(PASTE_NAME)
                .createForNewPaste()
                .driverTitleCorrespondsToPasteName();
        Assert.assertTrue(pasteNameCorresponds);
    }

    @Test
    public void testSyntaxHighlighted() {
        boolean syntaxHighlighted = new PastebinHomePage(driver)
                .openPage()
                .newForCode(CODE)
                .newForSyntaxHighlighting()
                .newForPasteExpiration()
                .newForPasteName(PASTE_NAME)
                .createForNewPaste()
                .syntaxHighlightedForBash();
        Assert.assertTrue(syntaxHighlighted);
    }

    @Test
    public void testCodeCorresponds() {
        boolean codeCorresponds = new PastebinHomePage(driver)
                .openPage()
                .newForCode(CODE)
                .newForSyntaxHighlighting()
                .newForPasteExpiration()
                .newForPasteName(PASTE_NAME)
                .createForNewPaste()
                .codeCorrespondsToTheEntered(codeList);
        Assert.assertTrue(codeCorresponds);
    }
}
