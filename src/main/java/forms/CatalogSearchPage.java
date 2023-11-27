package forms;

import baseDir.BaseForm;
import baseDir.elements.Button;
import baseDir.elements.Label;
import baseDir.singeltonPattern.WebDriverSingleton;
import baseDir.utils.LogUtils;
import dto.ProductDto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.List;

import static baseDir.utils.RandomUtils.generateRandomNumber;

public class CatalogSearchPage extends BaseForm {
    public CatalogSearchPage(WebDriver driver) {
        super(new Label(By.xpath("//span[@class='base']")),"Catalog search result text", driver);
    }

    private static int randNumb = 0;
    static String productInfo;
    public static ProductDto productDto;

    private final Label label = new Label(By.xpath("//span[@class='base']"));
    private final Button dropDownSort = new Button(By.className("sorter-options"));


    public String getSearchResultText(){
        LogUtils.info("get search result text");
        return label.getText();
    }

    public void clickDropDownSort(){
        LogUtils.info("clicking dropdown to see filters");
        dropDownSort.click();
    }
    public void chooseSortOption(){
        LogUtils.info("choosing sorting option");
        WebElement filterContainer = WebDriverSingleton.getCurrentDriver().findElement(By.id("sorter"));
        List<WebElement> options = filterContainer.findElements(By.tagName("option"));
        options.get(generateRandomNumber(0, options.size()-1)).click();
    }
    public void clickToRandProduct(){
        LogUtils.info("clicking random product");
        WebElement productContainer = WebDriverSingleton.getCurrentDriver().findElement(By.xpath("//ol[@class='products list items product-items']"));
        List<WebElement> products = productContainer.findElements(By.xpath("//li[@class='item product product-item']"));
        randNumb = generateRandomNumber(0,products.size()-1);
        WebElement choosedProd = products.get(randNumb);
        productInfo = choosedProd.getText();
        choosedProd.click();
        String[] lines = productInfo.split("\n");
        if (lines.length > 0) {
            productDto = new ProductDto((lines[0].trim()));
        } else {
            productDto = new ProductDto("");
        }
    }
}
