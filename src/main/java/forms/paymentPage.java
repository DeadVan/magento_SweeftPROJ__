package forms;

import baseDir.BaseForm;
import baseDir.elements.Button;
import baseDir.elements.Label;
import baseDir.utils.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class paymentPage extends BaseForm {
    public paymentPage(WebDriver driver) {
        super(new Label(By.xpath("//div[normalize-space()='Payment Method']")),"payment Method Text",driver);
    }

    private final Button placeOrderButton = new Button(By.xpath("//div[@class='primary']//button[@class='action primary checkout' and @type='submit' and @title='Place Order']"));

    public void clickPlaceOrderButton(){
        LogUtils.info("clicking place order button via js");
        placeOrderButton.clickWithJS();

    }
}
