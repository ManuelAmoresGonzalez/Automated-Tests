package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends BasePage{
/*  @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login")
    private WebElement loginButton;

    @FindBy(xpath = "//li[text()='user.admin@test.net']")
    private WebElement userName;*/

    public Login(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

/*  public void login(String email,String password){
        typeOnElement(this.email,email);
        typeOnElement(this.password,password);
        loginButton.click();
    }

    public String getPassword(){
        return password.getAttribute("value");
    }

    public String getEmail(){
        return email.getAttribute("value");
    }

    public String getUserName(){
        return getText(userName);
    }*/



}
