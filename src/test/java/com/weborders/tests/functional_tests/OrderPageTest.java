package com.weborders.tests.functional_tests;

import com.weborders.utilities.ApplicationConstants;
import com.weborders.utilities.Config;
import com.weborders.utilities.TestBase;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class OrderPageTest extends TestBase {


    @Test
    public void orderInfo(){

        extentLogger=report.createTest("Placing Order Page");

        pages.login().login(Config.getProperty("userName"),
                Config.getProperty("password"));

        pages.order().ordertab.click();

        extentLogger.info("Verifying Page Headers");

        System.out.println(pages.order().title.getText());
        assertEquals(pages.order().title.getText(), ApplicationConstants.ORDER);

        pages.order().product.click();
        Select sel=new Select(pages.order().product);
        sel.selectByVisibleText("ScreenSaver");
        pages.order().product.click();

        pages.order().quantity.sendKeys("12");
        pages.order().discount.sendKeys("20");
        pages.order().calculate.click();
        String str=pages.order().errMsg.getText();
        System.out.println( str);
        assertEquals(pages.order().errMsg.getText(), str);

        pages.order().CustomerName.sendKeys("Emel");
        pages.order().Street.sendKeys("Dartmouth");
        pages.order().city.sendKeys("Aurora");
        pages.order().state.sendKeys("CO");
        pages.order().zip.sendKeys("80013");

        pages.order().card.click();
        pages.order().card.isEnabled();
        pages.order().cardNmbr.sendKeys("1224734849");
        pages.order().expire.sendKeys("09/12");
        pages.order().process.click();


        extentLogger.pass("completed");

    }
}
