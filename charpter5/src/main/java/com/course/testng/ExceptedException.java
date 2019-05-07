package com.course.testng;

import org.testng.annotations.Test;

public class ExceptedException {

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExpectedExceptionFail(){
        System.out.println("异常测试");
    }

    /**
     * 什么时候使用呢？
     * 我输入的值是错误的，我的预期就是一个错误的异常
     */
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExpectedException(){
        System.out.println("这是我想要的异常结果！");
        throw new RuntimeException();
    }
}
