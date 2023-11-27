package baseDir;

import baseDir.elements.BaseElement;
import baseDir.utils.LogUtils;
import baseDir.utils.WaitUtils;
import org.openqa.selenium.*;

public abstract class BaseForm {
    protected WebDriver driver;
    BaseElement uniqueFormLocator;
    String formName;
    public BaseForm(BaseElement locator, String name,WebDriver driver){
        uniqueFormLocator = locator;
        formName = name;
        this.driver = driver;

    }
    public String getFormLabel() {
        return driver.getTitle() + ".  {{}} unique Locator is -  " + formName;
    }

    public boolean isFormOpen() {
        try {
            WaitUtils.waitForPresenceOfElement(uniqueFormLocator.getLocator());
            LogUtils.info("checking if form is open " + uniqueFormLocator.getText());
            return uniqueFormLocator.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            LogUtils.error("form was not open");
            return false;
       }
    }
}