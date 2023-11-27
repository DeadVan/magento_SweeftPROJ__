package baseDir.utils;
import baseDir.singeltonPattern.WebDriverSingleton;
import baseDir.elements.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static baseDir.SettingsReader.getConfigDataInt;

public class WaitUtils {
    static WebDriverWait wait;
    public static void waitForElementToBeClickable(By element) {
        wait = new WebDriverWait(WebDriverSingleton.getCurrentDriver(), Duration.ofSeconds(getConfigDataInt("waitTime")));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementToBeVisible(By element) {
        wait = new WebDriverWait(WebDriverSingleton.getCurrentDriver(), Duration.ofSeconds(getConfigDataInt("waitTime")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void waitForTextToBePresentInElement(WebElement element, String expectedString) {
        wait = new WebDriverWait(WebDriverSingleton.getCurrentDriver(), Duration.ofSeconds(getConfigDataInt("waitTime")));
        wait.until(ExpectedConditions.textToBePresentInElement(element,expectedString));
    }
    public static void waitForInvisibilityOfElementLocated(BaseElement element) {
        wait = new WebDriverWait(WebDriverSingleton.getCurrentDriver(), Duration.ofSeconds(getConfigDataInt("waitTime")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element.getLocator()));
    }


    public static void waitForPresenceOfElement(By element) {
        wait = new WebDriverWait(WebDriverSingleton.getCurrentDriver(), Duration.ofSeconds(getConfigDataInt("waitTime")));
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }
}

