package autoframework.action;


import autoframework.driver.SeleniumDriver;
import autoframework.element.WebElementUtils;
import autoframework.logger.LoggerControler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 米阳 on 2016/6/18.
 */
public class Action extends SeleniumDriver {
    final static LoggerControler log = LoggerControler.getLogger(Action.class);


    public static void click(By by, String text) {
        WebElementUtils.findElement(by).click();
        log.info(text);

    }

    public static void sendText(By by, String text) {
        WebElement element = WebElementUtils.findElement(by);
        element.clear();
        element.sendKeys(text);
        log.info("在" + by + "输入" + text);
    }

    public static String getText(By by) {
        String text = WebElementUtils.findElement(by).getText();
        log.info("获取了" + by + "文本为" + text);
        return text;
    }

    public static ArrayList getTexts(By by) {
        ArrayList arrayList = new ArrayList();
        List<WebElement> list = WebElementUtils.findElements(by);
        for (int j = 0; j < list.size(); j++) {
            String text = list.get(j).getText();
            arrayList.add(text);
        }
        return arrayList;
    }
}
