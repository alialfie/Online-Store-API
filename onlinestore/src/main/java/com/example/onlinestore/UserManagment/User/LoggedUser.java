package com.example.onlinestore.UserManagment.User;

public class LoggedUser {
    static User loggedUser;

    LoggedUser(){ this.loggedUser = null;}
    static public void setUser(User user){
        loggedUser = user;
    }

    static public User getUser(){
        return loggedUser;
    }
}
