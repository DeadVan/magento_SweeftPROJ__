package forms;

import baseDir.BaseForm;
import baseDir.elements.BaseElement;
import baseDir.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessPage extends BaseForm {
    public SuccessPage(WebDriver driver) {
        super(new Label(By.xpath("//span[@class='base' and text()='Thank you for your purchase!']")),"Thank you for your purchase text",driver);
    }
}
