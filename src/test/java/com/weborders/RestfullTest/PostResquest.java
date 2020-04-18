package com.weborders.RestfullTest;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.*;
import static io.restassured.RestAssured.*;

public class PostResquest {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://cybertek-reservation-api-qa.herokuapp.com/";


    }

    @Test
    public void createTeam(){

     //   String token=Book

    }
}
