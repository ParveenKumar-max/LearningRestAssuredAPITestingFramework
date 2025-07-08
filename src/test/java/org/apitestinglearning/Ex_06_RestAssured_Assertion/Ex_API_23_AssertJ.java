package org.apitestinglearning.Ex_06_RestAssured_Assertion;
// entry point for all assertThat methods and utility methods (e.g. entry)

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class Ex_API_23_AssertJ {

    RequestSpecification RS;
    Response R;
    ValidatableResponse VR;
   /* String token;
    Integer bookingID;      As of now, there is no use */


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

        RS = RestAssured.given();
        RS.baseUri("https://restful-booker.herokuapp.com");
        RS.basePath("/booking");
        RS.contentType(ContentType.JSON);
        RS.body(payload).log().all();

        R = RS.when().post();

        // Get Validatable response to perform validation

        VR = R.then().log().all();

        // Rest Assured.
        VR.statusCode(200);


        // firstname == Parveen , Last Name = Chaudhary
        // Booking ID shouldn't null

        VR.body("booking.firstname", Matchers.equalTo("Parveen"));
        VR.body("booking.lastname", Matchers.equalTo("Chaudhary"));
        VR.body("bookingid", Matchers.notNullValue());


    }

}

