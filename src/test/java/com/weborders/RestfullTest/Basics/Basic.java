package com.weborders.RestfullTest.Basics;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import org.junit.Test;
//given keyword is in static packace you have to import
public class Basic {
    @Test
    public void basics(){
       //given --all inpout details-
       //when--submit the API-resource,http method
       //then--Validate respons
        //
        RestAssured.baseURI="https://rahulshettyacademy.com";
        String response= given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json;charset=UTF-8").
                body(payLoad.addPlace()).
                when().post("maps/api/place/add/json").
                then().assertThat().statusCode(200).body("scope",equalTo("APP"))
                .extract().response().asString();
               //.header("Server", "Apache/2.4.18 (Ubuntu)");?

        System.out.println(response);
        JsonPath js= new JsonPath(response);//for parsing json
        String placeId= js.getString("place_id");
        System.out.println(placeId);

       //update place-->update palce with new address
        String newAddress=" Summer walk, Africa";
        given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json;charset=UTF-8")
                .body("{\n" +
                "\"place_id\":\""+placeId+"\",\n" +
                "\"address\":\""+newAddress+"\",\n" +
                "\"key\":\"qaclick123\"\n" +
                "}\n").
                when().put("maps/api/place/update/json?key=qaclick123").
                then().assertThat().log().all().statusCode(200).body(" msg", equalTo("Address successfully updated"));

        //get place
        //no headers are require when you send get reguest
        //so no need to add part header.("Content-Type","application/json;charset=UTF-8")

       String getPlaceResponse= given().log().all().queryParam("key","qaclick123").
                queryParam("place_id", placeId).
                when().get("maps/api/place/get/json").
                then().assertThat().log().all().statusCode(200).
                extract().response().asString();

       JsonPath js1=ReusableMethods.rawToJson(getPlaceResponse);
      String actual_address= js1.getString("address");//address in json respond in postman

        System.out.println(actual_address);
        Assert.assertEquals(newAddress,actual_address);
    }
}
