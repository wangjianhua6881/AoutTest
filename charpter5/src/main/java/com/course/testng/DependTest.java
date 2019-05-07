package com.course.testng;

import org.testng.annotations.Test;

public class DependTest {

    @Test(groups = "groups1")
    public void grupsTest1(){
        System.out.println("测试组跑起来1");
    }

    @Test(groups = "groups1")
    public void groupsTest2(){
        System.out.println("测试组跑起来2");
    }

    @Test(dependsOnGroups = {"groups1"})
    public void testDependsGroups(){
        System.out.println("依赖测试组拍起来啦！！！");
    }

    @Test
    public void test1(){
        System.out.println("run test1");
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("run test2");
    }

    @Test
    public void test3(){
        throw new RuntimeException();
    }

    @Test(dependsOnMethods = {"test3"})
    public void test4(){
        System.out.println("run test4");
    }
}
