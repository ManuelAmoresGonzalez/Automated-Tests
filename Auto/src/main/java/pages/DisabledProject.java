package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DisabledProject extends Login{
    @FindBy(xpath = "//button[contains(@class,'create-btn')]")
    private WebElement button;

    @FindBy(xpath = "//li[text()='user.test@test.net']")
    private WebElement userName;

    public DisabledProject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public boolean verifyObject(){
        if(driver.findElements(By.xpath("//button[text()='Create Project']")).size() != 0){
            return false;
        }
        return true;
    }


    public String getDisabledProject(){
        return getText(userName);
    }

}
