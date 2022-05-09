package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
    }

    public boolean typeOnElement(WebElement element, String text){
        if (waitForElementToBeEnabled(element)){
            element.sendKeys(text);
            System.out.println("Type on element");
            return true;
        }
        System.out.println("Type on element: Element is not enabled");
        return false;
    }

    public String getText(WebElement element){
        if(waitForElementToBeVisibled(element)){
            return element.getText();
        }
        return "";
    }

    public boolean waitForElementToBeEnabled(WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element)) != null;
    }

    public boolean waitForElementToBeVisibled(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element)) != null;
    }

    public void moveComponent(WebElement dragAccept, int x, int y){
        Actions action= new Actions(driver);
        action.dragAndDropBy(dragAccept,x,y).perform();
    }
}
