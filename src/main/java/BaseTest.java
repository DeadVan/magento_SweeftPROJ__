import baseDir.singeltonPattern.WebDriverSingleton;
import baseDir.utils.LogUtils;
import forms.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static baseDir.SettingsReader.getConfigData;

public class BaseTest {

    static MainPage mainPage;
    static RegistrationPage registrationPage;
    static AccountPage accountPage;
    static CatalogSearchPage catalogSearchPage;
    static ProductPage productPage;
    static CheckoutPage checkoutPage;
    static LoginPage loginPage;
    static paymentPage paymentPage;
    static SuccessPage successPage;


    @BeforeMethod
    public void setup() {
        WebDriver driver = WebDriverSingleton.getInstance().getDriver();
        driver.get(getConfigData("url"));
        mainPage = new MainPage(driver);
        registrationPage = new RegistrationPage(driver);
        accountPage = new AccountPage(driver);
        catalogSearchPage = new CatalogSearchPage(driver);
        productPage = new ProductPage(driver);
        checkoutPage = new CheckoutPage(driver);
        loginPage = new LoginPage(driver);
        paymentPage = new paymentPage(driver);
        successPage = new SuccessPage(driver);
        LogUtils.startTestCase(mainPage.getFormLabel());
    }

    @AfterMethod
    public void closeDriver() {
        WebDriverSingleton.getInstance().closeDriver();
        LogUtils.endTestCase();
    }
}
