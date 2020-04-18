package com.weborders.RestfullTest;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class RelaxedHttpsValidatioon {
    @Test
    public void relaxYo(){

        //we are going to trust connections with bad certificates
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.get("https://untrusted-root.badssl.com/").
                then().log().all().statusCode(200);

    }
}
