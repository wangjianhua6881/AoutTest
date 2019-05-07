package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {

    @Test(groups = "server")
    public void serverTest1(){
        System.out.println("这是服务端的方法：111111");
    }

    @Test(groups = "server")
    public void serverTest2(){
        System.out.println("这是服务端的方法：222222");
    }

    @Test(groups = "client")
    public void clientTest1(){
        System.out.println("这是客户端的方法：111111");
    }

    @Test(groups = "client")
    public void clientTest2(){
        System.out.println("这是客户端的方法：222222");
    }

    @BeforeGroups(groups = "server")
    public void beforeGroupOnServer(){
        System.out.println("这是服务端组级别前置运行方法！");
    }

    @AfterGroups(groups = "server")
    public void afterGroupOnServer(){
        System.out.println("这是服务端组级别后置运行方法！");
    }



}
