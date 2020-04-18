package com.weborders.RestfullTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.*;

import static io.restassured.RestAssured.*;
public class AccessTokenExample {

    @BeforeClass
    public static void setup(){
        RestAssured.baseURI="https://cybertek-reservation-api-qa.herokuapp.com/";

    }

    @Test
    public void getTokentest(){
       Response response= given().log().all().
        param("email","teacherva5@gmail.com").
                param("password", "maxpayne").
                get("/sign");
       String token="ghjkmnbvghjk,m.ghjk,m.hgvfctyuhjknm";

       response.then().log().all().
                assertThat().statusCode(200);

       //used to parse through json response easily
        String accessToken=response.jsonPath().get("accessToken");
        System.out.println(accessToken);
        //trying to get the my campous
        //we are passing our token as apart of the request header

        RestAssured.given().header("Authorization", accessToken).
                get("/api/campuses").then().log().all().assertThat().statusCode(200);
    }
}
