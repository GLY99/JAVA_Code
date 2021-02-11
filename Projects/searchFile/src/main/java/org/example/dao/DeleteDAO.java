package org.example.dao;

import org.example.util.DBUtil;
import org.example.util.LogUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteDAO {
    public void delete(List<Integer> idList){
        try {
            Connection c = DBUtil.getConnection();
            List<String> placeholderList = new ArrayList<>();
            for (Integer id : idList){
                placeholderList.add("?");
            }
            String placeholder = String.join(",",placeholderList);
            String sql = "DELETE FROM file_meta WHERE id IN(" + placeholder + ")";
            PreparedStatement ps = c.prepareStatement(sql);
            for (int i = 0;i < idList.size();i++){
                int id = idList.get(i);
                ps.setInt(i + 1,id);
            }
            int n = ps.executeUpdate();
            LogUtil.log("执行SQL:%s,受到影响的行数有%d行",sql,n);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**测试*/
    public static void main(String[] args) throws SQLException {
        List<Integer> idList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        DeleteDAO dao = new DeleteDAO();
        dao.delete(idList);
    }
}
