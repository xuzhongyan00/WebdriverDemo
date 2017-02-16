package com.webdemo.day006;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by X Rebecca on 2017/1/11.
 */
public class ChromeConfigTest {
    @Test
    public void chromeTest(){
        String downloadFilepath ="D:\\";
        HashMap<String ,Object> chromeconfig = new HashMap<String, Object>();
//        下载时弹框提醒，0为不弹框
        chromeconfig.put("profile.default_content_settings.popups",0);
        chromeconfig.put("download.default_directory",downloadFilepath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs",chromeconfig);
        System.setProperty("webdriver.chrome.driver",".//drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://rj.baidu.com/soft/detail/13478.html?ald");
        driver.findElement(By.className("normal_download")).click();

    }
}
