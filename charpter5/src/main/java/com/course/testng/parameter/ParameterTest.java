package com.course.testng.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {

    @Test
    @Parameters({"name","age"})
    public void paramterTestCase1(String name,String age){
        System.out.println("姓名：" + name + ",年龄：" + age);
    }
}
