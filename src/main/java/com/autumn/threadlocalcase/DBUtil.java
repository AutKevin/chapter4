package com.autumn.threadlocalcase;
/**
 * Created by Administrator on 2018/11/28.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @program: DBUtil
 * @description: 数据库配置工具类
 * @author: qiuyu
 * @create: 2018-11-28 05:52
 **/
public class DBUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(DBUtil.class);
    //数据库配置
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://www.52zt.online:3306/demo2";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "autumn-19950926";

    //定义一个数据库连接
    //private static Connection conn = null;
    //定义一个用于放置数据库连接的局部线程变量(是每个线程拥有自己的连接)
    private static ThreadLocal<Connection> connContainer = new ThreadLocal<Connection>();

    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection(){
        Connection conn = connContainer.get();   //从ThreadLocal中获取conn

        try {
            if (conn == null) {   //从ThreadLocal中拿到的conn如果为null
                /*JDBC获取连接*/
                Class.forName(DRIVER);
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }
        } catch (Exception e) {
            e.printStackTrace();  //在catlina.out中打印
            LOGGER.error("get connection failure",e);
        }finally {
            connContainer.set(conn);
        }
        return conn;
    }

    /**
     * 关闭数据库连接
     */
    public static void closeConnection(){
        Connection conn = connContainer.get();   //从ThreadLocal中获取conn
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                LOGGER.error("close connection failure",e);
            }finally {
                connContainer.remove();   //从ThreadLocal中删除当前线程的conn
            }
        }
    }
}
