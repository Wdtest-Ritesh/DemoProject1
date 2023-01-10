package testcases;

import BaseMethod.Base;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class Elements extends Base
{
    @Test(priority =  1)
    public static void textbox()
    {
        click("elementtile_XPATH");
        click("Textboxbtm_XPATH");
        write("fullNameBox_XPATH","fullName");
        write("Email_XPATH","Email");
        write("CurrentAddress_XPATH","CurrentAddress");
        write("PermanentAddress_XPATH","PermanentAddress");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        click("Submitbtm_XPATH");

    }
    @Test(priority = 2)
    public static void checkbox()
    {
        click("CheckBoxBtm_XPATH");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        click("SquareCheckBox_XPATH");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        click("ArrowBtm_XPATH");

    }
}
