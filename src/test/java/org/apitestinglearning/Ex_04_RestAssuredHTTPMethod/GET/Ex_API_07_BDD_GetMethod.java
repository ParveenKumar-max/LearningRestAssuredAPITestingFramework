package org.apitestinglearning.Ex_04_RestAssuredHTTPMethod.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Ex_API_07_BDD_GetMethod {

    @Test
    public void test_get_positive_tc1() {
          String  pincode = "176095";
            RestAssured.given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/" + pincode)
                    .when().get()
                    .then().log().all()
                    .statusCode(200);

        }
    }
