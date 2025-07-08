package org.apitestinglearning.Ex_05_RestAssured_TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Ex_API_18_Innvocation {

    @Test(invocationCount = 1)
    public void test1(){
        Assert.assertTrue(true);
        System.out.println("First Time");
    }

    @Test(invocationCount = 4)
    public void test2(){
        Assert.assertTrue(true);
        System.out.println("Second Time");
    }

    @Test(invocationCount = 6)
    public void test3(){
        Assert.assertTrue(true);
        System.out.println("Third Time");
    }
}
