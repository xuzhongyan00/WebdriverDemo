package com.webdemo.day003;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by X Rebecca on 2016/12/16.
 */
public class IframeTest {
    WebDriver driver;
    @BeforeMethod
    public void OpenChrome() {
//        获取安装位置并打开chrome
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void iframeTest() throws InterruptedException {
        driver.get("file://D:\\Automation App\\WebDriver\\selenium_html/index.html");
//      转交控制台给Frame
        driver.switchTo().frame("aa") ;
        Thread.sleep(2000);
//        点击baidu链接
        driver.findElement(By.linkText("baidu")).click();
//        控制台转交回默认
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
//        定位并点击输入框
        driver.findElement(By.id("user")).click();

    }
    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(3000);
//        关闭浏览器
        driver.quit();
    }
}
