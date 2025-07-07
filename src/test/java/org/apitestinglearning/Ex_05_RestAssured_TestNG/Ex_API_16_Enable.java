package org.apitestinglearning.Ex_05_RestAssured_TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Ex_API_16_Enable {

    @Test
    public void test1(){
        Assert.assertTrue(true);
        System.out.println("First Test");
    }

    @Test(enabled = false)
    public void test2(){
        Assert.assertTrue(true);
        System.out.println("Second Test");
    }

    @Test
    public void test3(){
        Assert.assertTrue(true);
        System.out.println("Third Test");
    }
}
