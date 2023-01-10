package testcases;

import BaseMethod.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Widgets extends Base
{


    @Test(priority = 1)
    public static void DatePicker()
    {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Widgets')]//ancestor::*[contains(@class,'header-wrapper')]"))).click();

        //click("WidgetBtm_XPATH");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)", "");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        click("DatePickerBtm_XPATH");

    }

    @Test(priority = 2)
    public static void SelectDate() {
        click("SelectDateBox_XPATH");
        int n = 0;
        while (n == 0) {
            //Month selection
            click("MonthDropdownBtm_XPATH");
            List<WebElement> monthlist = driver.findElements(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select/option"));
            for (WebElement ele : monthlist) {
                String currentmonthlist = ele.getText();
                if (currentmonthlist.equalsIgnoreCase(info.getProperty("Month"))) {
                    ele.click();
                    break;
                }


            }
            //Years Selection
            click("YearSropDownBtm_XPATH");
            List<WebElement> yearlist = driver.findElements(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select/option"));
            for (WebElement ele1 : yearlist) {
                String currenryearlist = ele1.getText();
                if (currenryearlist.equalsIgnoreCase(info.getProperty("Year"))) {
                    ele1.click();
                    break;
                }
            }

            //Date Selection
            List<WebElement> datelist = driver.findElements(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div/div"));
            for (WebElement ele2 : datelist) {
                String currentdatelist = ele2.getText();
                if (currentdatelist.equalsIgnoreCase(info.getProperty("Date"))) {
                    ele2.click();
                    break;
                }
            }
            n = 1;
        }

    }

}


