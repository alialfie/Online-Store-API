package com.example.onlinestore.UserManagment.User;

public class LoggedUser {
    static User loggedUser;

    LoggedUser(){ this.loggedUser = null;}
    public void setUser(User user){
        this.loggedUser = user;
    }

    public User getUser(){
        return this.loggedUser;
    }
}
