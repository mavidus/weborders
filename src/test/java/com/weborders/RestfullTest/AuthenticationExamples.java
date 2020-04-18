package com.weborders.RestfullTest;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class AuthenticationExamples {

    @Test
    public void usingApiKey(){

        RestAssured.given().log().all().
                queryParam("t", "Kung Fury").
                queryParam("apikey", "a9faab96").
                 when().get("http://www.omdbapi.com/").
                then().log().all().assertThat().statusCode(200);
    }

    @Test
    public void basicAuthentication401Validation(){
        //https://the-internet.herokuspp.com/basic_auth
        //when we try to hit and endpoint withpout being authorised
        //we can 401 not authorized error

        RestAssured.get("https://the-internet.herokuapp.com/basic_auth").
                then().assertThat().statusCode(401);

    }

    @Test
    public void basicAuthentication(){
        //auth-->provides different types of authentication
        //basic--->authentication using username and password
        RestAssured.given().
                auth().basic("admin", "admin").
                when().get("https://the-internet.herokuapp.com/basic_auth").
                then().assertThat().statusCode(200);
    }

    @Test
    public void xmlResponseExample(){
        RestAssured.get("http://parabank.parasoft.com/parabank/services/bank/customers/12212/").
                then().log().all().assertThat().statusCode(200);

    }

    @Test
    public void basicPreeptiveAuthentication(){
        //auth--->provides different types of authentication
        //based-->authentication using username and passrord

        RestAssured.given().
                auth().preemptive().basic("admin","admin").
                when().get("https://the-internet.herokuapp.com/basic_auth").
                then().assertThat().statusCode(200);
    }



}
