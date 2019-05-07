package com.course.testng.multiThread;

import org.testng.annotations.Test;

public class MultiThreadOnXml {

    @Test
    public void test1(){
        System.out.println("方法1当前执行的线程ID是：" + Thread.currentThread().getId());
    }

    @Test
    public void test2(){
        System.out.println("方法2当前执行的线程ID是：：" + Thread.currentThread().getId());
    }

    @Test
    public void test3(){
        System.out.println("方法3当前执行的线程ID是：：" + Thread.currentThread().getId());
    }
}
