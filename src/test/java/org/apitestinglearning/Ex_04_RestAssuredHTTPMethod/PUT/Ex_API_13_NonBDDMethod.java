package org.apitestinglearning.Ex_04_RestAssuredHTTPMethod.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Ex_API_13_NonBDDMethod {

    RequestSpecification rs;
    Response r;
    ValidatableResponse vr;

    @Test
    public void test_put_nonbddmethod() {
        String token = "159a93521559ae6";
        String bookingID = "921";

        String payload = "'{\n" +
                "    \"firstname\" : \"Parveen\",\n" +
                "    \"lastname\" : \"Chaudhary\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}'";

        System.out.println("------------------Part 1 ---------------");
        // Part 1 - Pre Condition - Preparing Request - URL, Headers, Auth...
        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/" + bookingID);
        rs.contentType(ContentType.JSON);
        //rs.auth().oauth();
        rs.cookie("token", token);
        rs.body(payload).log().all();

        System.out.println("------------------Part 2 ---------------");
        // Part 2 - Making HTTP Request...
        r = rs.when().log().all().put();

        System.out.println("------------------Part 3 ---------------");
        // Part 3 - Verification Part...

        vr = r.then().log().all();
        vr.statusCode(200);


    }
}