package com.webdemo.day006;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by X Rebecca on 2017/1/11.
 */
public class LoginBase {
    public static void login(WebDriver driver, String email, String pwd){
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(pwd);
        driver.findElement(By.id("dologin")).click();
    }
}
