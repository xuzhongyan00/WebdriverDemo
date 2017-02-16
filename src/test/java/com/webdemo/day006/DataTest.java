package com.webdemo.day006;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by X Rebecca on 2017/1/11.
 */
public class DataTest {
    @DataProvider(name = "data1")
    public Object[][] dataDriver(){
        return new Object[][]{{"xuzhongyan00","password00"},{"xuhzong","password00"},{"xuzhongyan00","00000"}};
    }
    @Test(dataProvider = "data1")
    public void dataLogin(String username,String pwd){
        WebDriver driver = new FirefoxDriver();
        driver.get("http://mail.163.com");
        LoginBase.login(driver,username,pwd);

        driver.quit();
    }
}
