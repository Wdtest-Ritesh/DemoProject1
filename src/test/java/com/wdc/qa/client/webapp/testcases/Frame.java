package testcases;

import BaseMethod.Base;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.awt.event.ActionListener;
public class Frame extends Base
{
    @Test(priority =  1)
    public static void frame()
    {
        click("F_AlertFameBtm_XPATH");
        click("FrameBtm_XPATH");
        driver.switchTo().frame(driver.findElement(By.id("frame1")));
        String line = driver.findElement(By.xpath("//*[@id=\"sampleHeading\"]")).getText();
        System.out.println("Sentence Mentioned inside the frame box:"+line);
    }
}
