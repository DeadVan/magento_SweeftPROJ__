package forms;

import baseDir.BaseForm;
import baseDir.elements.Button;
import baseDir.elements.Label;
import baseDir.singeltonPattern.WebDriverSingleton;
import baseDir.utils.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static baseDir.SettingsReader.getConfigDataInt;

public class MainPage extends BaseForm {

    public MainPage(WebDriver driver) {
        super(new Label(By.xpath("//a[contains(@class,'block-promo home-main')]")), "Luma logo", driver);
    }

    private final Button createAnAccount = new Button(By.xpath("//div[@class='panel header']//a[normalize-space()='Create an Account']"));
    private final Button signInButton = new Button(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]"));

    public void clickCreateAnAccount(){
        LogUtils.info("clicking create An Account button");
        createAnAccount.click();
    }
    public void clickSignInButton(){
        LogUtils.info("clicking to sign in button");
        signInButton.click();
    }
    public boolean checkIfAuthorizationWasSuccesfull(String firstName,String lastName){
        LogUtils.info("checking if we signed up and appeared our fist name and last name");
        WebElement loggedInNameLastNameText = WebDriverSingleton.getCurrentDriver().findElement(By.xpath("//li[@class='greet welcome']//span[@class='logged-in']"));
        Wait<WebDriver> wait = new WebDriverWait(WebDriverSingleton.getCurrentDriver(), Duration.ofSeconds(getConfigDataInt("waitTime")));
        wait.until(ExpectedConditions.textToBePresentInElement(loggedInNameLastNameText, "Welcome, "+firstName+" "+lastName+"!"));
        return loggedInNameLastNameText.isDisplayed();
    }
}
