package baseDir.elements;

import baseDir.utils.WaitUtils;
import baseDir.singeltonPattern.WebDriverSingleton;
import org.openqa.selenium.*;

import java.util.List;

public class BaseElement {
    protected WebDriver driver;
    protected By uniquelocator;


    public BaseElement(By locator) {
        this.driver = WebDriverSingleton.getCurrentDriver();
        this.uniquelocator = locator;
    }

    protected WebElement findElement() {
        return driver.findElement(uniquelocator);
    }
    public List<WebElement> findElements(By uniquelocator){
        return WebDriverSingleton.getCurrentDriver().findElements(uniquelocator);
    }

    public void click() {
        findElement().click();
    }

    public void clickButnViaJs() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", findElement());
    }

    public void waitClick() {
        WaitUtils.waitForElementToBeClickable(uniquelocator);
        WaitUtils.waitForElementToBeVisible(uniquelocator);
        findElement().click();
    }


    public String getText() {
        return findElement().getText();
    }


    public boolean isDisplayed() {
        try {
            WaitUtils.waitForElementToBeVisible(uniquelocator);
            return findElement().isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            return false;
        }
    }

    public WebElement toWebElement() {
        return findElement();
    }

    public By getLocator() {
        return uniquelocator;
    }
}
