package com.weborders.tests.smoke_test;

import com.weborders.pages.OrderPage;
import com.weborders.pages.ViewAllProductsPage;
import com.weborders.utilities.ApplicationConstants;
import com.weborders.utilities.Config;
import com.weborders.utilities.TestBase;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class PageHeadersTest extends TestBase {

    @Test
    public void pageHeadersTest(){


        //create a new test case  in the report and give name:page headers test
        extentLogger=report.createTest("Page Headers Test");
        //use logger to log the steps


       // assertEquals(pages.menu().header.getText(),ApplicationConstants.APPLICATION_TITLE);

       // extentLogger.info("Logging to the application");// to system.out.println()

        pages.login().login(Config.getProperty("userName"),Config.getProperty("password"));

        extentLogger.info("Verifying all orders page");
        System.out.println(driver.getTitle());
        assertEquals(driver.getTitle(), ApplicationConstants.APPLICATION_TITLE);

        pages.viewAllOrders().viewAllOrdersLink.click();

        extentLogger.info("Verifying LIST_OF_ALL_ORDERS Header");
        assertEquals(pages.viewAllOrders().header.getText(),ApplicationConstants.LIST_OF_ALL_ORDERS);

        pages.viewAllOrders().viewAllProductsLink.click();

        extentLogger.info("Verifying LIST_OF_ALL_PRODUCTS Header");
        assertEquals(pages.viewAllProducts().header.getText(),ApplicationConstants.LIST_OF_ALL_PRODUCTS);

        pages.order().orderLink.click();

        extentLogger.info("Verifying ORDER Header");
        assertEquals(pages.order().header.getText(),ApplicationConstants.ORDER);

        assertEquals(pages.order().welcomeMessage.getText(),"Welcome, Tester! | Logout");

        pages.order().logout.click();

        extentLogger.pass("Page Headers test");
    }
}
//singeleton is about object.in this page we are looking at values




