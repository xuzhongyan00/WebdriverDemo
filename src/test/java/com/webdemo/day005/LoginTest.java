package com.webdemo.day005;

import com.webdemo.day007.PO.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by X Rebecca on 2017/1/4.
 */
public class LoginTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", ".//drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://mail.163.com/");
    }
    /*
    * 登录步骤的封装
    * */
    public void login(WebDriver driver,String email,String pwd){
        WebElement iframe= driver.findElement(LoginPage.frameLocation);
          driver.switchTo().frame(iframe);
          driver.findElement(LoginPage.emailTextFeild).sendKeys(email);
          driver.findElement(LoginPage.pwdTextFeild).sendKeys(pwd);
          driver.findElement(LoginPage.loginBotton).click();
      }
    /*
     * 登录成功的case
     * */
    @Test
    public void loginSuccess(){
          LoginTest loginTest = new LoginTest();
          loginTest.login(driver,"xuzhongyan00","password00");
          driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
          String  tui =driver.findElement(By.xpath("//*[@id=\"_mail_component_39_39\"]/a")).getText();
          Assert.assertEquals(tui,"退出");
      }
      /*
      * 登录时密码错误的case
      * */
    @Test
    public void loginFail(){
        LoginTest loginTest = new LoginTest();
        loginTest.login(driver,"xuzhongyan00","123456");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String pwderr = driver.findElement(By.className("ferrorhead")).getText();
        Assert.assertEquals(pwderr,"帐号或密码错误");
    }
    /*
    * 登录并发送带附件的邮件
    * */
    @Test
    public void sendEmail() throws InterruptedException {
        LoginTest loginTest = new LoginTest();
        loginTest.login(driver,"xuzhongyan00","password00");
        Thread.sleep(3000);
        driver.findElement(By.xpath("html/body/div[1]/nav/div[1]/ul/li[2]")).click();
        driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("429617044@qq.com");
        driver.findElement(By.className("O0")).sendKeys("D:\\自动化应用\\WebDriver\\chromedriver_win32.zip");
        Thread.sleep(5000);
        driver.findElement(By.className("nui-toolbar-item")).click();

    }
}
