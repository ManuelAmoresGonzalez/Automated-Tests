package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.Widgets;

public class WidgetsTest {

    WebDriver driver;    BasePage basePage;

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
        driver.get("https://demoqa.com/select-menu");
    }
    @Test
    private void test10(){
        Widgets element= new Widgets(driver);
        element.selectMenuMethod();
        //Assert.assertTrue(element.dragDrop(true));
    }
}
