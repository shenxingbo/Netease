package com.code.dao;

import com.code.db.DbConnPool;
import com.code.pojo.News;
import org.apache.commons.lang3.StringUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @Author shen
 * @Date 2018/10/3
 * @Function:
 **/
public class NewsDao {
    //插入新闻
    public static boolean insertNews(News news) {
        if (news.getNewsId() == null || StringUtils.isBlank(news.getNewsId())) {
            return false;
        }

        Connection connection = null;
        DataSource pool = null;
        try {
            pool = DbConnPool.getComboPooledDataSource();
            connection = pool.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT into news(id, url, title, content, time) values(?,?,?,?,?);");
            ps.setString(1, news.getNewsId());
            ps.setString(2, news.getNewsUrl());
            System.out.println(news.getNewsTitle());
            ps.setString(3, new String(news.getNewsTitle().getBytes(),"utf-8"));
            ps.setString(4, new String(news.getNewsContent().getBytes(), "utf-8"));
            ps.setString(5, news.getNewsTime());
            ps.executeUpdate();
            ps.close();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }

        }
               return false;
    }

    //更新新闻字段

    public static boolean updateNews() {

        return false;
    }
}
