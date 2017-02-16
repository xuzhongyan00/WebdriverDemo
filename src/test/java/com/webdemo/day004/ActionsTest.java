package com.webdemo.day004;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Administrator on 2016/12/27.
 */
public class ActionsTest {
    WebDriver driver;
    @BeforeMethod
    public void OpenChrome() {
//       获取安装位置并打开chrome
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void contextClick(){
//        打开百度
        driver.get("http://www.baidu.com");
//        定位到百度一下按钮
        WebElement elment = driver.findElement(By.id("su"));
//        实例化一个Actions
        Actions actions = new Actions(driver);
//        移动到百度一下，并右键点击
        actions.contextClick(elment).perform();
//        移动到定位元素，并双击
        actions.doubleClick(elment).perform();
    }
    @Test
    public void testMoveToElement(){
        driver.get("http://www.baidu.com");
//        定位到 更多产品
       WebElement element = driver.findElement(By.name("tj_briicon"));
//       实例化Actions
        Actions builder = new Actions(driver);
//        鼠标移动到 更多产品
        builder.moveToElement(element).perform();
       }
    @Test
        public void testDragAndDropBy(){
//        打开指定网页
        driver.get("file:///D:/selenium_html/dragAndDrop.html");
//        定位到红色块
        WebElement drag = driver.findElement(By.xpath(".//*[@id='drag']"));
//        实例化
        Actions builder = new Actions(driver);
//        拖动到x,y值的地方
        builder.dragAndDropBy(drag,100,300).perform();
       }
    @Test
       public void testClickAndHold(){
//           打开指定网页
           driver.get("file:///D:/selenium_html/dragAndDrop.html");
//           定位到红色块和文字栏
          WebElement element01 = driver.findElement(By.id("drag"));
          WebElement element02 = driver.findElement(By.xpath("/html/body/h1"));
//          实例化
          Actions builder = new Actions(driver);
//          点击并拖动到文字栏并释放
          builder.clickAndHold(element01).moveToElement(element02).release(element01).perform();
       }
    @Test
       public void testMultiple(){
//           打开指定页面
           driver.get("file:///D:/selenium_html/index.html");
//           实例化
           Actions builder = new Actions(driver);
//           定位到多选框
           WebElement select = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
//           在options中放入多个元素
           List<WebElement> options = select.findElements(By.tagName("option"));
//           点击拖选多个连续选项
           Action multipleSelect = builder.keyDown(Keys.SHIFT).click(options.get(0)).click(options.get(2)).build();
//           执行
           multipleSelect.perform();
       }
    @Test
       public void testUPload(){
//           打开指定网页
           driver.get("file:///D:/selenium_html/index.html");
//           上传一个文件夹 问题：页面能够显示文件夹的名称，但是不知道给如何确认是否真的上传了文件夹的文件
           driver.findElement(By.id("load")).sendKeys("D:\\FFOutput");
    }

    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(9000);
//        关闭浏览器
        driver.quit();
    }
}