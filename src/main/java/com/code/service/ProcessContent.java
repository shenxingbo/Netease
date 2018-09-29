package com.code.service;

import java.util.*;
import us.codecraft.webmagic.Page;

/**
 * @Author shen
 * @Date 2018/9/29
 * @Function: 提取新闻和评论的内容
 **/
public class ProcessContent {
    //
    public static  boolean getContent(Page page) {
        String newsTitle = page.getHtml().xpath("//*[@id=\"epContentLeft\"]/h1/text(0)").toString();
        String newsTime = page.getHtml().xpath("//*[@id=\"epContentLeft\"]/div[1]/text(0)").toString().trim().substring(0,19);
        List<String> newsContentList = page.getHtml().xpath("//*[@id=\"endText\"]/p/text(0)").all();
        String newsContent = new String();
        for (String str : newsContentList) {
            newsContent += str;
        }
        System.out.println(newsContent);
        //String number = page.getJson().toString();
        //System.out.println(number);
        return false;
    }
}
