package com.webdemo.day005;

import com.webdemo.day007.PO.LoginPage;
import com.webdemo.day007.PO.RegisterPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by X Rebecca on 2017/1/3.
 */
public class RegisterTest extends BaseCase{
    public long time = System.currentTimeMillis();

    @Test
    public void createUers()  {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        转交控制权到iframe
        WebElement iframe2= driver.findElement(LoginPage.frameLocation);
        driver.switchTo().frame(iframe2);
//        选择 注册 按钮
        driver.findElement(RegisterPage.registerButton).click();
//        获取当前句柄并判断新页面，转交控制权到新界面
       String handle1 = driver.getWindowHandle();
       for(String handles:driver.getWindowHandles()){
           if(handle1.equals(handles)){
               continue;
           }
           driver.switchTo().window(handles);
//        点击 注册字母邮箱
           driver.findElement(RegisterPage.lettersEmail).click();
//        输入邮箱名称
           driver.findElement(RegisterPage.emailName).sendKeys(String.valueOf("xu"+time));
//        输入密码
           driver.findElement(RegisterPage.pwdIpt).sendKeys("password123");
//        确认密码
           driver.findElement(RegisterPage.cfmPwdIpt).sendKeys("password123");
//        输入电话号码
           driver.findElement(RegisterPage.telephone).sendKeys(String.valueOf(time/100));
//        输入图像验证码
           driver.findElement(RegisterPage.vcodeIpt).sendKeys("abcd");
//         输入短信验证码
           driver.findElement(RegisterPage.messageCfm).sendKeys("1234");
//         点击 提交 注册
           driver.findElement(RegisterPage.RegA).click();
       }
//       校验是否出现手机验证码正确的提示
       String error1 = driver.findElement(RegisterPage.assertCfm).getText();
       System.out.println(error1);
        Assert.assertEquals(error1,"  手机验证码不正确，请重新填写");
    }

}
