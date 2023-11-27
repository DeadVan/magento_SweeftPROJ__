package baseDir.elements;

import baseDir.singeltonPattern.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.lang.annotation.ElementType;
import java.util.List;
import java.util.stream.Collectors;

public class Button extends BaseElement {
    public Button(By locator) {
        super(locator);
    }

    public void clickWithJS(){
        JavascriptExecutor executor = (JavascriptExecutor) WebDriverSingleton.getCurrentDriver();
        executor.executeScript("arguments[0].click();", findElement());
    }
}
