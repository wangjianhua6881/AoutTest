package com.course.testng;

import org.testng.annotations.Test;

public class TimeOutTest {

    //超时单位毫秒
    @Test(timeOut = 3000)
    public void testSuccess(){
        System.out.println("运行成功！");
    }

    //超时单位毫秒
    @Test(timeOut = 2000)
    public void testFail() throws InterruptedException {
        Thread.sleep(3000);
    }
}
