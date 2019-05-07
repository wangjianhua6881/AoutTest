package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class GroupsOnClass3 {

    public void teacher1(){
        System.out.println("我是一号老师");
    }

    public void teacher2(){
        System.out.println("我是二号老师");
    }
}
