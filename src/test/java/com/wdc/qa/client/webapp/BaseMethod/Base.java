package BaseMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import testcases.*;

import javax.lang.model.element.Element;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver driver;
    public static Properties details = new Properties();
    public static Properties locators = new Properties();
    public static Properties info = new Properties();
    @BeforeTest
    public static void Setup() throws IOException {
        FileInputStream fis = new FileInputStream("/Users/riteshsharma/DemoProject/src/test/resources/config.properties");
        details.load(fis);

        FileInputStream location = new FileInputStream("/Users/riteshsharma/DemoProject/src/test/resources/locators.properties");
        locators.load(location);

        FileInputStream  inf = new FileInputStream("/Users/riteshsharma/DemoProject/src/test/resources/Info.properties");
        info.load(inf);

        if(details.getProperty("browsers").equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(details.getProperty("url"));
            driver.manage().window().maximize();

        }
        else if (details.getProperty("browsers").equals("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get(details.getProperty("url"));
            driver.manage().window().maximize();
        }
        else if (details.getProperty("browsers").equals("safari"))
        {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
            driver.get(details.getProperty("url"));
            driver.manage().window().maximize();
        }
    }
    @Test
    public static void click(String location)
    {
        if(location.endsWith("_CSS"))
        {
            driver.findElement(By.cssSelector(locators.getProperty(location))).click();
        }
        else if (location.endsWith("_XPATH"))
        {
            driver.findElement(By.xpath(locators.getProperty(location))).click();
        }
        else if (location.endsWith("_ID"))
        {
            driver.findElement(By.id(locators.getProperty(location))).click();
        }


    }
    @Test
    public static void type (String location1,String Value)
    {
        if(location1.endsWith("_CSS"))
        {
            driver.findElement(By.cssSelector(locators.getProperty(location1))).sendKeys(details.getProperty(Value));
        }
        else if(location1.endsWith("_XPATH"))
        {
            driver.findElement(By.xpath(locators.getProperty(location1))).sendKeys(details.getProperty(Value));
        }
    }
    @Test
    public static void write (String location1,String Value)
    {
        if(location1.endsWith("_CSS"))
        {
            driver.findElement(By.cssSelector(locators.getProperty(location1))).sendKeys(info.getProperty(Value));
        }
        else if(location1.endsWith("_XPATH"))
        {
            driver.findElement(By.xpath(locators.getProperty(location1))).sendKeys(info.getProperty(Value));
        }
    }
    @AfterTest
     public static void quit()
     {
         driver.quit();
     }
}



