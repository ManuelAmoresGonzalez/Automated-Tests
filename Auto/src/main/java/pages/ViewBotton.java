package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewBotton extends Login{

    public ViewBotton(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root']")
    private WebElement eye;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement input;



    public boolean viewPassword(String password){
        typeOnElement(this.password,password);
        if(!input.getAttribute("type").equals("password")){
            return false;
        }
        System.out.println("Valido el cerrado, correcto");
        eye.click();
        if(!input.getAttribute("type").equals("text")){
            return false;
        }
        System.out.println("Valido el segundo, correcto");
        return true;
    }
}
