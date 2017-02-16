package com.webdemo.day005;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by X Rebecca on 2017/1/3.
 */
public class BaseCase {
   public WebDriver driver;
    @BeforeMethod
    public void open(){
        System.setProperty("webdriver.chrome.driver",".//drivers/chromedriver.exe");
        driver =new ChromeDriver();
        driver.get("http://mail.163.com/");

    }
    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(9000);
        driver.quit();
    }

}
