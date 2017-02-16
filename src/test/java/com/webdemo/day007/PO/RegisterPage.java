package com.webdemo.day007.PO;

import org.openqa.selenium.By;

/**
 * Created by X Rebecca on 2017/2/13.
 */
public class RegisterPage {
    // 去注册 按钮 定位方式
    public static By registerButton = By.id("changepage");
    // 选择 字母邮箱注册按钮 定位方式
    public static  By lettersEmail = By.xpath(".//*[@id='tabsUl']/li[1]/a");
    // 字母邮箱名称输入框 定位方式
    public static  By emailName = By.id("nameIpt");
    //        输入密码 定位方式
    public static  By pwdIpt = By.id("mainPwdIpt");
    //        确认密码 定位方式
    public static  By cfmPwdIpt = By.id("mainCfmPwdIpt");
    //        输入电话号码 定位方式
    public static  By telephone = By.id("mainMobileIpt");
    //        输入图像验证码 定位方式
    public static  By vcodeIpt =By.id("vcodeIpt");
    //         输入短信验证码 定位方式
    public static  By messageCfm = By.id("mainAcodeIpt");
    //         点击 提交 注册 定位方式
    public static  By RegA = By.id("mainRegA");
    //       校验是否出现手机验证码正确的提示 定位方式
    public static  By assertCfm = By.xpath("//*[@id=\"m_mainAcode\"]/span");
}
