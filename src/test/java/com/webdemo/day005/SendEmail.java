package com.webdemo.day005;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

/**
 * Created by X Rebecca on 2017/1/5.
 */
public class SendEmail {
    WebDriver driver;
    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", ".//drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://mail.163.com/");
    }
    public void sendEmail(){
        LoginTest loginTest =new LoginTest();
        loginTest.loginSuccess();
    }
}
