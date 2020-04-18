package com.weborders.RestfullTest;

import com.weborders.utilities.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
/*TEST CASE
1:When I send a GET request to : http://api.got.show/apibook/continents
2:Then response status code must be 200
3:I should see data in Json Format



 */

public class BaseURI extends TestBase {

    @BeforeClass
    public static void setUpClass(){


        //when we actually make requests, we only provide the path to

        RestAssured.baseURI="http://api.got.show/api"; // base url for all resources
    }
    @Test
    public void continents(){

        extentLogger=report.createTest("Rest Continents");

        Response response=RestAssured.get("book/continents");
        response.prettyPrint();

        extentLogger.info("Verifying Continents Method");
        Assert.assertTrue(response.asString().contains("Westeros"));
        extentLogger.pass("completed");
    }

    @Test
    public void citiesTest(){
        extentLogger=report.createTest("Rest Cities");

        Response response=RestAssured.get("book/cities");
        response.prettyPrint();

        extentLogger.info("Verifying Cities Method");
        Assert.assertTrue(response.asString().contains("name"));
        extentLogger.pass("completed");

    }

    @Test
    public void pathParam(){
        extentLogger=report.createTest("Path Param Test");

       given().pathParam("name","Lord Hewett's Town" ).
               when().get("book/cities/{name}").prettyPrint();
        extentLogger.pass("completed");
    }

    @Test
    public void getCharacterName(){
        extentLogger=report.createTest("Path Param Characters Name");

        given().pathParam("name","Addam").
                when().get("/book/characters/{name}").prettyPrint();
        extentLogger.pass("completed");
    }

}
