package org.apitestinglearning.Ex_03_AllureReport;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Ex_API_06_AllureReportTCs {
        // THIS IS BDD style, we won't follow that, because it's not scalable approach.
        // If you have 10k TC's, then it's not suitable approach.
      String pincode = "176095";

        @Test
        public void test_get_positive_tc1() {
            pincode = "176095";
            RestAssured.given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/" + pincode)
                    .when().get()
                    .then().log().all()
                    .statusCode(200);

        }

        @Test
        public void test_get_positive_tc2() {
            pincode = "176095@";
            RestAssured.given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/" + pincode)
                    .when().get()
                    .then().log().all()
                    .statusCode(200);

        }
        @Test
    public void test_get_positive_tc3(){
            pincode = "7894561";
            RestAssured.given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/" + pincode)
                    .when().get()
                    .then().log().all()
                    .statusCode(200);
        }


    }
