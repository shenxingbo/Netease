package com.code.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author shen
 * @Date 2018/9/30
 * @Function:
 **/
public class CommentsEntity {
    private List<String> commentIds;

    public Map<String, Comment> getComments() {
        return comments;
    }

    public void setComments(Map<String, Comment> comments) {
        this.comments = comments;
    }

    private Map<String, Comment> comments;
    private String newListSize;

    public List<String> getCommentIds() {
        return commentIds;
    }

    public void setCommentIds(List<String> commentIds) {
        this.commentIds = commentIds;
    }



    public String getNewListSize() {
        return newListSize;
    }

    public void setNewListSize(String newListSize) {
        this.newListSize = newListSize;
    }
}
