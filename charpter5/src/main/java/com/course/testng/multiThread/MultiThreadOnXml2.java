package com.course.testng.multiThread;

import org.testng.annotations.Test;

public class MultiThreadOnXml2 {

    @Test
    public void test1(){
        System.out.println("独立团：" + Thread.currentThread().getId());
    }
}
