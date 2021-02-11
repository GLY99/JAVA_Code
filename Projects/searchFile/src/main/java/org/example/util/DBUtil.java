package org.example.util;

import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.SQLException;

// 使用单例 —— 懒汉模式
public class DBUtil {
    private static volatile DataSource dataSource = null;
    // Connection 对象是线程不安全 —— 每个线程都必须有自己的 Connection 对象
    // 一个线程只有一个 Connection 对象没有问题
    // 使用 ThreadLocal 实现，每个线程有自己的 Connection 对象
    private static final ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<Connection>(){
        @Override
        protected Connection initialValue() {
            return initConnection();
        }
    };

    private static Connection initConnection() {
        if (dataSource == null) {
            synchronized (DBUtil.class) {
                if (dataSource == null) {
                    initDataSource();
                }
            }
        }
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void initDataSource() {
        SQLiteDataSource sqLiteDataSource = new SQLiteDataSource();
        String url = "jdbc:sqlite://" + getDatabasePath();//数据库放在哪里？
        sqLiteDataSource.setUrl(url);
        dataSource = sqLiteDataSource;
    }
    //获取数据库路径
    private static String getDatabasePath() {
        try {
            //服务器中的发布版本的路径。
            String classPath = DBUtil.class.getProtectionDomain().getCodeSource().getLocation().getFile();
            File classDir = new File(URLDecoder.decode(classPath,"UTF-8"));
            String path = classDir.getParent() + File.separator + "searchFile.db";
            LogUtil.log("数据库路径为: %s",path);
            return path;
        }catch (UnsupportedEncodingException e){
            throw new RuntimeException(e);
        }
    }
    //获取数据连接
    public static Connection getConnection(){
        return  connectionThreadLocal.get();
    }

}
