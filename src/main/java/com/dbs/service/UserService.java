package com.dbs.service;

import com.dbs.entity.User;
import com.dbs.entity.User.UserType;
import java.util.List;

/**
 * @author Jason He
 * @date 2023/12/5 17:09
 */
public class UserService {
    private List<User> userList;

    public UserService() {
    }

    public UserService(List<User> userList) {
        this.userList = userList;
    }

    public void Register(String userName, String userPassword, UserType userRole){
        //parameter validation
        if(userName==null || userName.isEmpty()) {
            System.out.println("User name can't be empty!");
            return;
        }
        if(userPassword==null || userPassword.isEmpty()) {
            System.out.println("User Password can't be empty!");
            return;
        }
        //check the user if existed
        for(User user:userList){
            if(user.getUserName()==userName){
                System.out.println("User name has been registered.");
                return;
            }
        }
        //add new user to user list
        User user=new User(userName,userPassword,userRole);
        userList.add(user);

        System.out.println(String.format("%s %s successfully registered.",user.getUserRole().toString(),
                user.getUserName()));
    }
    public void Login(String userName,String userPassword){
        //parameter validation
        if(userName==null || userName.isEmpty()) {
            System.out.println("User name can't be empty!");
            return;
        }
        if(userPassword==null || userPassword.isEmpty()) {
            System.out.println("User Password can't be empty!");
            return;
        }
        //check the user if registered
        boolean blnFound=false;
        for(User user:userList){
            if(user.getUserName().equalsIgnoreCase(userName)
                    && user.getUserPassword().equals(userPassword)){
                blnFound=true;
                user.setCurrentUser(true);
                System.out.println(String.format("%s %s successfully logged in.",user.getUserRole().toString(),
                        user.getUserName()));
                return;
            }
        }
        //if the user not found, prompt register first
        if(!blnFound){
            System.out.println("Invalid user name or password.");
        }
    }

    public User getCurrentUser() {
        for (User user : userList) {
            if (user.isCurrentUser() == true) {
                return user;
            }
        }
        return null;
    }
}
