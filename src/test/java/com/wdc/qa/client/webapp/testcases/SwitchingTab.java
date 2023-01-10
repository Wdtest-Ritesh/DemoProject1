package testcases;

import BaseMethod.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SwitchingTab extends Base
{
    @Test(priority =  1)
    public static void newtab()
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //opening new tab
        ((JavascriptExecutor)driver).executeScript("window.open()");


        //Storing tab value in array list
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());


        //switcing control to new tab using the array list
        driver.switchTo().window(tabs.get(1));


        //Entering new URL
        driver.get("https://phptravels.net/");


        driver.close();


        //swithcing control back to tab 0
        driver.switchTo().window(tabs.get(0));
    }
}
