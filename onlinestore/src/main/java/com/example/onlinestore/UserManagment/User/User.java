package com.example.onlinestore.UserManagment.User;


import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public abstract class User {
    @Id
     @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String email;
    @NotNull
    private String name;


    @NotNull
    private String age;

    /*
    * 1-Buyer
    * 2-Admin
    * 3-StoreOwner
    * */



    public String getUsername() { return username; }

    public void setUsername(  String username) {
            this.username = username;
    }

    public String getPassword() {
            return password;
    }

    public String getEmail() {
        return email;
    }
    public void setPassword(String password) {
            this.password = password;
    }

    public void setEmail(String email) {
            this.email = email;
    }
    public void setName(String name) {
            this.name = name;
    }
    public String getName() {
            return name;
    }


    public String getAge() {
            return age;
    }

    public void setAge(String age) {
            this.age = age;
    }
}
