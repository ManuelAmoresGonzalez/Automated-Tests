package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Interactions extends BasePage{

    @FindBy(xpath = "//nav[contains(@class,'nav-tabs')]")
    private WebElement buttonAccept;

    @FindBy(id = "acceptable")
    private WebElement dragAccept;

    @FindBy(id = "notAcceptable")
    private WebElement dragNotAcceptable;



    @FindBy(id = "acceptDropContainer")
    private WebElement dropableBox;


    @FindBy(className = "ui-state-highlight")
    private WebElement enabledDropableBox;

    public Interactions(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public boolean dragDrop(boolean decision){
        buttonAccept.findElement(By.xpath("//a[contains(@id,'droppableExample-tab-accept')]")).click();
        if(decision){
            moveComponent(dragAccept,296, 44);
        }else{
            moveComponent(dragNotAcceptable,311, -9);
        }
        if(driver.findElements(By.className("ui-state-highlight")).size() > 0){
            return true;
        }
        return false;

    }
}
