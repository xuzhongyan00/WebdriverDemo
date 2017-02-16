package com.webdemo.day004;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedCondition;
import java.util.concurrent.TimeUnit;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by X Rebecca on 2016/12/28.
 */
public class HomeWork {
    WebDriver driver;
    @Test
    public void test01() throws AWTException, InterruptedException {
        driver = new FirefoxDriver();
        driver.get("http:\\www.baidu.com");
//        定位到搜索框并输入 adb
        driver.findElement(By.id("kw")).sendKeys("adb");
//        点击 百度一下
        driver.findElement(By.id("su")).click();
        Thread.sleep(1000);
//        定位到搜索结果的第一条，并点击
        driver.findElement(By.xpath(".//*[@id='1']/h3/a")).click();
//        获取当前页面的handle值
        String handle = driver.getWindowHandle();
//        获取每个页面的handle值并判断是否为当前页
        for(String handles:driver.getWindowHandles()){
            if(handle.equals(handles))
                continue;
//            不是当前页面就转交控制权
            driver.switchTo().window(handles);
        }
        Thread.sleep(2000);
//        定位并点击 下载 按钮
        driver.findElement(By.xpath(".//*[@id='ad370236']/img")).click();
        Thread.sleep(2000);
//        实例化一个robot
        Robot robot = new Robot();
//        移动到左边的“保存文件”
        robot.keyPress(KeyEvent.VK_LEFT);
        Thread.sleep(2000);
//        点击，进行下载
        robot.keyPress(KeyEvent.VK_ENTER);
//        等待10秒后关闭
        Thread.sleep(10000);
        driver.quit();
    }
}
