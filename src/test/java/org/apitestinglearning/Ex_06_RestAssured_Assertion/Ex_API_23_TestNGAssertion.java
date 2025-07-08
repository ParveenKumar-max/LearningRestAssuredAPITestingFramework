package org.apitestinglearning.Ex_06_RestAssured_Assertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Ex_API_23_TestNGAssertion {


    @Test
    public void test_hardAssertExample() {
        System.out.println("Start of the program");
      //  Boolean is_neeru_male = false;
        Assert.assertEquals("pramod","Pramod");
        System.out.println("End of the program");

    }

    // Software Assertion

    @Test
    public void test_softAssertExample() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("pramod","Pramod");
        System.out.println("End of program");
        softAssert.assertAll();
    }




}
