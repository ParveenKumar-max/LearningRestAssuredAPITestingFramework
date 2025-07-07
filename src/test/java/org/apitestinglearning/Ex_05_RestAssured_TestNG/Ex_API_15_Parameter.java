package org.apitestinglearning.Ex_05_RestAssured_TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Ex_API_15_Parameter {

    @Parameters("browser")
    @Test
    public void test_parameter_method(String browser){
        System.out.println("Pick Browser");

        if(browser.equalsIgnoreCase("chrome")){
            System.out.println("Open Chrome");
        }
        if(browser.equalsIgnoreCase("firefox")){
            System.out.println("Open Firefox");
        }
    }
}