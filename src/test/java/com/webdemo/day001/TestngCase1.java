package com.webdemo.day001;

import org.testng.annotations.*;

/**
 * Created by X Rebecca on 2016/12/13.
 */
public class TestngCase1 {
    @Test
    public void test3(){
        System.out.println("这是一个Test3");
    }
    @Test
    public void test1(){
        System.out.println("这是一个test1");
    }
    @BeforeTest
    public void test2(){
        System.out.println("这是一个@BeforeTest");
    }
    @BeforeMethod
    public void test6(){
        System.out.println("这是一个@BeforeMethod");
    }
    @AfterTest
    public void test5(){
        System.out.println("这是一个@AfterTest");
    }
    @AfterMethod
    public void test4(){
        System.out.println("这是一个@AfterTest");
    }





}
