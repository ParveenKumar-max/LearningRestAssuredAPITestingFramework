package org.apitestinglearning.Ex_04_RestAssuredHTTPMethod;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Ex_API_08_NBB_GetMethod {

    RequestSpecification rs;
    Response r;
    ValidatableResponse vr;

    @Test
    public void test_NDD_get_method(){

        String pincode = "176095";

        //Given
        rs = RestAssured.given();
        rs.baseUri("https://api.zippopotam.us");
        rs.basePath("/IN/" + pincode);

        //When
        r = rs.when().log().all().get();
        System.out.println(r.asString());

        //Then
        vr = r.then().log().all();
        vr.statusCode(200);
    }
}
