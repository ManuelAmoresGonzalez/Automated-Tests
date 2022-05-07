package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.Elements;
import pages.Interactions;

public class InteractionsTest {

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
        driver.get("https://demoqa.com/droppable");
    }

    @Test
    private void test11(){
        Interactions interaction= new Interactions(driver);
        Assert.assertTrue(interaction.dragDrop(true));
    }

    @Test
    private void test12(){
        Interactions interaction= new Interactions(driver);
        Assert.assertFalse(interaction.dragDrop(false));
    }
}
