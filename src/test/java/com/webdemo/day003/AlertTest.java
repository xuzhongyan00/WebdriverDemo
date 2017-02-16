package com.webdemo.day003;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 * Created by X Rebecca on 2016/12/16.
 */
public class AlertTest {

        WebDriver driver;
        @BeforeMethod
        public void OpenChrome() {
//        获取安装位置并打开chrome
            System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        @Test
        public void alertTest() throws InterruptedException {
//        打开自动化测试网页
            driver.get("file://D:\\Automation App\\WebDriver\\selenium_html/index.html");
//        定位alert按钮并点击
            driver.findElement(By.className("alert")).click();
//        转交控制台给Alert
            Alert alert = driver.switchTo().alert();
//            获取界面文本信息并输出
           String altest = alert.getText();
           System.out.println(altest);
            Thread.sleep(2000);
//        点击确定
            alert.accept();
        }
        @Test
        public void confirmTest() throws InterruptedException {
//           打开网页
            driver.get("file://D:\\Automation App\\WebDriver\\selenium_html/index.html");
//          定位confirm并点击
            driver.findElement(By.xpath("//*[@id=\"confirm\"]/input")).click();
//          转交控制台
            Alert confirm = driver.switchTo().alert();
            Thread.sleep(2000);
//          点击取消
            confirm.dismiss();
//          点击确定
            confirm.accept();
        }
        @Test
        public void promptTest() throws InterruptedException {
//          打开火狐
            WebDriver driver1 =new FirefoxDriver();
            driver1.get("file://D:\\Automation App\\WebDriver\\selenium_html/index.html");
//          定位元素并点击
            driver1.findElement(By.xpath(".//*[@id='prompt']/input")).click();
            Thread.sleep(1000);
//          转换控制台
            Alert prompt = driver1.switchTo().alert();
//          输入内容
            prompt.sendKeys("new balence");
            Thread.sleep(2000);
            prompt.accept();
            prompt.accept();

        }
        @AfterMethod
        public void closed() throws InterruptedException {
            Thread.sleep(3000);
//        关闭浏览器
            driver.quit();
        }
}

