package baseDir;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

import static baseDir.SettingsReader.*;
import static baseDir.singeltonPattern.WebDriverSingleton.getDriverifNull;

public class BrowserFactory {
    public static WebDriver createDriver() {
        WebDriver driver = null;
        switch (getConfigData("browser")) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
            default:
                getDriverifNull();

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(getConfigDataInt("waitTime"), TimeUnit.SECONDS);
        return driver;
    }
}
