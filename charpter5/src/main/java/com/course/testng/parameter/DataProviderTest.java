package com.course.testng.parameter;

import com.sun.corba.se.spi.ior.ObjectKey;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {

    @Test(dataProvider = "data")
    public void providerTest1(String name,String age){
        System.out.println("姓名：" + name + ", 年龄：" + age);
    }

    @DataProvider(name="data")
    public Object[][] providerData(){
        Object[][] o = new Object[][]{
                {"张三","25"},
                {"李四","30"},
                {"王五","50"}
        };
        return o;
    }

    @Test(dataProvider = "methodData")
    public void test1(String name,String age){
        System.out.println("现在运行方法1 -- 姓名：" + name + ",  年龄：" + age);
    }

    @Test(dataProvider = "methodData")
    public void test2(String name,String age){
        System.out.println("现在运行方法1 -- 姓名：" + name + ",  年龄：" + age);
    }

    @DataProvider(name = "methodData")
    public Object[][] methodDataTest(Method method){
        Object[][] result = null;
        if (method.getName().equals("test1")) {
            result = new Object[][]{
                    {"赵龙", "28"},
                    {"马超", "30"}
            };
        }else if (method.getName().equals("test2")){
            result = new Object[][]{
                    {"蛮王","56"},
                    {"皇子","68"}
            };
        }else{
            System.out.println("啥也没找到，你说慌不慌～");
        }
        return result;
    }
}
