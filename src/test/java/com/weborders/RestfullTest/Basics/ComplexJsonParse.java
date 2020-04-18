package com.weborders.RestfullTest.Basics;

import io.restassured.path.json.JsonPath;
import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ComplexJsonParse {
/*
1. Print No of courses returned by API

2.Print Purchase Amount

3. Print Title of the first course

4. Print All course titles and their respective Prices

5. Print no of copies sold by RPA Course

6. Verify if Sum of all Course prices matches with Purchase Amount

 */
    @Test
    public void complexJson(){
        JsonPath js=new JsonPath(payLoad.coursePrice());
       int count= js.getInt("courses.size()");//we know course is array because of [].look at jsoneditor online
       System.out.println(count);

        int total = js.getInt("dashboard.purchaseAmount");
        System.out.println(total);

        String titleFirstCourse = js.get("courses[0].title");
        System.out.println(titleFirstCourse);

        String titleLastCourse = js.get("courses[2].title");
        System.out.println(titleLastCourse);



//4. Print All course titles and their respective Prices
        for(int i=0; i<count; i++)
        {
            String courseTitles=js.get("courses["+i+"].title");
         System.out.println(courseTitles);
        }

        for(int i=0; i<count; i++)
        {

            System.out.println(js.get("courses["+i+"].price".toString()));
        }
 //5. Print number of copies sold by RPA Course  //remeber index might change


        System.out.println("Print number of copies sold by RPA course");

        for(int i=0; i<count; i++)
        {
            String courseTitles=js.get("courses["+i+"].title");
            if (courseTitles.equalsIgnoreCase("RPA"))
            {
                int copies=js.get("courses["+i+"].copies");
                System.out.println(copies);
                break;//when its found RPA exit from the loop

            }
        }

    }
    @Test
    //  6. Verify if Sum of all Course prices matches with Purchase Amount
    public void sumValidation() {

        int sum=0;

        JsonPath js=new JsonPath(payLoad.coursePrice());
        int count=js.getInt("courses.size()");
        for(int i=0; i<count; i++)
        {
           int price= js.get("courses["+i+"].price");
            int copies= js.get("courses["+i+"].copies");
            int amount=price*copies;
            System.out.println(amount);
            sum=sum+amount;

        }
         System.out.println(sum);
       int purcahseAmount= js.getInt("dashboard.purchaseAmount");
       Assert.assertEquals(purcahseAmount, sum);


    }
}
