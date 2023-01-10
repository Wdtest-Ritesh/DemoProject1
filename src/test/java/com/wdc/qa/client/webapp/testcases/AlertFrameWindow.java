package testcases;

import BaseMethod.Base;
import net.bytebuddy.build.Plugin;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.sql.Time;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AlertFrameWindow extends Base
{
    @Test(priority =  1)
    public static void alert()
    {
        {

            click("elementBtm_XPATH");
            WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Alerts')]//ancestor::*[contains(@class,'header-wrapper')]"))).click();

            //click("AlertFameBtm_XPATH");
            click("AlertBtm_XPATH");
            click("ButtontoSeeAlert_XPATH");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();


            click("TimerAlertButton_XPATH");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert1 = driver.switchTo().alert();
            System.out.println(alert1.getText());
            alert1.accept();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            click("AlertFameBtm_XPATH");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }
    }
}
