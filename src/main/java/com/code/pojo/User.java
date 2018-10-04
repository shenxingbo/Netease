package com.code.pojo;

/**
 * @Author shen
 * @Date 2018/9/30
 * @Function:
 **/
public class User {
    private String location;
    private String userId;
    private String userType;

    public User() {
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public User(String location, String userId, String userType) {
        this.location = location;
        this.userId = userId;
        this.userType = userType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
