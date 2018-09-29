package com.code.service;

import org.junit.Test;
import us.codecraft.webmagic.Spider;

/**
 * @Author shen
 * @Date 2018/9/29
 * @Function:
 **/
public class ProcessContentTest {


    @Test
    public void testGetContent() {
        Spider.create(new PageProcessorImpl()).addUrl("http://comment.tie.163.com/9LHMOLGJ00234IGH.html").thread(5).run();
    }
}
