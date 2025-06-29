package org.apitestinglearning.Ex_02_BuilderPattern;

import io.restassured.RestAssured;

public class Ex_API_05_MutipleTCs {

    // We will run multiple Test Case in a single file, But it's not a scalable approach.

    public static void main(String[] args) {

        // First Test Case
        String pincode = "176095";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when().get()
                .then().log().all()
                .statusCode(200);

        // Second Test Case
        pincode = "176095&";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when().get()
                .then().log().all()
                .statusCode(200);

        // Third Test Case
        pincode = "@176095";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when().get()
                .then().log().all()
                .statusCode(200);

    }


}
