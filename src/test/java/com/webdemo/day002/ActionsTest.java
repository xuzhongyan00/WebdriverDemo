package com.webdemo.day002;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by X Rebecca on 2016/12/15.
 */
public class ActionsTest {
    WebDriver driver;
    @BeforeMethod
    public void open(){
//        chromedriver路径
        System.setProperty("webdriver.chrome.driver",".//drivers//chromedriver.exe");
//        打开chrome浏览器
        driver = new ChromeDriver();
    }
    @Test
    public void clickTest(){
//        打开百度页面
        driver.get("http://www.baidu.com");
//        定位元素并点击糯米
        driver.findElement(By.name("tj_trnuomi")).click();
    }
    @Test
    public void sendkeysTest() throws InterruptedException {
//        打开百度页面
        driver.get("http://www.baidu.com");
//        定位搜索框
        WebElement element = driver.findElement(By.id("kw"));
//        输入webdriver
        element.sendKeys("webdriver");
        Thread.sleep(2000);
//        清除内容webdriver
        element.clear();
    }
//
    @Test
    public void getText(){
//        打开百度页面
        driver.get("http://www.baidu.com");
//        定位右上角所有元素
        List<WebElement> WebElments=driver.findElements(By.xpath("//*[@id=\"u1\"]/a"));
//        遍历右上角所有元素
        for(int i=0;i<WebElments.size();i++){
//            获取每个元素text值
            String text1= WebElments.get(i).getText();
//            输出每个值
            System.out.println(text1);
        }
    }
    @Test
    public void getTagName(){
        //        打开百度页面
        driver.get("http://www.baidu.com");
//        获取搜索框的tagname属性
       String tagname =  driver.findElement(By.id("kw")).getTagName();
//       输出
       System.out.println(tagname);
//       校验
        Assert.assertEquals(tagname,"input");
    }

    @Test
    public void getMaxl(){
        //        打开百度页面
        driver.get("http://www.baidu.com");
//        获取搜索框的maxlength属性
        String maxl =  driver.findElement(By.id("kw")).getAttribute("maxlength");
//       输出
        System.out.println(maxl);
//       校验
        Assert.assertEquals(maxl,"255");
    }
     @Test
     public void isDisplayed(){
         //        打开百度页面
         driver.get("http://www.baidu.com");
//         查看百度一下是否显示
         boolean aa =driver.findElement(By.id("su")).isDisplayed();
//         校验
         Assert.assertTrue(aa);
     }
     @Test
     public void isSelected(){
         //        打开index页面
         driver.get("file:///D:/%E8%87%AA%E5%8A%A8%E5%8C%96%E5%BA%94%E7%94%A8/WebDriver/selenium_html/index.html");
//         检查 volvo是否被选中
         WebElement element = driver.findElement(By.xpath("//*[@id=\"radio\"]/input[1]"));
//         点击单选框
         element.click();
         boolean bb = element.isSelected();
//         校验
         Assert.assertTrue(bb);
     }
     @Test
     public void isEnable(){
//         打开index页面
         driver.get("file:///D:/%E8%87%AA%E5%8A%A8%E5%8C%96%E5%BA%94%E7%94%A8/WebDriver/selenium_html/index.html");
        boolean cc =  driver.findElement(By.name("buttonhtml")).isEnabled();
        Assert.assertFalse(cc);
     }
     @Test
     public void screenShotTest() throws IOException {
//        打开百度
         driver.get("http://www.baidu.com");
//         使用File类进行截图并输出
         File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//         截图保存的路径
         FileUtils.copyFile(file,new File(".//logs//screenShots//test1.png"));

     }
    @AfterMethod
    public void closed() throws InterruptedException {
//        停留三秒后退出
        Thread.sleep(3000);
        driver.quit();
    }
}
