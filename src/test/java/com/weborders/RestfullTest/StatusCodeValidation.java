package com.weborders.RestfullTest;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class StatusCodeValidation {

    @BeforeClass
    public static void setUpClass(){
        //when we actually make requests, we only provide the path to

        RestAssured.baseURI="https://uinames.com/api"; // base url for all resources
    }

    @Test
    public void testOk(){
        given().
                when().get().
                then().statusCode(200);
    }

    @Test
    public void notFoundTest(){
        given().
                when().get("gsdhsdjksj").
                then().statusCode(404);
    }


}
