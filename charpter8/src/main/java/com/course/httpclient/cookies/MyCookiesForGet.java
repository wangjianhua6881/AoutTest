package com.course.httpclient.cookies;


import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.http.cookie.Cookie;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class MyCookiesForGet {

    private String url;
    private String uri;
    private String requestPath;
    private String result;
    private CookieStore cookieStore;
    private ResourceBundle bundle;
    private HashMap<String,String> handers = new HashMap<String, String>();

    @BeforeMethod
    public void beforTest(){
        bundle = ResourceBundle.getBundle("application");
        url = bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        uri = bundle.getString("test.get.returnCookies");
        requestPath = url + uri;
        HttpGet get = new HttpGet(requestPath);
        HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity());
        System.out.println(result);

        //获取cookies数据
        this.cookieStore = ((DefaultHttpClient) client).getCookieStore();
        //将cookies分解为列表List
        List<Cookie> cookieList = this.cookieStore.getCookies();

        //循环列表，打印每个cookies数据
        for (Cookie cookie:cookieList) {
            String key = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name = " + key + ",value = " + value);
        }
    }

//    @Test(dependsOnMethods = {"testGetCookies"})
//    public void requestGetWhithCookies() throws IOException {
//        uri = bundle.getString("test.get.cookies.login");
//        requestPath = url + uri;
//        HttpGet get = new HttpGet(requestPath);
//        HttpClient client = new DefaultHttpClient();
//        ((DefaultHttpClient) client).setCookieStore(this.cookieStore);
//        HttpResponse response = client.execute(get);
//
//        int statusCode = response.getStatusLine().getStatusCode();
//        System.out.println(statusCode);
//        if (statusCode == 200) {
//            result = EntityUtils.toString(response.getEntity());
//            System.out.println(result);
//        }
//    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void postWhithCookies() throws IOException {
        //拼接url
        uri = bundle.getString("test.post.cookies.login");
        requestPath = url + uri;
        //新建post方法
        HttpPost post = new HttpPost(requestPath);
//        //新建json对象，并传入参数 key,value
//        JSONObject param = new JSONObject();
//        param.put("name","huhansan");
//        param.put("age","99");
//        //将json对象转换为StringEntity类型，并传入post方法中
//        StringEntity entity = new StringEntity(param.toString(),"utf-8");
//        post.setEntity(entity);
//        //添加请求头
//        post.setHeader("content-type","application/json");
//        //新建模拟客户端
//        HttpClient client = new DefaultHttpClient();
//        //设置cookies
//        ((DefaultHttpClient) client).setCookieStore(this.cookieStore);
//        //用客户端执行方法,并请求拿到响应结果
//        HttpResponse response = client.execute(post);
//        //将结果转为字符串类型
//        result = EntityUtils.toString(response.getEntity());
//        //将响应字符串转成JSON格式，方便提取value
//        JSONObject resultJson = new JSONObject(result);
//        //提取key值为data的数据，并对值进行断言
//        String data = (String)resultJson.get("data");
//        Assert.assertEquals(data,"欢迎你回来，胡汉三！");
//        //提取key值为message的数据，并对值进行断言
//        String message = (String)resultJson.get("message");
//        Assert.assertEquals(message,"success");

        //第一种方法 post.setHeader("content-type","application/json");
        handers.put("content-type","application/json");
        for (Map.Entry<String,String> map:handers.entrySet()) {
            post.addHeader(map.getKey(),map.getValue());
        }

        //创建json对象，加入参数值，如果参数不是对象的话，需要这样写
        //如果是对象的话，直接写第5段代码  post.setEntity(new StringEntity(json.toString(对象)))
        JSONObject json = new JSONObject();
        json.put("name","huhansan");
        json.put("age","99");
        //将json参数转换为
        StringEntity requestEntity = new StringEntity(json.toString(),"UTF-8");
        post.setEntity(requestEntity);


        HttpClient client = new DefaultHttpClient();
        ((DefaultHttpClient) client).setCookieStore(this.cookieStore);
        HttpResponse response = client.execute(post);
        result = EntityUtils.toString(response.getEntity());
        System.out.println("---------------分割线--------------");
        System.out.println(result);
    }
}
