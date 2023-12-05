package com.dbs.entity;

import java.util.UUID;

/**
 * @author Jason He
 * @date 2023/12/5 16:07
 */
public class User {
    private String userID;
    private String userName;
    private String userPassword;
    private String userRole;
    private  boolean isLogin;

    public User(String userName, String userPassword, String userRole) {
        this.userID = UUID.randomUUID().toString();;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRole = userRole;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }
}
