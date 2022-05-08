package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Widgets extends BasePage{
    @FindBy(xpath = "//div[contains(text(),'Widgets')]")
    private WebElement button_Widgets;

    @FindBy(xpath = "//div[contains(@class,'select-menu-container')]")
    private WebElement boxSelectMenu;

    @FindBy(xpath = "//input[contains(@id,'react-select-2-input')]")
    private WebElement menuSelectValue;


    @FindBy(xpath = "//div[contains(@class,'css-1hwfws3')]")
    private WebElement selectValueMultiselect;

    @FindBy(id = "item-2")
    private WebElement button_dataPicker;
    public Widgets(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public boolean selectMenuMethod(){
        boxSelectMenu.findElement(By.xpath("//div[contains(@class,' css-1hwfws3')]")).click();
        driver.findElement(By.xpath("//div[contains(@id,'react-select-2-option-1-0')]")).click();
        boxSelectMenu.findElement(By.xpath("//div[contains(@class,' css-1hwfws3')]")).click();
        Select se = new Select(driver.findElement(By.xpath("//*[@id='oldSelectMenu']")));
        se.selectByValue("6");
        System.out.println(selectValueMultiselect);
        selectValueMultiselect.findElement(By.xpath("//div[contains(text(),'Select...')]")).click();
        driver.findElement(By.xpath("//div[contains(@id,'react-select-4-option-0')]")).click();
        driver.findElement(By.xpath("//div[contains(@id,'react-select-4-option-2')]")).click();
        selectValueMultiselect.findElement(By.xpath("//div[contains(text(),'Select...')]")).click();
        return true;
    }


    public void scrollPage(){
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }
}
