package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class OpenWeb extends BasePage{


    public OpenWeb(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }


}
