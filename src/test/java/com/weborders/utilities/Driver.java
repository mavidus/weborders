package com.weborders.utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.util.concurrent.TimeUnit;


public class Driver {

    private static WebDriver driver;// this is the instance will shared with everybody

    private Driver(){}

    public static WebDriver getDriver(String browser){
        if(driver==null){
            //first we check if the value from xml file is null or not
            //if the value from xml file is not null we use
            //the value from xml file is null, we get the browser from properties file

            browser = browser==null ? Config.getProperty("browser"):browser;

            switch(browser) {//crossBrowsewr Testing
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver=new InternetExplorerDriver();
                    break;
            }
        }

        //we can use these items here  or testbase
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        //driver.manage().timeouts().pageLoadTimeout(12,TimeUnit.SECONDS);

        return driver;
    }

    public static WebDriver getDriver(){
        return getDriver(null);
    }


    //we need to quit to driver and also we need to make driver null
    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;//webDriver Exception
        }
    }

}
