package autoframework.driver;


import autoframework.logger.LoggerControler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;


public class SeleniumDriver {
    final static LoggerControler log = LoggerControler.getLogger(SeleniumDriver.class);


    public static WebDriver driver;

    public static WebDriver openBrowser(String browser) {
        String path = System.getProperty("user.dir");
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", path + "/driver/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals("ie")) {
            System.setProperty("webdriver.ie.driver", path + "/driver/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        } else {
            log.error("你传入的浏览器名有误为：" + browser);
//            System.out.println("你传入的浏览器名有误为：" + browser);
        }
        return driver;
    }

    public static void closed() {
        driver.quit();
        log.info("关闭浏览器！！");
    }
}
