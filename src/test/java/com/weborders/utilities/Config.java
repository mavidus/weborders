package com.weborders.utilities;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Config {
    //load the file
    private static Properties pro;

    static{
        String path="configurations.properties";
        try{
            FileInputStream file =new FileInputStream(path);
            pro= new Properties();
            pro.load(file);
            file.close();
        }
        catch(Exception e){
            System.out.println("Path: " + path +" -not found.");
        }
    }

    //here we will read the file

    public static String getProperty(String key){
        return pro.getProperty(key);

    }
}
