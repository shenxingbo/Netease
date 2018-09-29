package com.code.start;

import com.code.service.PageProcessorImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import us.codecraft.webmagic.Spider;

/**
 * @Author shen
 * @Date 2018/9/29
 * @Function: 这是爬虫的主函数
 **/
public class Application {
    public static void main(String[] args) {
        String[] urls = new String[3];
        urls[0]="http://gov.163.com/special/zwzx_n/";
        //urls[1]="http://gov.163.com/special/locality/";
        //urls[2]="http://gov.163.com/special/yangqi/";

        //Spider.create(new PageProcessorImpl()).addUrl(urls[0]).thread(5).run();


        System.getProperties().setProperty("webdriver.chrome.driver", "D:\\chromedirver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://huaban.com/");
        WebElement webElement = webDriver.findElement(By.xpath("/html"));
        System.out.println(webElement.getAttribute("outerHTML"));
        webDriver.close();
    }
}
