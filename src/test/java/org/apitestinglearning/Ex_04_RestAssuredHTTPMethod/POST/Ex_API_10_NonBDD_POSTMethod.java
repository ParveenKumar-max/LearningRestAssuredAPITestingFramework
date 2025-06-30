package org.apitestinglearning.Ex_04_RestAssuredHTTPMethod.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Ex_API_10_NonBDD_POSTMethod {


    RequestSpecification rs;
    Response r;
    ValidatableResponse vr;

    @Test
    public void test_post_nonBDDmethod(){

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

        System.out.println("------------------Part 1 ---------------");
        // Part 1 - Pre Condition - Preparing Request - URL, Headers, Auth...
        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/auth");
        rs.contentType(ContentType.JSON);
        rs.body(token).log().all();

        System.out.println("------------------Part 2 ---------------");
        // Part 2 - Making HTTP Request...
        r = rs.when().log().all().post();

        System.out.println("------------------Part 3 ---------------");
        // Part 3 - Verification Part...

        vr = r.then().log().all();
        vr.statusCode(200);

    }
}
