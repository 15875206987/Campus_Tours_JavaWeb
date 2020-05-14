package com.util;

/**
 * 该类是数据库操作类，封装了druid数据库连接池的操作
 * @author kaitingliu
 * 功能：
 * 1.获取连接
 * 2.释放资源
 * */

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtilsByDruid {
    static DataSource ds;
    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("D:\\IdeaWorkspace\\SCUT_Tour_JavaWeb\\src\\druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws Exception {
        return ds.getConnection();
    };
    public static void close(Connection connection) throws SQLException {
            connection.close();
    }
}
