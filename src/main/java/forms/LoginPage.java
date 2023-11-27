package forms;

import baseDir.BaseForm;
import baseDir.elements.Button;
import baseDir.elements.Label;
import baseDir.elements.TextBox;
import baseDir.utils.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BaseForm {
    public LoginPage(WebDriver driver) {
        super(new Label(By.xpath("//span[@class='base' and text()='Customer Login']")),"Customer Login Text" , driver);
    }

    private final TextBox emailField = new TextBox(By.xpath("//*[@id='email']"));
    private final TextBox passwordField = new TextBox(By.xpath("//input[@title='Password']"));
    private final Button signInButton = new Button(By.xpath("//button[contains(@class, 'primary')]"));

    public void fillEmailField(String mail){
        LogUtils.info("filling email field");
        emailField.setText(mail);
    }
    public void fillPasswordField(String password){
        LogUtils.info("filling password field");
        passwordField.setText(password);
    }
    public void clickSignInButton(){
        LogUtils.info("clicking sign in button");
        signInButton.click();
    }
}
