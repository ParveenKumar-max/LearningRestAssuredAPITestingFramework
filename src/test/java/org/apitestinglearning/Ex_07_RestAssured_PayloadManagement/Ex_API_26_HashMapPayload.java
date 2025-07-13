package org.apitestinglearning.Ex_07_RestAssured_PayloadManagement;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class Ex_API_26_HashMapPayload {

    RequestSpecification RS;
    Response R;
    ValidatableResponse VR;
    String token;
    Integer bookingID;

    @Test
    public void hashmapPayload() {

     /*   String payload = "{\n" +
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
*/

        // HashMap --> Kay & Value pair

        Map<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("firstname","Parveen");
        bodyMap.put("lastname","Chaudhary");
        bodyMap.put("totalprice",111);
        bodyMap.put("depositpaid",true);

        // WE have another hashMap inside, so we need to create one more LinkedHashMap

        Map<String,Object> bookingData = new LinkedHashMap<>();
        bookingData.put("checkin","2018-01-01");
        bookingData.put("checkout","2019-01-01");

        bodyMap.put("bookingdates",bookingData);
        bodyMap.put("additionalneeds","Breakfast");
        System.out.println(bodyMap);


        // Using HashMap, it will create a simple

        //{firstname=Parveen, lastname=Chaudhary,
        // totalprice=111, depositid=true,
        // bookingdates={checkin=2019-01-01},
        // aditionalneeds=Breakfast}

        /* We can't load the HashMap value direct in RestAPI. so we need GSON repo. to convert it to
        * actual JSON . Let me add in the respostrory   */

        RS = RestAssured.given();
        RS.baseUri("https://restful-booker.herokuapp.com");
        RS.basePath("/booking");
        RS.contentType(ContentType.JSON);
        RS.body(bodyMap).log().all();

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

        Assert.assertEquals(Firstname,"Parveen");


    }
}
