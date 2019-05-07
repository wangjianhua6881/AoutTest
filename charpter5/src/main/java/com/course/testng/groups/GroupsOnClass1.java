package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "student")
public class GroupsOnClass1 {

    public void student1(){
        System.out.println("我是一号学生");
    }

    public void student2(){
        System.out.println("我是二号学生");
    }
}
