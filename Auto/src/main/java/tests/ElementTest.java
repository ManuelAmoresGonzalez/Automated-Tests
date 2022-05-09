package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class ElementTest {
    WebDriver driver;
    BasePage basePage;

    @BeforeMethod
    private void setUp(){
        WebDriverManager.chromedriver().browserVersion("100.0.4896.60").setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        options.addArguments("--allowed-ips");
        driver = new ChromeDriver(options);
        basePage = new BasePage(driver);
        driver.get("https://demoqa.com/elements");
    }

    @Test
    private void firstTest(){
        Elements openPage= new Elements(driver);
        Assert.assertTrue(openPage.openTextBox("Manuel Amores","manuelamores25@gmail.com", "Puente Casa Florencia", "uente Casa Florencia", true));
    }

    @Test
    private void secondTest(){
        Elements openPage= new Elements(driver);
        Assert.assertTrue(openPage.openTextBox("","manuelamores25@gmail.com", "", "", true));
    }

    @Test
    private void thirdTest(){
        Elements openPage= new Elements(driver);
        Assert.assertFalse(openPage.openTextBox("","manuelamores25gmail.com", "", "", false));
    }

    @Test
    private void fourthTest(){
        Elements openPage= new Elements(driver);
        Assert.assertTrue(openPage.openCheckBox());
    }

    @Test
    private void fifthTest(){
        Elements openPage= new Elements(driver);
        Assert.assertTrue(openPage.openRadioButtonYes());
    }

    @Test
    private void sixthTest(){
        Elements openPage= new Elements(driver);
        Assert.assertTrue(openPage.openRadioButtonNo());
    }

    @Test
    private void seventhTest(){
        Elements openPage= new Elements(driver);
        Assert.assertTrue(openPage.openWebTables());
    }

    @Test
    private void eighthTest(){
        Elements openPage= new Elements(driver);
        Assert.assertTrue(openPage.uploadFile());
    }
/*@Test
    private void tenthTest(){
        Widgets widget = new Widgets(driver);
        Assert.assertTrue(widget.uploadFile());
    }*/
   /* @Test
    private void ninethTest(){
        Widgets widget = new Widgets(driver);
        Assert.assertTrue(widget.uploadFile());
    }*/
//DragandDrop


/*  @Test
    private void LoginError(){
        LoginError component = new LoginError(driver);
        String user= "user.admin@test.net";
        component.login(user,"tst");
        Assert.assertEquals(component.getMessageError(),"Invalid username or password");
        Assert.assertTrue(component.getPassword().equals(""));
        Assert.assertTrue(component.getEmail().equals(user));
    }

    @Test
    private void ViewBotton(){
        ViewBotton component = new ViewBotton(driver);
        Assert.assertTrue(component.viewPassword("test"));
    }

   @Test
    private void DisabledProject(){
        DisabledProject component= new DisabledProject(driver);
        component.login("user.test@test.net","test");
        Assert.assertEquals(component.getDisabledProject(),"user.test@test.net");
        Assert.assertTrue(component.verifyObject());
   }

    @Test
    private void EnabledProject(){
        Login();
        EnabledProject component= new EnabledProject(driver);
        component.getButtonProject();
    }*/

/*
    @AfterClass
    private void teardown(){
        driver.close();
    }*/
}
