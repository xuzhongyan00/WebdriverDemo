
package com.webdemo.day006;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;


/**
 * Created by X Rebecca on 2017/1/13.
 */

public class PhantomTest {
    @Test
    public void testPH(){
        System.setProperty("phantomjs.binary.path",".//drivers//phantomjs.exe");
        WebDriver driver = (WebDriver) new PhantomJSDriver();
        System.out.println(driver.getTitle());
        driver.quit();

    }
}

