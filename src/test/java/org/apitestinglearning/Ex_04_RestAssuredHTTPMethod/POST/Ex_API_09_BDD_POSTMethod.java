package org.apitestinglearning.Ex_04_RestAssuredHTTPMethod.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class Ex_API_09_BDD_POSTMethod {
    @Test
    public void test_post_BDDmethod(){

        // In POST RestAssured request, we need few important things
        // URL, Header, Payload, Body, Method
        // Auth --> For Authentication

        // {
        //    "username" : "admin",
        //    "password" : "password123"
        //}

        String token = "{\n" +
                "     \"username\" : \"admin\",\n" +
                "         \"password\" : \"password123\"\n" +
                "       }";

        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON)
                .log().all()
                .body(token)
                .when().log().all().post()
                .then().log().all()
                .statusCode(200);


    }
}
