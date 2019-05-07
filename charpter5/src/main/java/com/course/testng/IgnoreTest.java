package com.course.testng;

import org.testng.annotations.Test;

public class IgnoreTest {

    @Test
    public void ignoreTest1(){
        System.out.println("执行了ignoreTest1");
    }

    // enabled = false 在用例执行的时候忽略此条case
    @Test(enabled = false)
    public void ignoreTest2(){
        System.out.println("执行了ignoreTest2");
    }

    // enabled = true 等同于什么都不加的 ignoreTest1
    @Test
    public void ignoreTest3(){
        System.out.println("执行了ignoreTest3");
    }
}
