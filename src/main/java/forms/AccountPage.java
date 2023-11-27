package forms;

import baseDir.BaseForm;
import baseDir.elements.Button;
import baseDir.elements.Label;
import baseDir.elements.TextBox;
import baseDir.utils.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BaseForm {
    public AccountPage(WebDriver driver) {
        super(new Label(By.xpath("//span[normalize-space()='Contact Information']")),"contact information",driver);
    }

    private final TextBox searchField = new TextBox(By.xpath("//input[@id='search']"));
    private final Button searchButton = new Button(By.xpath("//button[@title='Search']"));


    public void fillSearchField(String search){
        LogUtils.info("filling search field");
        searchField.setText(search);
    }
    public void clickSearchButton(){
        LogUtils.info("clicking search button");
        searchButton.click();
    }
}
