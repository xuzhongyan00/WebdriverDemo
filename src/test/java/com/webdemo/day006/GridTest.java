package com.webdemo.day006;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by X Rebecca on 2017/1/11.
 */
public class GridTest {
    @Test
    public void testGrid() throws MalformedURLException, InterruptedException {
//        创建一个DesiredCapabilities 类型
        DesiredCapabilities firefoxdc = DesiredCapabilities.firefox();
//         实例化一个driver
        WebDriver driver = new RemoteWebDriver(new URL("http://10.125.101.130:5555/wd/hub"),firefoxdc);
        driver.get("http:\\www.baidu.com");
        Thread.sleep(5000);
        driver.quit();

    }
}
