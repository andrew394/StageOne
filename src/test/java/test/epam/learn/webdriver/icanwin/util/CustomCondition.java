package test.epam.learn.webdriver.icanwin.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomCondition {

    public static ExpectedCondition<Boolean> jQueryAJAXsCompleted() {
        return driver -> (Boolean) ((JavascriptExecutor)driver).
                executeScript("return (window.jQuery != null) && (jQuery.active == 0); ");
    }
}
