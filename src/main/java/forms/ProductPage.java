package forms;

import baseDir.BaseForm;
import baseDir.elements.Button;
import baseDir.elements.Label;
import baseDir.elements.TextBox;
import baseDir.singeltonPattern.WebDriverSingleton;
import baseDir.utils.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

import static baseDir.utils.RandomUtils.generateRandomNumber;
import static baseDir.utils.WaitUtils.*;

public class ProductPage extends BaseForm {
    public ProductPage(WebDriver driver) {
        super(new Label(By.xpath("//span[@class='base' and @data-ui-id='page-title-wrapper' and @itemprop='name']")),"Product Name",driver);
    }

    private final Label productName = new Label(By.xpath("//span[@class='base' and @data-ui-id='page-title-wrapper' and @itemprop='name']"));
    private final TextBox qtyField = new TextBox(By.xpath("//input[@id='qty']"));
    private final Button addToCartButton = new Button(By.xpath("//span[normalize-space()='Add to Cart']"));
    private final Label succesLabel = new Label(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
    private final Button cartButton = new Button(By.xpath("//a[@class='action showcart']"));
    private final Button checkOutButton = new Button(By.xpath("//*[@id='top-cart-btn-checkout']"));

    public String getProductName(){
        LogUtils.info("getting Product name");
        return productName.getText();
    }

    public void chooseSize(){
        try {
            LogUtils.info("choosing size of product");
            WebElement sizeContainer = WebDriverSingleton.getCurrentDriver().findElement(By.xpath("//div[@aria-labelledby='option-label-size-143']"));
            List<WebElement> sizes = sizeContainer.findElements(By.xpath("//div[@role='option' and starts-with(@id, 'option-label-size-143-item-')]"));
            sizes.get(generateRandomNumber(0, sizes.size())-1).click();
        }catch (NoSuchElementException e){
            LogUtils.warn("There is no size option to choose ");
        }
    }
    public void chooseColor(){
        try {
            LogUtils.info("choosing color of the product");
            WebElement colorContainer = WebDriverSingleton.getCurrentDriver().findElement(By.xpath("//div[@aria-labelledby='option-label-color-93']"));
            List<WebElement> colors = colorContainer.findElements(By.xpath("//*[starts-with(@id,'option-label-color-93-item-')]"));
            colors.get(generateRandomNumber(0,colors.size()-1)).click();
        }catch (NoSuchElementException e){
            LogUtils.warn("There is no color option to choose ");
        }
    }
    public void fillQtyField(){
        LogUtils.info("filling quantity of product");
        qtyField.toWebElement().clear();
        qtyField.toWebElement().sendKeys(String.valueOf(generateRandomNumber(1, 5)));
    }
    public void clickAddToCartButton(){
        LogUtils.info("clicking add to cart button");
        addToCartButton.click();
    }
    public String getSuccesLabelText(){
        LogUtils.info("waiting for message to appear about product adding");
        waitForPresenceOfElement(succesLabel.getLocator());
        LogUtils.warn("getting a message of the product which was added " + succesLabel.getText());
        return succesLabel.getText();
    }
    public void clickCartButton(){
        LogUtils.info("clicking cart button");
        waitForElementToBeVisible(succesLabel.getLocator());
        cartButton.click();
        //ყველა wait ვცადე მხოლოდ ამან მიშველა ;დ
        try {
            LogUtils.info("using thread sleep for check out button");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            LogUtils.error("thread was interrupted! " + e);
        }
    }
    public void clickCheckOutButton(){
        LogUtils.info("clicking check out button");
        checkOutButton.click();

    }
}
