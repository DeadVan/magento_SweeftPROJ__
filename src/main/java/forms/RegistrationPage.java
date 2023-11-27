package forms;

import baseDir.BaseForm;
import baseDir.elements.Button;
import baseDir.elements.Label;
import baseDir.elements.TextBox;
import baseDir.utils.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BaseForm {
    public RegistrationPage(WebDriver driver) {
        super(new Label(By.className("base")), "Create New Customer Account", driver);
    }

    private final TextBox firstName = new TextBox(By.id("firstname"));
    private final TextBox lastName = new TextBox(By.id("lastname"));
    private final TextBox email = new TextBox(By.id("email_address"));
    private final TextBox password = new TextBox(By.id("password"));
    private final TextBox confirmPassword = new TextBox(By.id("password-confirmation"));
    private final Button createAnAccountBtn = new Button(By.xpath("//button[@type='submit' and @title='Create an Account']"));


    public void fillFirstName(String firstNames) {
        LogUtils.info("filling first name field");
        firstName.setText(firstNames);
    }

    public void fillLastName(String lastNames) {
        LogUtils.info("filling last name field");
        lastName.setText(lastNames);
    }

    public void fillEmail(String emails) {
        LogUtils.info("filling email field");
        email.setText(emails);
    }

    public void fillPasswordAndConfiramtionOfPassword(String passwords) {
        LogUtils.info("filling password field");
        password.setText(passwords);
        confirmPassword.setText(passwords);
    }

    public void clickCreateAnAccountBtn() {
        LogUtils.info("clicking at create an accouint button");
        createAnAccountBtn.click();
    }

}
