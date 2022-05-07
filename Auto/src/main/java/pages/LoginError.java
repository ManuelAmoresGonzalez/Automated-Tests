package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginError extends Login{



    @FindBy(xpath = "//span[text()='Invalid username or password']")
    private WebElement message;

    public LoginError(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }


    public String getMessageError(){
        return getText(message);
    }


}
