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
        String newsUrl = page.getUrl().toString();
        String newsId = newsUrl.substring(newsUrl.lastIndexOf("/")+1, newsUrl.lastIndexOf("."));

        String contentUrl = "http://comment.api.163.com/api/v1/products/a2869674571f77b5a0867c3d71db5856/threads/"+newsId+"/comments/newList?ibc=newspc&limit=30&showLevelThreshold=72&headLimit=1&tailLimit=2&offset=0";
        page.addTargetRequest(contentUrl);
        return false;
    }
}
