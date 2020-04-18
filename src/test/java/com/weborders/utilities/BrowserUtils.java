package com.weborders.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BrowserUtils {
    public static String getScreenshot(String name) {

        /*
        Generate the string path to the screenshot taken
        within the method the screenshot is taken and is saved into FileUtils
        The string return will have a unique name destination of the screenshot itself
        @Param name Test name passes in as a String
        @Return unique String representation of the file's location/path to file
         */
        //name the screenshot with current data-time to avoid duplicates

        String time=new SimpleDateFormat("yyyymmddhhmmss").format(new Date());

        //Tkae Screenshot--> interface from selenium which takes screenshots
        //below two line create screenshot
        TakesScreenshot takesScreenshot=(TakesScreenshot) Driver.getDriver();
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);

        //full path to the screenshot location
        String target=System.getProperty("user.dir")+"/test-output/Screenshots" + name + time + ".png";
        File finalDestination=new File(target);
        //save the screenshot to the path given

        try{
            FileUtils.copyFile(source,finalDestination);
        }
        catch (IOException io){ }
        return target;
    }
}
