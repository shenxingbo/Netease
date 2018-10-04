package com.code.service;

import com.code.db.DbConnPool;
import com.mysql.cj.api.mysqla.result.Resultset;
import org.junit.Test;
import us.codecraft.webmagic.Spider;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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



    //数据库连接测试
    @Test
    public void testConnetction() throws SQLException {
        DataSource pool = DbConnPool.getComboPooledDataSource();
        Connection connection = pool.getConnection();
        PreparedStatement ps = connection.prepareStatement("select * from news");

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("id"));
        }
        connection.close();
    }

}
