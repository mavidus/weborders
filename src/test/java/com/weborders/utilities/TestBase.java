package com.weborders.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public abstract class TestBase {

    protected WebDriver driver;
    protected Pages pages;
    protected static ExtentReports report;
    protected static ExtentHtmlReporter htmlReporter;
    protected static ExtentTest extentLogger;
    protected Actions actions;
    protected SoftAssert softAssert;
    protected WebDriverWait wait;




    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setUpMethod(@Optional String browser){

        driver=Driver.getDriver(browser);
        pages=new Pages();
        driver.get(Config.getProperty("url"));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(12,TimeUnit.SECONDS);
        wait=new WebDriverWait(driver,10);

        actions=new Actions(driver);
        softAssert=new SoftAssert();
    }


    @AfterMethod(alwaysRun = true)
    public void tearDownMethod(ITestResult result) throws  IOException {
        //if any test fails, it can detect it, take a screen at the point and attach to report

        if(result.getStatus()==ITestResult.FAILURE){
            String screenshotLocation=BrowserUtils.getScreenshot(result.getName());

            extentLogger.fail(result.getName());
            extentLogger.addScreenCaptureFromPath(screenshotLocation);
            extentLogger.fail(result.getThrowable());
        }
        else if(result.getStatus()==ITestResult.SKIP){
            extentLogger.skip("Test Case Skipped "+ result.getName());
        }
        Driver.closeDriver();
    }


    @BeforeTest(alwaysRun = true)
    public void setUpTest(){

        report=new ExtentReports();

        String filePath=System.getProperty("user.dir") + "/test-output/report.html";
        htmlReporter=new ExtentHtmlReporter(filePath);    //initialize the htmlpReporter with the path to the report

        report.attachReporter(htmlReporter);             //we attached the htmlReport to our report


        report.setSystemInfo("Environment", "Staging");
        report.setSystemInfo("Browser",Config.getProperty("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
        report.setSystemInfo("QA Engineer", "Emel Danisman");

        htmlReporter.config().setDocumentTitle("Web Order Reports");
        htmlReporter.config().setReportName("Web Orders Automated Test Reports");
        //htmlReporter.config().setTheme(Theme.DARK);
    }



   @AfterTest()
    public void tearDownTest()  {
        report.flush();

    }



}
