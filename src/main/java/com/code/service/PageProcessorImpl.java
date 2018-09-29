package com.code.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @Author shen
 * @Date 2018/9/29
 * @Function:
 **/
public class PageProcessorImpl implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    public void process(Page page) {


//        //列表页
//        if (page.getUrl().regex("http://gov\\.163\\.com/special/\\D+\\d*/").match()) {
//            System.out.println("列表");
//            page.addTargetRequests(ProcessUrl.getTitleUrl(page));
//            page.addTargetRequests(ProcessUrl.getTitlePageNumberUrl(page));
//
//            //新闻内容页面
//        }else if (page.getUrl().regex("http://gov\\.163\\.com/\\d{2}/\\d{4}/\\d{2}/\\w+\\.html").match()) {
//            System.out.println("新闻");
//            ProcessContent.getContent(page);
//        // 评论页码
//        }else if (page.getUrl().regex("dd").match()) {
//
//
//
//        }else { //新闻评论
//            System.out.println("a*********************");
//            System.out.println(page.getHtml());
//        }

    }

    @Override
    public Site getSite() {
        return site;
    }

}
