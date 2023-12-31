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
    private UserType userRole;
    private  boolean isLogin;
    private boolean isCurrentUser;

    public User(String userName, String userPassword, UserType userRole) {
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

    public UserType getUserRole() {
        return userRole;
    }

    public void setUserRole(UserType userRole) {
        this.userRole = userRole;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public boolean isCurrentUser() {
        return isCurrentUser;
    }

    public void setCurrentUser(boolean currentUser) {
        isCurrentUser = currentUser;
    }

    public enum UserType
    {
        user,admin;
    }
}

