package org.apitestinglearning;

import io.restassured.RestAssured;

public class Ex_API_01 {

    public static void main(String[] args) {

        RestAssured.given().baseUri("https://api.postalpincode.in/pincode/176095").
                when().get().
                then().log().all().statusCode(200);

    }
}
