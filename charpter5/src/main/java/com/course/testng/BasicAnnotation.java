package com.course.testng;

import org.testng.annotations.*;

public class BasicAnnotation {

    @Test
    public void testCase1(){
        System.out.println("这是第一个TestCase");
    }

    @BeforeMethod
    public void beforMethod(){
        System.out.println("在每个方法之前运行一次");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("在每个方法运行之后运行一次");
    }

    @Test
    public void testCase2(){
        System.out.println("这是我的第二个TestCase");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("这是在类运行之前运行的");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("这是在类运行之后运行的");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("这是测试套前置方法");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("这是测试套后置方法");
    }


}
