package com.weborders.RestfullTest.AddBook;
import com.weborders.RestfullTest.Basics.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DynamicJson {
    //this is a post request
    @Test
    public void addBookk() {
        RestAssured.baseURI = "http://216.10.245.166";
        String response = given().
                header("Content-Type", "application/json").
                body(payLoad.AddBook("asfde", "6464")).
                when().
                post("/Library/Addbook.php").
                then().log().all().assertThat().statusCode(200).
                extract().response().asString();

        JsonPath js = ReusableMethods.rawToJson(response);
        String id = js.get("ID");
        System.out.println(id);

//deleteBook

/*
    }

    @DataProvider
    public void getData()
    {

        new object[][]{array1,array2,array3};

    }

 */
    }
}