package org.example.dao;

import org.example.util.DBUtil;
import org.example.util.LogUtil;

import java.io.InputStream;
import java.sql.*;
import java.util.Scanner;

public class InitDAO {
    //获取SQL语句
    private String[] getSQLs(){
        InputStream is = InitDAO.class.getClassLoader().getResourceAsStream("init.sql");
        StringBuffer sb = new StringBuffer();
        Scanner scanner = new Scanner(is);
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            sb.append(line);
        }
        return sb.toString().split(";");
    }
    //初始化数据库
    public void init(){
        try {
            Connection c = DBUtil.getConnection();
            String[] sqls = getSQLs();
            //执行sql
            for (String sql : sqls){
                PreparedStatement ps = c.prepareStatement(sql);
                if (sql.startsWith("SELECT")){
                    ResultSet rs = ps.executeQuery();
                    ResultSetMetaData metaData = rs.getMetaData();
                    int colCount = metaData.getColumnCount();//查出的数据一共有几列
                    int rowCount = 0;
                    while (rs.next()){
                        StringBuffer sb = new StringBuffer("|");
                        for (int i = 1;i <= colCount;i++){
                            String value = rs.getString(i);
                            sb.append(value).append("|");
                        }
                        LogUtil.log(sb.toString());
                        rowCount++;
                    }
                    LogUtil.log("一共查询出%d行数据",rowCount);
                }else {
                    int n = ps.executeUpdate();
                    LogUtil.log("受到影响的一共有 %d 行", n);
                }
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
/**数据库初始化*/
    public static void main(String[] args) {
        InitDAO initDAO = new InitDAO();
        initDAO.init();
    }
}
