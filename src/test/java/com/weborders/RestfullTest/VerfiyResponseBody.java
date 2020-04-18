package com.weborders.RestfullTest;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class VerfiyResponseBody {
    @BeforeClass
    public static void setUpClass(){
        //when we actually make requests, we only provide the path to

        RestAssured.baseURI="https://uinames.com/api"; // base url for all resources
    }

    @Test
    public void testBody(){

        given().when().get().
                then().assertThat().body("name", notNullValue());

        //firt param is locator name , get the value form the redponse and second atrgument will be the matcher
        //we are trying to verift key name has value



    }

    @Test
    public void verifyregion(){

        String region="Mexico";
        given().queryParam("region", region).
                when().get().
                then().log().body().
                assertThat().body("region", is(region));

        //firt param is locator name , get the value form the redponse and second atrgument will be the matcher
        //we are trying to verift key name has value

    }

    @Test
    public void veriNumberOfResult(){


        given().
                queryParam("amounty",2).
                when().get().
                then().
                assertThat().body("$", hasSize(2));

        //firt param is locator name , get the value form the redponse and second atrgument will be the matcher
        //we are trying to verift key name has value

    }
}

