package com.course.testng.multiThread;

import org.testng.annotations.Test;

public class MultiThreadTest {

    @Test(invocationCount = 10,threadPoolSize = 10)
    public void threadPoolTest(){
        System.out.print("执行次数：1,");
        System.out.println("线程ID: " + Thread.currentThread().getId());
    }
}
