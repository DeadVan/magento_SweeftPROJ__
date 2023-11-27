package forms;

import baseDir.BaseForm;
import baseDir.elements.Button;
import baseDir.elements.Checkbox;
import baseDir.elements.Label;
import baseDir.elements.TextBox;
import baseDir.singeltonPattern.WebDriverSingleton;
import baseDir.utils.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static baseDir.utils.RandomUtils.generateRandomNumber;
import static baseDir.utils.WaitUtils.waitForElementToBeClickable;

public class CheckoutPage extends BaseForm {
    public CheckoutPage(WebDriver driver) {
        super(new Label(By.xpath("//span[normalize-space()='Shipping']")),"Shipping text", driver);
    }
    private final TextBox streetAddressField = new TextBox(By.xpath("//fieldset[contains(@class, 'street')]//input"));
    private final TextBox cityField = new TextBox(By.xpath("//div[@name='shippingAddress.city']//input"));
    private final TextBox postalCodeField = new TextBox(By.xpath("//div[@name='shippingAddress.postcode']//input"));
    private final TextBox phoneNumber = new TextBox(By.xpath("//div[@name='shippingAddress.telephone']//input"));
    private final Button nextButton = new Button(By.xpath("//div[@class='primary']//button[@data-role='opc-continue']"));

    public void fillStreetAddressField(String string){
        LogUtils.info("filling address field");
        streetAddressField.setText(string);
    }
    public void fillCityField(String string){
        LogUtils.info("filling city field");
        cityField.setText(string);
    }
    public void chooseState(){
        LogUtils.info("choosing state");
        WebElement stateContainer = WebDriverSingleton.getCurrentDriver().findElement(By.xpath("//div[@name='shippingAddress.region_id']"));
        List<WebElement> statesList = stateContainer.findElements(By.xpath("//div[@name='shippingAddress.region_id']//option"));
        statesList.get(generateRandomNumber(0,statesList.size()-1)).click();
    }
    public void chooseCountry(){
        LogUtils.info("choosing country");
        WebElement countryContainer = WebDriverSingleton.getCurrentDriver().findElement(By.xpath("//div[@name='shippingAddress.country_id']"));
        List<WebElement> countryList = countryContainer.findElements(By.xpath("//div[@name='shippingAddress.country_id']//option"));
        countryList.get(generateRandomNumber(0,countryList.size())).click();
    }
    public void fillPostalCodeField(String string){
        LogUtils.info("filling postal field");
        postalCodeField.setText(string);
    }
    public void fillPhoneNumber(String string){
        LogUtils.info("filling phone number field");
        phoneNumber.setText(string);
    }
    public void checkCheckBox(){
        LogUtils.info("checking checkbox");
        try {
            LogUtils.info("using thread sleep for checkboxes");
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            LogUtils.error("thread was interrupted! " + e);
        }
        WebElement checkboxContainer = WebDriverSingleton.getCurrentDriver().findElement(By.xpath("//*[@id='checkout-shipping-method-load']"));
        List<WebElement> checkboxes = checkboxContainer.findElements(By.xpath("//*[@id='checkout-shipping-method-load']//input"));
        WebElement choosedCheckbox = checkboxes.get(generateRandomNumber(0,checkboxes.size()-1));
        if (!(choosedCheckbox).isSelected()){
            choosedCheckbox.click();
        }
    }
    public void clickNextButton(){
        nextButton.click();
    }
}
