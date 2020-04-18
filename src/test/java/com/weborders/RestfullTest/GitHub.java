package com.weborders.RestfullTest;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class GitHub {

    @BeforeClass
    public static void setUp(){

        RestAssured.baseURI="https://api.github.com";

    }

    @Test
    public void userTest(){

        //given ---prepare request
        //sub,it it to url

        given(). pathParam("username", "emel").
                when().get("/users/{username}").prettyPrint();

    }


}
