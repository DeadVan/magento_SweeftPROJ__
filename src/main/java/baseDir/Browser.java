package baseDir;

import baseDir.elements.BaseElement;
import org.openqa.selenium.WebDriver;

public class Browser extends BaseForm{

    public Browser(BaseElement locator, String name, WebDriver driver) {
        super(locator, name, driver);
    }


    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void navigateForward() {
        driver.navigate().forward();
    }
}
