package com.weborders.RestfullTest;

import com.weborders.utilities.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Name extends TestBase {

    @Test
            public void test() {
        extentLogger=report.createTest("RestFul Test");
        //RestAssured library , it contains methods and objects =used for creating and sending request
        //get method for making get request
        //i need to catch to response and put it into response class
        Response response= RestAssured.get("https://randomuser.me/api/");

    //print my response
        response.prettyPrint();
        extentLogger.info("Verify Status Code is 200");
        int statucode=response.statusCode();
        Assert.assertEquals(statucode,200);

        String reString=response.asString();
        extentLogger.info("Verify what response contain");
        Assert.assertTrue(reString.contains("name"));

        extentLogger.pass("completed");

    }

    @Test
    public void headersTest(){

        extentLogger=report.createTest("Headers Test");

        Response response=RestAssured.get("https://randomuser.me/api/");
        System.out.println(response.headers());
        System.out.println(response.contentType());

        extentLogger.info("Verify Response type");
        Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");

     }

     @Test
    public void statusLineTest(){
        Response response=RestAssured.get("https://randomuser.me/api/");
        String statusCodeLine=response.statusLine();
        System.out.println(statusCodeLine);
        Assert.assertTrue(statusCodeLine.contains("200"));

     }


}
