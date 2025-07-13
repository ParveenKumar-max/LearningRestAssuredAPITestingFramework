package org.apitestinglearning.Ex_07_RestAssured_PayloadManagement;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Ex_API_25_StringPayload {


    RequestSpecification RS;
    Response R;
    ValidatableResponse VR;
    /* String token; As of now, there is no use but it will use when we work in PUT and PATCH method.*/
    Integer bookingID;


    @Owner("Parveen")
    @Description("TC1 -- Verifying firstname & lastname Non BDD format with allure report")
    @Test
    public void test_assert01() {

        String payload = "{\n" +
                "    \"firstname\" : \"Parveen\",\n" +
                "    \"lastname\" : \"Chaudhary\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";


        // we never used string for RestAssured Testing,
        // because of the below points. So instead of String, we will use HASHMAP.
        // Compatibility, Immutable, Tough to maintain and change.
}
}
