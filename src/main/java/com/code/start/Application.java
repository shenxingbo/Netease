package com.code.start;

import com.code.service.PageProcessorImpl;
import us.codecraft.webmagic.Spider;

/**
 * @Author shen
 * @Date 2018/9/29
 * @Function: 这是爬虫的主函数
 **/
public class Application {
    public static void main(String[] args) {
        System.getProperties().setProperty("webdriver.chrome.driver",
                "D:\\chromedriver\\chromedriver.exe");

        String[] urls = new String[3];
        urls[0]="http://gov.163.com/special/zwzx_n/";
        urls[1]="http://gov.163.com/special/locality/";
        urls[2]="http://gov.163.com/special/yangqi/";

        Spider.create(new PageProcessorImpl()).addUrl("http://gov.163.com/14/0523/10/9SU4J3E000234IGH.html").thread(5).run();
    }
}
