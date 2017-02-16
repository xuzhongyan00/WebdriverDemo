package com.webdemo.day001;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by X Rebecca on 2016/12/14.
 */
public class BrowserActionTest {
    WebDriver driver;
    @BeforeMethod
    public void open(){
//        chromedriver路径并打开浏览器
        System.setProperty("webdriver.chrome.driver",".//drivers//chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void test02(){
//        打开百度页面
        driver.get("http://www.baidu.com");
    }
    @Test
    public void test01() throws InterruptedException {
        driver.get("http://www.baidu.com");
        driver.get("http://www.daoehua.com");
//        浏览器后退
        driver.navigate().back();
        Thread.sleep(2000);
//        浏览器前进
        driver.navigate().forward();
    }
    @Test
    public void test03(){
//        浏览器最大化
        driver.manage().window().maximize();
        driver.get("http://www.baidu.com");
    }
    @Test
    public void test04(){
//        设置浏览器大小
        Dimension dimension =new Dimension(300,500);
        driver.manage().window().setSize(dimension);
    }
    @Test
    public void test05(){
        driver.get("http://www.baidu.com");
//        获取当前浏览器的url
        String url = driver.getCurrentUrl();
        System.out.print("百度页面的url："+url);
//        校验
        Assert.assertEquals("https://www.baidu.com/",url);
    }
    @Test
    public void test06(){
        driver.get("http://www.baidu.com");
//        获取当前浏览器的Title
        String title = driver.getTitle();
        System.out.print("百度页面的title："+ title);
//        校验title值是否正确
        Assert.assertEquals("百度一下，你就知道",title);
    }
    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
