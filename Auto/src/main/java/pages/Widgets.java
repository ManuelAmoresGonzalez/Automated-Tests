package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Widgets extends BasePage{
    @FindBy(xpath = "//div[contains(text(),'Widgets')]")
    private WebElement button_Widgets;

    @FindBy(id = "item-2")
    private WebElement button_dataPicker;
    public Widgets(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public boolean uploadFile(){
        scrollPage();
        button_Widgets.click();
        button_dataPicker.click();
        return true;
    }


    public void scrollPage(){
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }
}
