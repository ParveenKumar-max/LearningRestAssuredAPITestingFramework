package org.apitestinglearning.Ex_05_RestAssured_TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Ex_API_17_AlwaysRun {

    @Test(alwaysRun = false, priority = 1)
    public void test1(){
        Assert.assertTrue(true);
        System.out.println("First Time");
    }

    @Test(enabled = false)
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
