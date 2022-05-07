package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnabledProject extends Login{

    @FindBy(xpath = "//button[text()='Create Project']")
    private WebElement button;

    public EnabledProject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String getButtonProject(){
        return getText(button);
    }
}
