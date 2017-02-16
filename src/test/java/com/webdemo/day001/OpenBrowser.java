package com.webdemo.day001;


        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.ie.InternetExplorerDriver;
        import org.testng.annotations.AfterMethod;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.BeforeTest;
        import org.testng.annotations.Test;

        import java.util.List;
        import java.util.Set;
/**
 * Created by X Rebecca on 2016/12/14.
 */
public class OpenBrowser {
    WebDriver driver;
    @Test
    public void OpenFirefox(){
//        打开火狐
        driver = new FirefoxDriver();
    }
    @Test
    public void OpenFirefox2(){
//        打开火狐,非默认安装
        System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        driver =new FirefoxDriver();
    }
    @Test
    public void OpenChrome(){
//        获取安装位置并打开chrome
        System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
        driver =new ChromeDriver();
    }
    @Test
    public void OpenIe(){
//        获取安装位置并打开IE
        System.setProperty("webdriver.ie.driver",".\\drivers\\IEDriverServer.exe");
        driver =new InternetExplorerDriver();
    }
    /*@AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(3000);
//        关闭火狐
        driver.quit();
    } */
}
