package com.weborders.tests.functional_tests;



import com.weborders.pages.LoginPage;
import com.weborders.utilities.Config;
import com.weborders.utilities.Driver;
import com.weborders.utilities.Pages;
import com.weborders.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTest extends TestBase {
    //LoginPage page=new LoginPage();==pages.login();

    @Test
    public void wrongEmailTest(){

        extentLogger=report.createTest("Negative Test");
        extentLogger.info("Logging to the application");

        pages.login().username.sendKeys("admin");
        pages.login().password.sendKeys(Config.getProperty("passwrd"));
        pages.login().lgn_Btn.click();

        extentLogger.info("Verifying the status of the page");
        String error="Invalid Login or Password.";
        String actual= pages.login().status.getText();
        System.out.println(actual);

        extentLogger.info("Verifyying login page title");
        Assert.assertEquals(actual, error);

        extentLogger.pass("Page Headers test");
    }

    @Test(groups = "regressi")
    public void wrongPassword(){
        extentLogger=report.createTest("Wrong Password Test");
        extentLogger.info("Entering login information");

      //  Driver.getDriver().get(Config.getProperty("url"));


       // page.username.sendKeys(Config.getProperty("userName"));
       // page.password.sendKeys("Admin");
       // page.lgn_Btn.click();
        pages.login().login(Config.getProperty("userName"),Config.getProperty("invalid"));

        String expectedError="Invalid Login or Password.";
        String actualError= pages.login().status.getText();
        System.out.println(actualError);
        Assert.assertEquals(actualError, expectedError);
    }



    @Test(priority = 2)
    public void blankUserName(){
       // page.open();
        pages.login().login(Config.getProperty("userName"),Config.getProperty("password"));



    }


}
