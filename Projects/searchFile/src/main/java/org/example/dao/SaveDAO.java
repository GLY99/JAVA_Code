package org.example.dao;

import org.example.model.FileMeta;
import org.example.util.DBUtil;
import org.example.util.LogUtil;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class SaveDAO {
    public void save(List<FileMeta> list){
        try {
            Connection c = DBUtil.getConnection();
            String sql = "INSERT INTO file_meta (name, path, is_directory, pinyin, pinyin_first, size, last_modified) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql);
            for (FileMeta file : list){
                ps.setString(1,file.getName());
                ps.setString(2,file.getPath());
                ps.setBoolean(3,file.isDirectory());
                ps.setString(4, file.getPinyin());
                ps.setString(5, file.getPinyinFirst());
                ps.setLong(6, file.getLength());
                ps.setLong(7, file.getLastModifiedTimestamp());

                int i = ps.executeUpdate();
                LogUtil.log("执行语句%s，受到影响的行数是:%d",sql,i);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /**测试*/
    public static void main(String[] args) throws IOException {
        List<FileMeta> fileList = Arrays.asList(
                new FileMeta(new File("E:\\Study\\JAVA\\Code\\202010\\20201012\\Test.class")),
                new FileMeta(new File("E:\\Study\\JAVA\\Code\\202010\\20201012\\Test.java"))
        );

        SaveDAO saveDAO = new SaveDAO();
        saveDAO.save(fileList);
    }
}
