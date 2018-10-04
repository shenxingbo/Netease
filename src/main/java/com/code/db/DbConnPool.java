package com.code.db;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.io.InputStream;
import java.util.Properties;

/**
 * @Author shen
 * @Date 2018/9/30
 * @Function:
 **/
public class DbConnPool {

    private static DbConnPool dbConnPool = new DbConnPool();
    private static Properties p;
    static ComboPooledDataSource cpds;
    public DbConnPool() {
    }

    public static DbConnPool getDbConnPool() {
        return dbConnPool;
    }

    public static ComboPooledDataSource getComboPooledDataSource(){

        if (cpds != null) {
            return cpds;
        }

        cpds = new ComboPooledDataSource();
        try {
            cpds.setDriverClass(DbResource.driverClass);
        }catch (Exception e) {
            e.printStackTrace();
        }

        cpds.setJdbcUrl(DbResource.jdbcUrl);
        cpds.setUser(DbResource.user);
        cpds.setPassword(DbResource.password);
        cpds.setInitialPoolSize(DbResource.minPoolSize);
        cpds.setMaxPoolSize(DbResource.maxPoolSize);
        return cpds;
    }
}
