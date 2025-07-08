package org.apitestinglearning.Ex_05_RestAssured_TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Ex_API_19_Priority {

    @Test(priority = 3)
    public void test1(){
        Assert.assertTrue(true);
        System.out.println("First Time");
    }

    @Test(priority = 2)
    public void test2(){
        Assert.assertTrue(true);
        System.out.println("Second Time");
    }

    @Test(priority = 1)
    public void test3(){
        Assert.assertTrue(true);
        System.out.println("Third Time");
    }
}
