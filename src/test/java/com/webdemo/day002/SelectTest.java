package com.webdemo.day002;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by X Rebecca on 2016/12/15.
 */
public class SelectTest {
    WebDriver driver;
    @BeforeMethod
    public void open(){
//        chromedriver路径
        System.setProperty("webdriver.chrome.driver",".//drivers//chromedriver.exe");
//        打开chrome浏览器
        driver = new ChromeDriver();
    }
    @Test
    public void selectByIndex() throws InterruptedException {
//        打开自动化应用页面
        driver.get("file:///D:/%E8%87%AA%E5%8A%A8%E5%8C%96%E5%BA%94%E7%94%A8/WebDriver/selenium_html/index.html");
//        定位多选框
       WebElement selelment =  driver.findElement(By.id("moreSelect"));
//       实例化一个Select类
        Select select = new Select(selelment);
        Thread.sleep(1000);
//        通过索引进行选择
        select.selectByIndex(3);
        Thread.sleep(1000);
//        通过 属性 Value 进行选择
        select.selectByValue("xiaomi");
        Thread.sleep(1000);
//        通过 文本 进行下拉框的选取
        select.selectByVisibleText("huawei");

    }
    @AfterMethod
    public void closed() throws InterruptedException {
//        停留三秒后退出
        Thread.sleep(2000);
        driver.quit();
    }
}
