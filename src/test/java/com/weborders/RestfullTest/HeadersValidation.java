package com.weborders.RestfullTest;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
/*
public class HeadersValidation {

    @BeforeClass
    public static void setUpClass(){
        //when we actually make requests, we only provide the path to

        RestAssured.baseURI="https://uinames.com/api"; // base url for all resources
    }

    @Test
    public void headerTest(){

        given().
            when().get().//verify getting the vlaue of the from first parameter given and verify the value
                then().header("Content-Type",
                "application/json; charset=utf-8");
    }
}


 */