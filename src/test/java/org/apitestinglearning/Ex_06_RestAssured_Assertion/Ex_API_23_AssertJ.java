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
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class Ex_API_23_AssertJ {

    RequestSpecification RS;
    Response R;
    ValidatableResponse VR;
    /* String token; As of now, there is no use */
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
        // Rest Assured -> import org.hamcrest.Matchers; %4-%5
        // Matchers.equalto()

        VR.body("booking.firstname", Matchers.equalTo("Parveen"));
        VR.body("booking.lastname", Matchers.equalTo("Chaudhary"));
        VR.body("bookingid", Matchers.notNullValue());

        // TestNG - Extract the details of the firstname, bookingId, lastname from Response.

        bookingID = R.then().extract().path("bookingid");
        String Firstname = R.then().extract().path("booking.firstname");
        String Lastname = R.then().extract().path("booking.lastname");


        // TestNG Assertions - 75%
        // SoftAssert vs
        // HardAssert -
        // This means that if any assertion fails,
        // the remaining statements in that test method will not be executed.

        Assert.assertEquals(Firstname, "Parveen");
        Assert.assertEquals(Lastname, "Chaudhary");
        Assert.assertNull(bookingID);


        // AssertJ( 3rd- Lib to Assertions) - 20%
        assertThat(bookingID).isNotNull().isNotNegative().isNotZero();
        assertThat(Firstname).isEqualTo("Parveen").isNotEmpty().isNotBlank();
        assertThat(Lastname).isEqualTo("Chaudhary").isNotEmpty().isNotBlank();

        //        String s = ""; //Empty
        //        String s2 = " "; //Blank


    }

}

