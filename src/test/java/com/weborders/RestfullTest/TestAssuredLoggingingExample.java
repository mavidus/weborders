package com.weborders.RestfullTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class TestAssuredLoggingingExample {

    @Test
    public void loggingTest(){
//log provides logging options for request-it will print our request
        given().log().all().//instead logall, you could say plathparams
                when().get("https://uinames.com/api/");

        System.out.println("***********\n");
        //LOG Response
        Response response=RestAssured.get("https://uinames.com/api/") ;

      //  response.then().log().all();
        response.then().log().headers();
        //response.then().log().body();

    }
}
