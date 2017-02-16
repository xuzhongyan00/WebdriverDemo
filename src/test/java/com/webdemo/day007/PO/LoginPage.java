package com.webdemo.day007.PO;

import org.openqa.selenium.By;

/**
 * Created by X Rebecca on 2017/2/13.
 */
public class LoginPage {
//    登录界面iframe 转交 定位方式
    public static  By frameLocation = By.id("x-URS-iframe");
//    邮箱 输入框 定位方式
    public static  By emailTextFeild = By.name("email");
//    密码 输入框 定位方式
    public static  By pwdTextFeild = By.name("password");
//    登录按钮 定位方式
    public static  By loginBotton = By.id("dologin");
}
