package com.code.dao;

import com.code.db.DbConnPool;
import com.code.pojo.Comment;
import com.code.pojo.CommentsEntity;
import com.code.pojo.User;
import org.apache.commons.lang3.StringUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

/**
 * @Author shen
 * @Date 2018/10/3
 * @Function:
 **/
public class CommentDao {
    public static boolean insertComments(CommentsEntity ce) {
        Connection connection = null;
        DataSource pool = null;
        PreparedStatement ps = null;

        try {
            pool = DbConnPool.getComboPooledDataSource();
            connection = pool.getConnection();

            ps = connection.prepareStatement("insert into `comment` (`against`, anonymous, " +
                    "buildLevel, commentId, content, createTime, favCount, ip, location, postid, newsid) values(?,?,?,?,?,?,?,?,?,?,?);");
            for (Map.Entry<String, Comment> entry : ce.getComments().entrySet()) {
                Comment comment = entry.getValue();
                if (comment.getCommentId() == null || StringUtils.isBlank(comment.getCommentId())) {
                    continue;
                }
                String postId = comment.getPostId();
                String  newsId = postId.substring(0, postId.indexOf("_"));
                ps.setString(1, comment.getAgainst());
                ps.setString(2, comment.getAnonymous());
                ps.setString(3, comment.getBuildLevel());
                ps.setString(4, comment.getCommentId());
                ps.setString(5, comment.getContent());

                ps.setString(6, comment.getCreateTime());
                ps.setString(7, comment.getFavCount());
                ps.setString(8, comment.getIp());
                ps.setString(9, comment.getUser().getLocation());
                ps.setString(10, comment.getPostId());
                ps.setString(11, newsId);
                ps.executeUpdate();
                UserDao.insertUser(comment.getUser(), comment.getPostId());
            }

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (connection != null) {
                    ps.close();
                    connection.close();

                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false;
    }

}
