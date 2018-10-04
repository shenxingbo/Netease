package com.code.db;

/**
 * @Author shen
 * @Date 2018/9/29
 * @Function: 提供数据库连接
 **/
public class DbResource {
      static String driverClass = "com.mysql.jdbc.Driver";
      //static String jdbcUrl = "jdbc:mysql://localhost:3306/neteasenews";
      static String jdbcUrl = "jdbc:mysql://39.105.42.103:3306/neteasenews";
      static String user = "root";
      static String password = "root";
      static Integer minPoolSize = 5;
      static Integer maxPoolSize = 100;

}
