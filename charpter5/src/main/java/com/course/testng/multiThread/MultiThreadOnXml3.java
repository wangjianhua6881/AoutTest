package com.course.testng.multiThread;

import org.testng.annotations.Test;

public class MultiThreadOnXml3 {

    @Test
    public void test1(){
        System.out.println("李云龙：" + Thread.currentThread().getId());
    }
}
