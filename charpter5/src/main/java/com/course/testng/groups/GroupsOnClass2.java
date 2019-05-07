package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "student")
public class GroupsOnClass2 {

    public void class1(){
        System.out.println("我是一年级一班");
    }

    public void class2(){
        System.out.println("我是一年级二班");
    }
}
