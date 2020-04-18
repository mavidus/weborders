package com.weborders.tests.functional_tests;


import com.weborders.pages.ViewAllOrderPage;
import com.weborders.utilities.ApplicationConstants;
import com.weborders.utilities.Config;
import com.weborders.utilities.Driver;
import com.weborders.utilities.TestBase;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import static org.testng.Assert.*;


public class PositiveTest extends TestBase {

   //LoginPage page=new LoginPage();

    @Test(groups = "regression")
    public void ValidCredentials(){
        extentLogger=report.createTest("Positive Test");

        extentLogger.info("Verifying login page title");
        System.out.println(driver.getTitle());
        assertEquals(driver.getTitle(), ApplicationConstants.LOGIN_PAGE_TITLE);

        extentLogger.info(("Login to application"));
        pages.login().login(Config.getProperty("userName"), Config.getProperty("password"));

        extentLogger.info("Verifying url");
        assertEquals(driver.getTitle(), ApplicationConstants.APPLICATION_TITLE);

        //  assertEquals(driver.getCurrentUrl(),);


      //  fail();
        extentLogger.pass("completed");
    }

    @Test(priority = 1, groups = {"regression","smoke"})

    public void ViewAllOrdersPage(){
        extentLogger=report.createTest("Valid Credentials");

        extentLogger.info("Verifying login page title");
        pages.login().login(Config.getProperty("userName"), Config.getProperty("password"));
        pages.viewAllOrders().ViewAllOrders.click();
        pages.viewAllOrders().CheckAll.click();

        WebElement table=pages.viewAllOrders().firstTable;
        System.out.println(table.getText());
        //assertTrue(pages.viewAllOrders().CheckAll.isSelected() );

       for(WebElement head:pages.viewAllOrders().headers)
        System.out.println(head.getText());

        for(WebElement row:pages.viewAllOrders().rows)
            System.out.println(row.getText());


        extentLogger.pass("completed");

    }



}