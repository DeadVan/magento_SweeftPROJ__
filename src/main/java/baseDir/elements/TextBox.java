package baseDir.elements;

import org.openqa.selenium.By;

public class TextBox extends BaseElement {
    public TextBox(By locator) {
        super(locator);
    }

    public void setText(String text) {
        findElement().clear();
        findElement().sendKeys(text);
    }
//    public void setInt(int integer){
//        findElement().clear();
//        findElement().sendKeys(integer);
//    }
}
