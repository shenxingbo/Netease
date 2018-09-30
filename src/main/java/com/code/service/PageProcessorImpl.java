package com.code.service;

import com.alibaba.fastjson.JSONObject;
import com.code.pojo.Comment;
import com.code.pojo.CommentsEntity;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Json;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author shen
 * @Date 2018/9/29
 * @Function:
 **/
public class PageProcessorImpl implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    public void process(Page page) {

        //列表页
        if (page.getUrl().regex("http://gov\\.163\\.com/special/\\D+\\d*/").match()) {
            System.out.println("列表");
            page.addTargetRequests(ProcessUrl.getTitleUrl(page));
            page.addTargetRequests(ProcessUrl.getTitlePageNumberUrl(page));

            //新闻内容页面
        }else if (page.getUrl().regex("http://gov\\.163\\.com/\\d{2}/\\d{4}/\\d{2}/\\w+\\.html").match()) {
            System.out.println("新闻");
            ProcessContent.getContent(page);
        } else { //新闻评论
            System.out.println("pppp");
            try {

                String str = page.getHtml().xpath("//body/text(0)").toString();
                CommentsEntity ce = JSONObject.parseObject(str, CommentsEntity.class);

                for (Map.Entry<String, Comment> entry : ce.getComments().entrySet()) {
                    System.out.println(entry.toString());
                }

                //循环取评论数据
                Integer size = Integer.parseInt(ce.getNewListSize());
                String url = page.getUrl().toString();
                Integer index = Integer.parseInt(url.substring(url.lastIndexOf("=") +1));


                if (0 != size && index == 0) {
                    System.out.println("取评论数据");

                    System.out.println("转变之前 " + url);
                    url = url.substring(0, url.lastIndexOf("=") + 1);
                    System.out.println(url);
                    int count = size / 30;
                    if (size % 30 != 0) {
                        count++;
                    }
                    for (int i = 1; i < count; i++) {
                        page.addTargetRequest(url+ (i * 30));
                    }
                }


            }catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public Site getSite() {
        return site;
    }

}
