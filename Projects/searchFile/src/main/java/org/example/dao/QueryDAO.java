package org.example.dao;

import org.example.model.FileMeta;
import org.example.util.DBUtil;
import org.example.util.LogUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryDAO {
    //通过关键字进行模糊匹配查询
    public List<FileMeta> query(String keyword){
        try {
            Connection c = DBUtil.getConnection();
            String sql = "SELECT id, name, pinyin,pinyin_first,path, is_directory, size, last_modified FROM file_meta WHERE name LIKE ? OR pinyin LIKE ? OR pinyin_first LIKE ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1,"%" + keyword + "%");
            ps.setString(2,"%" + keyword + "%");
            ps.setString(3,"%" + keyword + "%");
            LogUtil.log("执行 SQL: %s, %s", sql, keyword);
            List<FileMeta> result = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String pinyin = rs.getString("pinyin");
                String pinyinFirst = rs.getString("pinyin_first");
                String path = rs.getString("path");
                boolean directory = rs.getBoolean("is_directory");
                long length = rs.getLong("size");
                long lastModified = rs.getLong("last_modified");
                FileMeta file = new FileMeta(id,name,pinyin,pinyinFirst,path,directory,length,lastModified);
                result.add(file);
            }
            LogUtil.log("一共查询出%d个文件",result.size());
            return result;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    //根据路径进行精确查询
    public List<FileMeta> queryByPath(String searchPath){
        try {
            Connection c = DBUtil.getConnection();
            String sql = "SELECT id, name, pinyin,pinyin_first,path, is_directory, size, last_modified FROM file_meta WHERE path = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1,searchPath);
            LogUtil.log("执行 SQL: %s, %s", sql, searchPath);
            List<FileMeta> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String pinyin = rs.getString("pinyin");
                String pinyinFirst = rs.getString("pinyin_first");
                String path = rs.getString("path");
                boolean directory = rs.getBoolean("is_directory");
                long length = rs.getLong("size");
                long lastModified = rs.getLong("last_modified");
                FileMeta file = new FileMeta(id,name,pinyin,pinyinFirst,path,directory,length,lastModified);
                list.add(file);
            }
            LogUtil.log("一共查询出%d个文件",list.size());
            return list;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /**测试*/
    public static void main(String[] args) {
        QueryDAO queryDAO = new QueryDAO();
        System.out.println(queryDAO.query(""));
    }
}
