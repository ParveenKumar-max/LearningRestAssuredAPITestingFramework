package org.apitestinglearning.Ex_04_RestAssuredHTTPMethod.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Ex_API_11_NonBDDMethod {

    @Test
    public void test_put_nonBddMethod() {
    String token = "038ba9b9295d600";
    String bookingid = "582";

    String payloadPatch = "{\n" +
            "    \"firstname\" : \"Lucky\",\n" +
            "    \"lastname\" : \"Brown\"\n" +
            "}";


        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/" + bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);

        requestSpecification.body(payloadPatch).log().all();

        Response response = requestSpecification.when().patch();

        ValidatableResponse validatableResponse = response.then().log().all();

        validatableResponse.statusCode(200);

    }
}
