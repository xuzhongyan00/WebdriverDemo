package com.webdemo.day003;

import com.gargoylesoftware.htmlunit.html.HtmlListing;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by X Rebecca on 2016/12/16.
 */
public class WindowTest {
    WebDriver driver;
    @BeforeMethod
    public void OpenChrome() {
//        获取安装位置并打开chrome
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void winTest(){
        driver.get("file://D:\\Automation App\\WebDriver\\selenium_html/index.html");
//        定位并点击开启新窗口的链接
        driver.findElement(By.linkText("Open new window")).click();
//        获取当前窗口的handle值
        String handle1 = driver.getWindowHandle();
//        遍历获取每个窗口的handle值并与handle1对比
        for (String handles:driver.getWindowHandles()){
            if(handle1.equals(handles)){
                continue;
            }
            driver.switchTo().window(handles);
        }
//        找到新窗口并输入内容
        driver.findElement(By.id("user")).sendKeys("new window");
    }
    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(3000);
//        关闭浏览器
        driver.quit();
    }
}
