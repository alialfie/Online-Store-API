package com.example.onlinestore.UserManagment;

import com.example.onlinestore.UserManagment.Model.User;

public class LoggedUser {
    public static User loggedUser;

    LoggedUser(){ this.loggedUser = null;}
    static public void setUser(User user){
        loggedUser = user;
    }

    static public User getUser(){
        return loggedUser;
    }
}
