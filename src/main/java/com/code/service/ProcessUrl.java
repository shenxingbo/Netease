package com.code.service;

import us.codecraft.webmagic.Page;
import java.util.*;

/**
 * @Author shen
 * @Date 2018/9/29
 * @Function: 提取出各种url
 **/
public class ProcessUrl {

    //新闻标题的url
    public static List<String> getTitleUrl(Page page) {
        List<String> result = page.getHtml().xpath("/html/body/div[4]/div[1]").links().regex("http://gov\\.163\\.com/\\d{2}/\\d{4}/\\d{2}/\\w+\\.html").all();
        return result;
    }

    //新闻列表下面数字tag的url
    public static List<String> getTitlePageNumberUrl(Page page) {
        List<String> result = page.getHtml().xpath("/html/body/div[4]/div[1]").links().regex("http://gov\\.163\\.com/special/\\D+\\d+/").all();
        if (result.size() > 0) {
            result.remove(result.size()-1);
        }
        result.add(page.getUrl().toString());
        return result;
    }

//    //根据新闻的url返回新闻的id
//    public static String getNewsId(String url) {
//
//    }




}
