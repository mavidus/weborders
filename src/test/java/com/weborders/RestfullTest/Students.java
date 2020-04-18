package com.weborders.RestfullTest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
/*
public class Students {
    @Test
    public void studentList() {



        Response respond = RestAssured.get("https://reqres.in/api/users");

        System.out.println(respond.statusCode());
        Assert.assertEquals(respond.statusCode(), 200);
        System.out.println(respond.asString());//get the body

        JsonPath jp=respond.jsonPath();
        List<String> user=jp.get("email");
        System.out.println(user.size());
        for(String users:user){
            System.out.println(user==null);
        }


        //jsonpath.curiousconcept.com
    }

    @Test
    public void singleStudent(){
        //create a test
        // hit apis that gets only one student
        //print out status code and result

        Response respond = RestAssured.get("https://reqres.in/api/users/1");
        System.out.println(respond.statusCode());
        System.out.println(respond.asString());

        JsonPath jp=respond.jsonPath();//will convert our respond object into json path
        String name=jp.get("first_name");
        System.out.println(name);



    }
}



 */
