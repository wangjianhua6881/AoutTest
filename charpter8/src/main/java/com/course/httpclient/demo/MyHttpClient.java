package com.course.httpclient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;
import org.apache.http.client.HttpClient;

import java.io.IOException;

public class MyHttpClient {

    @Test
    public void test1() throws IOException {

        //用来放请求结果
        String result;
        //创建get方法
        HttpGet get = new HttpGet("https://www.baidu.com");
        //client是用来执行get方法的
        HttpClient client = new DefaultHttpClient();
        //获取响应内容
        HttpResponse response = client.execute(get);
        //用getEntity()获取响应的所有内容，用EntityUtils.toString转换为正常的字符串
        result = EntityUtils.toString(response.getEntity(),"UTF-8");
        System.out.println(result);
    }
}
