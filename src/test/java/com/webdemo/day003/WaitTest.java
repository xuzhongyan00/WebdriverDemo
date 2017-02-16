package com.webdemo.day003;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by X Rebecca on 2016/12/16.
 */
public class WaitTest {
    WebDriver driver;
    @BeforeMethod
    public void OpenChrome() {
//        获取安装位置并打开chrome
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
//        全局等待30秒
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    @Test
    public void waitTest() throws InterruptedException {
        driver.get("file://D:\\Automation App\\WebDriver\\selenium_html/index.html");
        driver.findElement(By.className("wait")).click();
//        Thread.sleep(3000);
        //        使用显示等待方法
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("red")));
//        定位红色字体并获取文本
       String waittext = driver.findElement(By.xpath(".//*[@id='display']/div")).getText();
//       校验
        Assert.assertEquals(waittext,"wait for display");
    }
    @Test
    public void testGet(){
        driver.get("http://www.baidu.com");
        System.out.println(driver.getTitle());
    }
    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(3000);
//        关闭浏览器
        driver.quit();
    }
}
