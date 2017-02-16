package com.webdemo.day001;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by X Rebecca on 2016/12/14.
 */
public class FindElement {
    WebDriver driver;
    @BeforeMethod
    public void open(){
//        chromedriver路径并打开浏览器
        System.setProperty("webdriver.chrome.driver",".//drivers//chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void testByID(){
        driver.get("http://www.baidu.com");
//        通过id定位元素
        WebElement idd=driver.findElement(By.id("kw"));
        System.out.println("百度页面的搜索框id值为："+idd);
    }
    @Test
    public void testByName(){
        driver.get("http://www.baidu.com");
//        通过name定位元素
        WebElement byname=driver.findElement(By.name("wd"));
        System.out.println("百度页面的搜索框name值为："+byname);
    }
    @Test
    public void testByLinkText(){
        driver.get("http://www.baidu.com");
//        通过linkText定位链接名 糯米
        WebElement bylinktext=driver.findElement(By.linkText("糯米"));
        System.out.println("百度糯米链接的linkText值为："+bylinktext);
    }
    @Test
    public void testCSS(){
        driver.get("http://www.baidu.com");
//        通过CSS定位百度搜索框
        WebElement bycss=driver.findElement(By.cssSelector("#kw"));
        System.out.println("百度搜索框的css值为："+bycss);
    }
    @Test
    public void testTagname(){
        driver.get("http://www.baidu.com");
//        通过Tagname定位百度搜索框
        WebElement bytagname=driver.findElement(By.tagName("input"));
        System.out.println("百度搜索框的tagname值为："+bytagname);
    }
    @Test
    public void testXpath(){
        driver.get("http://www.baidu.com");
//        通过Xpath定位百度搜索框,输入webdriver
      driver.findElement(By.xpath(".//*[@id='kw']")).sendKeys("webdriver");

    }
    @Test
    public void testList(){
        driver.get("http://www.baidu.com");
//        通过classname找到多个元素
        List<WebElement> webElements = driver.findElements(By.className("mnav"));
//        for遍历每个元素并输出
        for (int i=0;i < webElements.size(); i++){
            System.out.println(webElements.get(i));
        }
    }
    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
