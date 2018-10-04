package com.code.dao;


import com.code.db.DbConnPool;
import com.code.pojo.User;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Author shen
 * @Date 2018/10/3
 * @Function:
 **/
public class UserDao {

    public static boolean insertUser(User user, String postId) {
        PreparedStatement ps = null;
        DataSource sources = null;
        Connection connection = null;

        try {
            sources = DbConnPool.getComboPooledDataSource();
            connection = sources.getConnection();
            ps = connection.prepareStatement("insert into user (userid, location, postid,usertype)values(?,?,?,?);");
            ps.setString(1, user.getUserId());
            ps.setString(2, user.getLocation());
            ps.setString(3, postId);
            ps.setString(4, user.getUserType());
            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (ps != null) {
                    ps.close();
                }

                if (connection != null) {
                    connection.close();
                }

            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    public static boolean selectUser(User user) {
        PreparedStatement ps = null;
        DataSource sources = null;
        Connection connection = null;
        try {
            sources = DbConnPool.getComboPooledDataSource();
            connection = sources.getConnection();
            ps = connection.prepareStatement("select * from user where userid=?");
            ps.setString(1, user.getUserId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String userId = rs.getString("userid");
                if (userId.equals(user.getUserId())) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
